package com.jali.demo011.lambda;

interface Foo{
    void sayHello();
}
public class LambdaExpressDemo {

    public static void main(String[] args) {
        // jdk8之前的写法
        Foo foo = new Foo() {
            @Override
            public void sayHello() {
                System.out.println("hello java");
            }
        };
        foo.sayHello();

        // jdk8的lambda表达式
        // 如果一个接口里只有一个方法，那么这个接口叫做函数式接口
        Foo foo2 = () -> {
            System.out.println("hello java");
        };
        foo2.sayHello();

    }
}
