package com.liu.java;

/**
 * 使用同步方法处理继承Thread类的线程安全问题
 *
 * @author liuhonglve
 * @create 2022-05-25-17:28
 */
class Window4 extends Thread{

    private static int ticket = 100; //要声明为static，不然每个线程都会有100张票

    @Override
    public void run() {
        while (true){
            show();
        }
    }

    private static synchronized void show(){//同步监视器：window4.class
//    private synchronized void show(){ //同步监视器t1, t2, t3 。此方法错误
        if(ticket > 0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "卖票，票号为：" + ticket);
            ticket--;
        }
    }
}

public class WindowTest4 {
    public static void main(String[] args) {
        Window4 t1 = new Window4();
        Window4 t2 = new Window4();
        Window4 t3 = new Window4();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
