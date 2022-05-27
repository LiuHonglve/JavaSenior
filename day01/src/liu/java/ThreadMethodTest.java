package liu.java;

/**
 *
 *测试Thread中的常用方法
 * 1.start():启动当前线程；调用当前线程的run()
 * 2.run():通常需要重写Thread类中的此方法，
 * 3.currentThread():静态方法，返回执行当前代码的线程
 * 4.getName():返回线程的名称
 * 5.setName(String name):设置该线程名称
 * 6.yield()：线程让步
    暂停当前正在执行的线程，把执行机会让给优先级相同或更高的线程
    若队列中没有同优先级的线程，忽略此方法
 *7.join() ：当某个程序执行流中调用其他线程的join()方法时，调用线程将被阻塞，直到join()方法加入的 join 线程执行完为止
    低优先级的线程也可以获得执行
 * 8.stop(): 已过时，强制线程生命期结束，不推荐使用
 * 9.sleep(long millis)：(指定时间:毫秒) 让当前线程 “睡眠” 指定的毫秒数
 * 令当前活动线程在指定时间段内放弃对CPU控制,使其他线程有机会被执行,时间到后重排队。
 *  抛出InterruptedException异常
 *10.isAlive()：返回boolean，判断线程是否还活着
 *
 *
 * 线程优先级
 * MAX_PRIORITY：10
  MIN _PRIORITY：1
  NORM_PRIORITY：5 -->默认优先级
 *
 *getPriority() ：返回线程优先值
 setPriority(int newPriority) ：改变线程的优先级
 *
 * @author liuhonglve
 * @create 2022-05-24-19:02
 */

public class ThreadMethodTest {

}
