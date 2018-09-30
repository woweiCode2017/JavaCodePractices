package Practices.Threads;

/**
 * Created by 11239 on 2018/9/18.
 *
 * 通过继承Thread类实现线程，需要重写run方法
 *
 */
public class ThreadImpl1 extends Thread{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }
}
