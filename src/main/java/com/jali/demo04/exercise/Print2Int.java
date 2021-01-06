package com.jali.demo04.exercise;

/**
 * 定义一个线程A，输出1~10之间的整数，定义一个线程B，逆序输出1~10之间的整数，要求线程A和线程B交替输出
 *
 * 分析：使用sleep方法阻塞当前线程
 *
 * 注：这个代码还是有问题的，并不能百分百每次都是交替打印。因为cpu不是只有这两个线程去抢占资源，可能其他系统抢占导致sleep结束后还没抢到资源进行打印。
 */
public class Print2Int {

    public static void main(String[] args) {
        new Thread(new A()).start();
        new Thread(new B()).start();
    }

}
