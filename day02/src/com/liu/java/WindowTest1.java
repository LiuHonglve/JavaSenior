package com.liu.java;

/**
 * 例子：创建三个窗口卖票，总票数为100张,  用实现Runable接口方式实现
 *
 *同步代码块处理实现Runable的线程安全问题
 * synchronized(同步监视器){
 *     需要被同步的代码
 * }
 *
 *
 * 说明：
 * 1.操作共享数据的代码，即为需要被同步的代码
 * 2.共享数据：多个线程共同操作的变量。比如：ticket就是共享数据
 * 3.同步监视器：俗称锁。任何一个类的对象都可以充当锁。要求：多个线程必须要共用一把锁。
 *
 *
 * @author liuhonglve
 * @create 2022-05-24-20:38
 *
 */

class Window1 implements Runnable{

    private int ticket = 100;
//    Object obj = new Object();

//    Dog dog = new Dog();//任何一个类的对象都可以充当锁。

    @Override
    public void run() {
        while (true){
           synchronized (this){ //此时this代表window1的对象 w, 不用再去new一个Object// synchronized (dog) {
                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w = new Window1();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}

class Dog{

}