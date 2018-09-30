package com.company;

import java.util.Scanner;

/**
 * Created by 11239 on 2018/9/9.
 *
 * 检查不合格品数量
 *
 */
public class JD09092 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=Integer.valueOf(sc.nextLine());

        int params[][]=new int[num][3];
        for(int i=0;i<num;i++){
            String tempIn=sc.nextLine();
            String[] inArray=tempIn.split(" ");
            for(int j=0;j<inArray.length;j++){
                params[i][j]=Integer.valueOf(inArray[j]);
            }
        }

        int count=0;
        for(int i=0;i<num;i++){
            if(check(i,params)){
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean check(int index, int[][] params) {
        boolean res=false;
        int [] temp=new int[3];
        for(int i=0;i<3;i++){
            temp[i]=params[index][i];
        }
        for(int i=0;i<params.length;i++){
            if(temp[0]<params[i][0]){
                if(temp[1]<params[i][1]){
                    if(temp[2]<params[i][2]){
                        res=true;
                    }
                }
            }
        }
        return res;
    }
}
