package liu.java;

/**
 * 多线程的创建，方式一：继承于Thread类
 * 1.创建一个继承于Thread类的子类
 * 2.重写Thread的run() --->将此线程执行的而操作声明在run()中
 * 3.创建Thread类的子类的对象
 * 4.通过此对象调用start()
 *
 * @author liuhonglve
 * @create 2022-05-24-18:20
 */

//  1.创建一个继承于Thread类的子类
class MyThread extends Thread{

//2.重写Thread的run()

    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            if(i % 2 == 0){
                System.out.println(i);
            }
        }
    }
}


public class ThreadTest {
    public static void main(String[] args) {
//        创建Thread类的子类对象
        MyThread t1 = new MyThread();

        t1.start();
//        t1.run();

        for(int i = 0; i < 100; i++){
            if(i % 2 == 0){
                System.out.println(i + "********main*********");
            }
        }


//        System.out.println("hello");
    }

}
