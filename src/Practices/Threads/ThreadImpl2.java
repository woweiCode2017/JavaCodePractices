package Practices.Threads;

/**
 * Created by 11239 on 2018/9/18.
 *
 * 通过实现Runnable接口，实现run方法实现线程
 */
public class ThreadImpl2 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
