package Practices.Proxys;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by 11239 on 2018/10/7.
 */
public class JDKProxy implements InvocationHandler {

    private SayHello sayHello;

    public Object getInstance(SayHello sayHello){
        this.sayHello=sayHello;
        Class clazz=this.sayHello.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Proxy the SayHelloImpl by JDKProxy:before");
        Object result=method.invoke(this.sayHello,args);
        System.out.println("Proxy the SayHelloImpl by JDKProxy:after");
        return result;
    }
}
