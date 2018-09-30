package com.company;

import java.util.Scanner;

/**
 * Created by 11239 on 2018/9/20.
 *
 * 给定两个时间，求时分秒走了多少角度
 *
 */
public class ChaoYouAi09202 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String firstIn=sc.nextLine();
        String secondIn=sc.nextLine();

        int[] res = new int[3];
        String[] firstArray = firstIn.split(":");
        String[] secondArray = secondIn.split(":");
        double firstSeconds = Double.parseDouble(firstArray[0])*3600+
                Double.parseDouble(firstArray[1])*60 +  Double.parseDouble(firstArray[2]);
        double secondSeconds = Double.parseDouble(secondArray[0])*3600+
                Double.parseDouble(secondArray[1])*60 +  Double.parseDouble(secondArray[2]);

        double diff = secondSeconds-firstSeconds;
        res[0] = (int)diff/120;
        res[1] = (int)diff/10;
        res[2] = (int)diff*6;

        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }

}
