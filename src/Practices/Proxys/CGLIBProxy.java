package Practices.Proxys;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by 11239 on 2018/10/7.
 */

public class CGLIBProxy implements MethodInterceptor{

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Proxy SayHello by CGLIBProxy:before");
        Object result=methodProxy.invokeSuper(o,objects);
        System.out.println("Proxy SayHello by CGLIBProxy:after");
        return result;
    }

}
