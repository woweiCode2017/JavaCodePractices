package com.company.Olds;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 11239 on 2018/7/22.
 */
public class ModifyNum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String target=sc.nextLine();
        String number=sc.nextLine();
        String [] tars=target.split(" ");
        int totalNum=Integer.parseInt(tars[0]);
        int needNum=Integer.parseInt(tars[1]);
        if(needNum>totalNum)
            return ;
        int [][] times=new int[10][11];
        int temp;
        for(int i=0;i<totalNum;i++){
            temp=number.charAt(i);
            times[0][temp]++;
            times[times[0][temp]][temp]=i;
        }



    }
}
