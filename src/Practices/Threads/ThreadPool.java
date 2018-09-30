package Practices.Threads;

import java.util.concurrent.*;

/**
 * Created by 11239 on 2018/9/18.
 *
 * 通过ThreadPoolExecutor类创建ThreadPool
 * 该类实现了AbstractExecutorService抽象类
 *
 */
public class ThreadPool {

    private static int corePoolSize=5;

    private static int maximumPoolSize=10;

    private static int keepAliveTime=60;

    //unit   TimeUnit.SECONDs
    //workQuene  SynchronousQuene, LinkedBlockingDeque, ArrayBlockingQuene
    //threadFactory
    //RejectedExecutionHandler

    public static void main(String[] args) {

        //1.基本线程池
        ThreadPoolExecutor executor1=new ThreadPoolExecutor(corePoolSize,maximumPoolSize,keepAliveTime,TimeUnit.SECONDS,new SynchronousQueue<Runnable>());

        //2.自定义工厂的线程池
        ThreadPoolExecutor executor2=new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return null;
            }
        });

        //3.自定义拒绝策略的线程池
        ThreadPoolExecutor executor3=new ThreadPoolExecutor(corePoolSize,maximumPoolSize,keepAliveTime,TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(2), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r,ThreadPoolExecutor executor) {
            }
        });

        //4.拒绝策略
        ThreadPoolExecutor executor4=new ThreadPoolExecutor(corePoolSize,maximumPoolSize,keepAliveTime,TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>(),new ThreadPoolExecutor.DiscardPolicy());

    }
}
