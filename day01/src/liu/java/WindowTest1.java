package liu.java;

/**
 * 例子：创建三个窗口卖票，总票数为100张,  用实现Runable接口方式实现
 * @author liuhonglve
 * @create 2022-05-24-20:38
 */

class Window1 implements Runnable{

    private int ticket = 100;//不用static，共用100张票，
//只是造了一个对象，一个对象放到三个构造器中，相当于三个线程用的同一个 Window，只需要造一个window对象
//    如果造了多个window，则不能共用100张票


    @Override
    public void run() {
        while (true){
            if(ticket > 0){
                System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
                ticket--;
            }else{
                break;
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
