package org.example;

public class LambdaApp {

    static int x = 20;
    static int y = 10;
    public static void main(String[] args) {
        System.out.println(func() + func(10) + notfunc());
    }

    public static int func() {
        Operation op = ()-> x+y; //$0
        Operation op1 = ()-> x*y; //$1
        Operation op2 = ()-> x-y; //$2
        Operation op3 = ()-> x/y; //$3
        return op.calculate() + op1.calculate() + op2.calculate() + op3.calculate();
    }

    public static int notfunc() {
        Operation op = ()-> x+y; //$4
        Operation op1 = ()-> x*y; //$5
        return op.calculate() + op1.calculate();
    }

    public static int func(int z) {
        Operation op = ()-> x+y+z; //$6
        Operation op1 = ()-> x*y; //$7
        Operation op2 = ()-> x-y+z; //$8
        Operation op3 = ()-> x/y; //$9
        return op.calculate() + op1.calculate() + op2.calculate() + op3.calculate();
    }
}
interface Operation{
    int calculate();
}