package Practices.Threads;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/**
 * Created by 11239 on 2018/9/18.
 *
 * 定时任务,通过设置标志位来结束线程
 *
 */
public class TimedTask {

    static class MyTaskThread extends Thread{
        private volatile boolean cancelled=false;

        public void setCancelled(){
            cancelled=true;
        }

        @Override
        public void run(){
            int i=0;
            while (!cancelled){
                System.out.println(i++);
            }
        }
    }

    static class MyTaskRunnable implements Runnable{

        private volatile boolean cancelled=false;

        public void setCancelled(){
            cancelled=true;
        }

        @Override
        public void run() {
            int i=0;
            while(!cancelled){
                System.out.println(i++);
            }
        }
    }

    static class MyTaskThreadInterrupted extends Thread{

        public void cancel(){
            interrupt();
        }

         @Override
         public void run(){
             int i=0;
             while(!Thread.currentThread().isInterrupted()){
                 System.out.println(i++);
             }
         }
    }

    public static void main(String[] args) {
        //Test MyTaskThread
        MyTaskThread newThread=new MyTaskThread();
        newThread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            newThread.setCancelled();
            e.printStackTrace();
        }
        System.out.println("Thread is finished!");

        //Test MyTaskRunnable
        MyTaskRunnable newRunnable=new MyTaskRunnable();
        new Thread(newRunnable).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            newRunnable.setCancelled();
            e.printStackTrace();
        }
        System.out.println("Runnable is finished!");
    }
}
