package com.company;

import java.util.Scanner;

/**
 * Created by 11239 on 2018/9/20.
 *
 * 解析BCON
 *
 */
public class ChaoYouAi09203 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String bconString=sc.nextLine();
       // String key=sc.nextLine();

        //去掉{}
        String remove=bconString.substring(1,bconString.length()-1);
        System.out.println(remove);

    }
}
