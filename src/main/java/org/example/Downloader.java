package org.example;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.expr.LambdaExpr;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.ArrayList;

import java.io.File;

public class Downloader {

    private class SignatureInfo {
        //private boolean parseCorrect;
        private String packge;
        private String name;

        private String className;

        private String methodName;
        private String returnValue;
        private final ArrayList<String> args = new ArrayList<>();

        SignatureInfo(String signature) {
            parse(signature);
        }

        private void parse(String signature) {
            int index = signature.indexOf(":");
            String packageWithName = signature.substring(0, index);
            String method = signature.substring(index + 2);

            index = packageWithName.lastIndexOf(".");
            packge = packageWithName.substring(0, index);
            name = packageWithName.substring(index + 1);

            index = method.lastIndexOf(" ");
            returnValue = method.substring(0, index);
            method = method.substring(index + 1);
//            index = returnValue.lastIndexOf(".");
//            returnValue = returnValue.substring(index + 1);

            index = method.lastIndexOf("(");
            methodName = method.substring(0, index);
            method = method.substring(index + 1, method.length() - 1);

            index = method.indexOf(",");
            while (index != -1) {
                String arg = method.substring(0, index);
                method = method.substring(index + 1);
//                index = arg.lastIndexOf(".");
//                if (index != -1) {
//                    arg = arg.substring(index + 1);
//                }
                args.add(arg);
                index = method.indexOf(",");
            }
            if (method.length() != 0) {
                String arg = method;
//                index = arg.lastIndexOf(".");
//                if (index != -1) {
//                    arg = arg.substring(index + 1);
//                }
                args.add(arg);
            }
        }
    }

    private SignatureInfo info;
    private String result = null;

    private class MethodNamePrinterLambda extends VoidVisitorAdapter<Void> {
        private int counter = 0;
        private final int lambdaNumber;

        private MethodNamePrinterLambda(int lambdaNumber) {
            this.lambdaNumber = lambdaNumber;
        }

        @Override
        public void visit(LambdaExpr lambda, Void arg) {
            if (lambdaNumber == counter) {
                result = lambda.toString();
            }
            counter++;
        }
    }

    private class MethodNamePrinter extends VoidVisitorAdapter<Void> {
        @Override
        public void visit(MethodDeclaration methodDeclaration, Void arg) {
            String methodReturnValue = methodDeclaration.getTypeAsString();
            int ind = methodReturnValue.indexOf("<");
            if (ind > -1) {
                methodReturnValue = methodReturnValue.substring(0, ind);
            }
            if (methodDeclaration.getNameAsString().equals(info.methodName)
                    && (info.returnValue.contains(methodReturnValue)
                    || info.returnValue.equals("java.lang.Object"))) {
                NodeList<Parameter> args = methodDeclaration.getParameters();
                if (args.size() != info.args.size()) {
                    return;
                }
                for (int i = 0; i < args.size(); i++) {
                    if (info.args.get(i).equals("java.lang.Object")) {
                        continue;
                    }
                    String argi2 = args.get(i).getTypeAsString();
                    ind = argi2.indexOf("<");
                    if (ind > -1) {
                        argi2 = argi2.substring(0, ind);
                    }
//                            System.out.println(info.args.get(i));
//                            System.out.println(argi2);
                    if (!info.args.get(i).contains(argi2)) {
                        return;
                    }
                }
                result = methodDeclaration.toString();
            }
        }

        @Override
        public void visit(ConstructorDeclaration methodDeclaration, Void arg) {
            NodeList<Parameter> args = methodDeclaration.getParameters();
            if (args.size() != info.args.size()) {
                return;
            }
            for (int i = 0; i < args.size(); i++) {
                if (info.args.get(i).equals("java.lang.Object")) {
                    continue;
                }
                String argi2 = args.get(i).getTypeAsString();
                int ind = argi2.indexOf("<");
                if (ind > -1) {
                    argi2 = argi2.substring(0, ind);
                }
//                            System.out.println(info.args.get(i));
//                            System.out.println(argi2);
                if (!info.args.get(i).contains(argi2)) {
                    return;
                }
            }
            result = methodDeclaration.toString();
        }

        @Override
        public void visit(ClassOrInterfaceDeclaration md, Void arg) {
            super.visit(md, arg);
            if (md.getNameAsString().equals(info.className)) {
                if (info.methodName.equals("<init>")) {
                    for (ConstructorDeclaration constructorDeclaration : md.getConstructors()) {
                        this.visit(constructorDeclaration, arg);
                    }
                } else {
                    for (MethodDeclaration methodDeclaration : md.getMethods()) {
                        this.visit(methodDeclaration, arg);
                    }
                }
            }
        }
    }
    public String find(String directoryPath, String signature) {
        String FILE_PATH = directoryPath + "/";
        info = new SignatureInfo(signature.substring(1, signature.length() - 1));
        String packagePath = info.packge;
        packagePath = packagePath.replace(".", "/");
        String[] names = info.name.split("\\$");
        StringBuilder name = new StringBuilder(names[0]);
        int index = 1;
        FILE_PATH += packagePath + "/" + name + ".java";
        boolean parsing = false;
        CompilationUnit cu = null;
        while (!parsing) {
            try {
                cu = StaticJavaParser.parse(new File(FILE_PATH));
                parsing = true;
            } catch (Exception e) {
                if (index == names.length) {
                    return null;
                }
                name.append("$").append(names[index]);
                FILE_PATH = directoryPath + "/" + packagePath + "/" + name + ".java";
                index++;
            }
        }

        String[] methodNames = info.methodName.split("\\$");
        if (methodNames[0].equals("lambda")) {
            try {
                int lambdaNumber = Integer.parseInt(methodNames[methodNames.length - 1]);
                VoidVisitor<Void> methodNamePrinterLambda = new MethodNamePrinterLambda(lambdaNumber);
                methodNamePrinterLambda.visit(cu, null);
                String ans = result;
                if (ans != null) {
                    result = null;
                    return ans;
                }
            } catch (Exception e) {
                return null;
            }
        }

        info.className = names[names.length - 1];
        index = names.length - 2;
        VoidVisitor<Void> methodNameVisitor = new MethodNamePrinter();
        for (int i = index; i > -2; i--) {
            methodNameVisitor.visit(cu, null);
            String ans = result;
            if (ans != null) {
                result = null;
                return ans;
            }
            if (i > -1) {
                info.className = names[i] + "$" + info.className;
            }
        }
        return null;
    }
}

