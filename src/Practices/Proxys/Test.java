package Practices.Proxys;

import net.sf.cglib.proxy.Enhancer;
import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by 11239 on 2018/10/7.
 */
public class Test {

    @org.junit.Test
    public void testStaticProxy(){
        SayHello sayHello=new StaticProxy();
        sayHello.sayHello();
    }

    @org.junit.Test
    public void testJDKProxy() throws Exception {
        SayHello sayHello1=new SayHelloImpl();
        SayHello proxy=(SayHello) new JDKProxy().getInstance(sayHello1);
//        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{SayHello.class.getClass()});
//        FileOutputStream os=new FileOutputStream("Proxy0.class");
//        os.write(bytes);
//        os.close();
        proxy.sayHello();
    }

    @org.junit.Test
    public void testCGLIBProxy(){
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(SayHelloImpl.class);
        enhancer.setCallback(new CGLIBProxy());
        SayHello proxy=(SayHello)enhancer.create();
        proxy.sayHello();
    }

}
