package Practices.Proxys;

/**
 * Created by 11239 on 2018/10/7.
 */
public class StaticProxy implements SayHello{

    private SayHelloImpl sayHelloImpl=new SayHelloImpl();

    @Override
    public void sayHello(){
        System.out.println("Proxy the SayHelloImpl by StaticProxy:Before");
        sayHelloImpl.sayHello();
        System.out.println("Proxy the SayHelloImpl by StaticProxy:After");
    }
}
