package com.company;

import java.util.Scanner;

/**
 * Created by 11239 on 2018/9/9.
 *
 * 还原真实IP
 *
 */
public class ZiJieTiaoDong09093 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String ipIn=sc.nextLine();

        char[] ips=ipIn.toCharArray();
        int count=0;
        //合法性检验
        if(ips[0]=='0'||ips.length<4){
            count=0;
            System.out.println(count);
            return;
        }
        if(ips.length==4){
            count=1;
            System.out.println(count);
            return;
        }

        //统计0的个数
        int zeroCount=0;
        for(int i=0;i<ips.length;i++){
            if(ips[i]=='0')
                zeroCount++;
        }

        int totalNum=ips.length-zeroCount;

        count=(totalNum-1)*(totalNum-2)*(totalNum-3)/6;

        System.out.println(count);

    }
}
