package com.jali.demo011.lambda;

interface Foo2{
    int add(int x,int y);

    default int div(int x,int y){
        System.out.println("aaa");
        return x/y;
    }

    default int div2(int x,int y){
        System.out.println("aaa");
        return x/y;
    }

    static int mv(int x,int y){
        System.out.println("aaa");
        return x*y;
    }

    static int mv2(int x,int y){
        System.out.println("aaa");
        return x*y;
    }
}

public class LambdaExpressWithArgsDemo {

    public static void main(String[] args) {
        // jdk8的lambda表达式
        // 如果一个接口里只有一个方法，那么这个接口叫做函数式接口
        Foo2 foo2 = (x,y) -> {
            System.out.println("hello java");
            return x+y;
        };
        System.out.println(foo2.add(5, 6));

    }
}
