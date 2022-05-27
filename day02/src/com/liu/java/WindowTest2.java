package com.liu.java;

/**
 *例子：创建三个窗口卖票，总票数为100张
 *
 * 存在线程安全问题，待解决
 *
 * @author liuhonglve
 * @create 2022-05-24-19:42
 */

class Window2 extends Thread{

    private static int ticket = 100; //要声明为static，不然每个线程都会有100张票
    private static Object obj = new Object();


    @Override
    public void run() {
        while (true){
            //正确的
//            synchronized (obj){
            synchronized (Window2.class){//Class clazz = Window2.class, Window2.class只会加载一次
//              synchronized (this){错误的方式，指代了t1, t2, t3 三个对象
                if(ticket > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(getName() + "卖票，票号为：" + ticket);
                    ticket--;
                }else{
                    break;
                }
            }


        }
    }
}

public class WindowTest2 {
    public static void main(String[] args) {
        Window2 t1 = new Window2();
        Window2 t2 = new Window2();
        Window2 t3 = new Window2();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
