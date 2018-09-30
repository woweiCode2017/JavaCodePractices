package Practices.RPCs;

/**
 * Created by 11239 on 2018/8/22.
 */
public class SayHelloServiceImpl implements SayHelloService {

    public String sayHello(String msg){
        if(("Hello").equals(msg)){
            return "Hello client!";
        }else{
           return "bye bye";
        }
    }

    public String toString(){
        return this.getClass().getName();
    }
}
