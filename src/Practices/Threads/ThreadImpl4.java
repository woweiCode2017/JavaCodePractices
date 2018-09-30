package Practices.Threads;

import java.util.Date;
import java.util.concurrent.*;

/**
 * Created by 11239 on 2018/9/18.
 *
 * 通过线程池获得线程
 * Exector接口提供4个静态方法创建子类：
 *  1.newFixedThreadPool
 *  2.newCachedThreadPool
 *  3.newSingleThreadPoolExecutor
 *  4.newScheduledThreadPool
 *
 */
public class ThreadImpl4 {

    static class Handle implements Runnable{

        private String name;

        public Handle(String name){
            this.name="thread"+name;
        }

        @Override
        public void run() {
            System.out.println(name+" Start.Time= "+new Date());
            processCommand();
            System.out.println(name+" End.Time= "+new Date());
        }

        private void processCommand() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString(){
            return this.name;
        }
    }


    public static void main(String[] args) {
        //TODO:  https://blog.csdn.net/xidiancoder/article/details/73332906

        //Test CachedThreadPool
        ExecutorService exec1=Executors.newCachedThreadPool();
        for (int i=0;i<10;i++){
            exec1.execute(new Handle(String.valueOf(i)));
        }
        exec1.shutdown();


        //Test FixedThreadPool
        ExecutorService exec2=Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i=0;i<10;i++){
            exec2.execute(new Handle(String.valueOf(i)));
        }
        exec2.shutdown();


        //Test SingleThreadExector
        ExecutorService exec3=Executors.newSingleThreadExecutor();
        for (int i=0;i<10;i++){
            exec3.execute(new Handle(String.valueOf(i)));
        }
        exec3.shutdown();


        //Test ScheduledThreadPoolExecutor
        ScheduledThreadPoolExecutor exec4=(ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(10);
        for (int i=0;i<10;i++){
            exec4.schedule(new Handle(String.valueOf(i)),10, TimeUnit.SECONDS);
        }
        exec4.shutdown();

    }
}
