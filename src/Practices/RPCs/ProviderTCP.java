package Practices.RPCs;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 11239 on 2018/8/22.
 * <p>
 * RPC 服务提供者
 *
 * 基于TCP实现
 */
public class ProviderTCP {

    private static Map<Object, Object> services = new HashMap<>();

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException {
        ServerSocket server = new ServerSocket(10086);
        System.out.println(SayHelloService.class.getName());
        services.put(SayHelloService.class, new SayHelloServiceImpl());
        while (true) {
            System.out.print("服务提供者启动，等待客户端调用。。。");
            Socket socket = server.accept();
            getMessages(socket);
        }
    }

    private static void getMessages(Socket socket) throws IOException, ClassNotFoundException, NoSuchMethodException {
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        String interfaceName = objectInputStream.readUTF();
        String methodName = objectInputStream.readUTF();
        Class<?>[] parameterTypes = (Class<?>[]) objectInputStream.readObject();
        Object[] arguments = (Object[]) objectInputStream.readObject();
        System.out.println("客户端调用服务端接口" + interfaceName + "的" + methodName + "方法");
        getServices(socket, interfaceName, methodName, parameterTypes, arguments);
    }

    private static void getServices(Socket socket, String interfaceName, String methodName, Class<?>[] parameterTypes, Object[] args) throws ClassNotFoundException, NoSuchMethodException, IOException {
        Class serviceClass = Class.forName(interfaceName);
        Object service = services.get(serviceClass);
        Method method = serviceClass.getMethod(methodName, parameterTypes);
        method.setAccessible(true);
        Object result = null;
        try {
            result = method.invoke(service, args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        ObjectOutputStream stream = new ObjectOutputStream(socket.getOutputStream());
        stream.writeObject(result);
        //序列化对象Person，传输
        Person p1=new Person();
        p1.setName("cherrow");
        p1.setAge(22);
        //stream.writeObject(p1);
        ObjectMapper mapper=new ObjectMapper();
        String json=mapper.writeValueAsString(p1);
        System.out.println(json);
        stream.writeObject(json);
        //对象写入结束
        System.out.println("服务端返回的结果为" + result);
    }
}
