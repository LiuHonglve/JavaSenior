package com.liu.java;

/**
 *使用同步方法解决实现Runable接口的线程安全问题
 *
 *
 *
 * 同步方法的总结：
 *
 * 同步方法任然涉及到同步监控器，只是不需要我们显示的声明
 * 非静态的同步方法，同步监视器是：this
 * 静态的同步方法，同步监视器是：当前类本身
 *
 *
 * @author liuhonglve
 * @create 2022-05-25-17:13
 */
class Window3 implements Runnable{

    private int ticket = 100;

    @Override
    public void run() {
        while (true){

            show();
        }
    }
    private synchronized void show() { //同步监视器this
//        synchronized (this){
            if (ticket > 0) {

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
                ticket--;
            }
        }
}

public class WindowTest3 {
    public static void main(String[] args) {
        Window3 w = new Window3();
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