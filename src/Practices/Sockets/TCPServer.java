package Practices.Sockets;

import com.sun.org.apache.xpath.internal.compiler.Keywords;
import sun.org.mozilla.javascript.internal.ast.TryStatement;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by 11239 on 2018/8/22.
 *
 * 基于TCP协议的Socket通信服务端
 */
public class TCPServer {

    public static void main(String[] args) {
        //1.创建Server段
        ServerSocket server=null;
        try {
            server=new ServerSocket(10086);
        } catch (IOException e) {
            System.out.println("创建服务器失败！！！");
            e.printStackTrace();
        }
        //2.接受链接请求，创建Socket链接
        while(true){
            Socket socket;
            try {
                socket=server.accept();
                handleSocket(socket);
            } catch (IOException e) {
                System.out.println("连接失败！！！请重试");
                e.printStackTrace();
            }
        }
            //server.close();
    }

    private static void handleSocket(Socket socket){
        //3.获取输入流
        InputStream inputStream=null;
        InputStreamReader ins=null;
        BufferedReader br=null;

        OutputStream outputStream=null;
        PrintWriter pw=null;

        Scanner sc=new Scanner(System.in);
        while(true){
            try {
                inputStream = socket.getInputStream();
                ins=new InputStreamReader(inputStream);
                br=new BufferedReader(ins);
                String info=null;
                while((info=br.readLine())!=null){
                    System.out.println("客户端发送："+info);
                }
                //socket.shutdownInput();
                if("close".equals(info))
                    break;
            } catch (IOException e) {
                System.out.println("获取输入流失败！！！");
                e.printStackTrace();
            }
            //5.获得输出流
            System.out.println("输入想说的话吧！");
            String words=sc.nextLine();
            try {
                outputStream = socket.getOutputStream();
                //6.写出数据
                pw=new PrintWriter(outputStream);
                pw.print("server:"+words);
//                pw.write("Hello"+words);
//                pw.flush();
                //socket.shutdownOutput();
            } catch (IOException e) {
                System.out.println("获取输出流失败！！！");
                e.printStackTrace();
            }
        }

        //7.关闭资源
        try {
            br.close();
            ins.close();
            inputStream.close();
        } catch (IOException e) {
            System.out.println("关闭输入流失败！！！");
            e.printStackTrace();
        }
        try {
            pw.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("关闭输出流失败！！！");
            e.printStackTrace();
        }
    }
}
