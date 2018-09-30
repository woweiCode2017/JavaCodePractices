package Practices.Threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by 11239 on 2018/9/18.
 *
 * 通过实现Callable接口，实习那call方法实现线程
 * 1.实现Callable的类是可被其它线程执行的任务
 * 2.运行Callable需要FutureTask实现类的支持，因为会返回一个Future接口类型的对象
 */
public class ThreadImpl3{
    static class MyTaskCallable implements Callable<Integer>{
        @Override
        public Integer call() throws Exception {
            return 1;
        }
    }

    public static void main(String[] args) {
        MyTaskCallable newTaskRunnable =new MyTaskCallable();
        FutureTask<Integer> result=new FutureTask<Integer>(newTaskRunnable);
        new Thread(result).start();
        Integer res=0;
        try {
            res=result.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(res);
    }
}
