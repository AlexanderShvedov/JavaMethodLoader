package org.example;

public class LambdaApp {

    static int x = 20;
    static int y = 10;
    public static void main(String[] args) {
        System.out.println(func() + func(10) + notfunc());
    }

    public static int func() {
        Operation op = ()-> x+y;
        Operation op1 = ()-> x*y;
        Operation op2 = ()-> x-y;
        Operation op3 = ()-> x/y;
        return op.calculate() + op1.calculate() + op2.calculate() + op3.calculate();
    }

    public static int notfunc() {
        Operation op = ()-> x+y;
        Operation op1 = ()-> x*y;
        return op.calculate() + op1.calculate();
    }

    public static int func(int z) {
        Operation op = ()-> x+y+z;
        Operation op1 = ()-> x*y;
        Operation op2 = ()-> x-y+z;
        Operation op3 = ()-> x/y;
        return op.calculate() + op1.calculate() + op2.calculate() + op3.calculate();
    }
}
interface Operation{
    int calculate();
}