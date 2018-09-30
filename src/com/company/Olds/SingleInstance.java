package com.company.Olds;

/**
 * Created by 11239 on 2018/8/14.
 */
public class SingleInstance {
    private volatile static SingleInstance instance;

    private SingleInstance(){}

    public static SingleInstance getInstance(){
        if(null==instance){
            synchronized (SingleInstance.class){
                if(null==instance){
                    instance=new SingleInstance();
                }
            }
        }
        return instance;
    }
}
