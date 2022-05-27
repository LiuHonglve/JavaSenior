package liu.java;

/**
 *例子：创建三个窗口卖票，总票数为100张
 *
 * 存在线程安全问题，待解决
 *
 * @author liuhonglve
 * @create 2022-05-24-19:42
 */

class Window extends Thread{

    private static int ticket = 100; //要声明为static，不然每个线程都会有100张票

    @Override
    public void run() {
        while (true){
            if(ticket > 0){
                System.out.println(getName() + "卖票，票号为：" + ticket);
                ticket--;
            }else{
                break;
            }
        }
    }
}

public class WindowTest {
    public static void main(String[] args) {
        Window t1 = new Window();
        Window t2 = new Window();
        Window t3 = new Window();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
