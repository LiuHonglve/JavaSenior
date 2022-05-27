package liu.java;

/**
 * 创建多线程的方式二：实现Runable接口
 *
 1) 定义子类，实现Runnable接口。
 2) 子类中重写Runnable接口中的run方法。
 3) 通过Thread类含参构造器创建线程对象。
 4) 将Runnable接口的子类对象作为实际参数传递给Thread类的构造器中。
 5) 调用Thread类的start方法：开启线程，调用Runnable子类接口的run方法。
 *
 *
 * 比较创建两种线程方式的区别
  区别
  继承Thread：线程代码存放Thread子类run方法中。
  实现Runnable：线程代码存在接口的子类的run方法。
  实现方式的好处
  避免了单继承的局限性
  多个线程可以共享同一个接口实现类的对象，非常适合多个相同线
 程来处理同一份资源
 *
 * @author liuhonglve
 * @create 2022-05-24-20:00
 */
// 1) 定义子类，实现Runnable接口。
class MThead implements Runnable{
//     2) 子类中重写Runnable接口中的run方法。
    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class ThreadTest1 {
    public static void main(String[] args) {
//        3.创建线程对象。
        MThead mThead = new MThead();
//        4.将Runnable接口的子类对象作为实际参数传递给Thread类的构造器中。
        Thread t1 = new Thread(mThead);
        t1.setName("线程1");
//        5.调用Thread类的start方法
        t1.start();
//        再启动一个线程，遍历100以内的偶数
        Thread t2 = new Thread(mThead);
        t2.setName("线程2");
        t2.start();
    }
}

