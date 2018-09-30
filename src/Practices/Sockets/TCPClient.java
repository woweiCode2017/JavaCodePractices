package Practices.Sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by 11239 on 2018/8/17.
 *
 * 使用TCP协议完成Socket通信
 */
public class TCPClient {
    public static void main(String[] args) {
        Socket socket=null;
        Scanner sc=new Scanner(System.in);
        try {
            socket=new Socket("localhost",10086);
        } catch (IOException e) {
            System.out.println("开启客户端失败！！！");
            e.printStackTrace();
        }
        //输出字符流
        OutputStream outputStream=null;
        PrintWriter pw=null;

        InputStream inputStream=null;
        InputStreamReader ins=null;
        BufferedReader br=null;

        while(true){
            System.out.println("输入想说的话吧！");
            String words=sc.nextLine();
            try {
                outputStream = socket.getOutputStream();
                pw=new PrintWriter(outputStream);
                pw.print("client:"+words);
                //pw.write();pw.flush();
                //socket.shutdownOutput();
            } catch (IOException e) {
                System.out.println("输出字符失败！！！");
                e.printStackTrace();
            }
            //获取输入流
            try {
                inputStream = socket.getInputStream();
                ins=new InputStreamReader(inputStream);
                br=new BufferedReader(ins);
                String info=null;
                while((info=br.readLine())!=null){
                    System.out.println("服务器返回："+info);
                }
                if("close".equals(info))
                    break;
                //socket.shutdownInput();
            } catch (IOException e) {
                System.out.println("读取字符失败！！！");
                e.printStackTrace();
            }
        }

        //关闭资源
        pw.close();
        try {
            outputStream.close();
        } catch (IOException e) {
            System.out.println("关闭输出流失败！！！");
            e.printStackTrace();
        }
        try {
            br.close();
            ins.close();
            inputStream.close();
        } catch (IOException e) {
            System.out.println("关闭输入流失败");
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            System.out.println("关闭连接失败！！！");
            e.printStackTrace();
        }
    }
}
