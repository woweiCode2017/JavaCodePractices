package com.company.Olds;

import java.util.Scanner;

/**
 * Created by 11239 on 2018/9/3.
 */
public class DuoMiNuo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=Integer.valueOf(sc.nextLine());
        int[][] iAndH=new int[num][2];
        for(int i=0;i<num;i++){
            String temp=sc.nextLine();
            String [] temps=temp.split(" ");
            iAndH[i][0]=Integer.valueOf(temps[0]);
            iAndH[i][1]=Integer.valueOf(temps[1]);
        }
        int[] res=new int[num];
        for(int i=0;i<num;i++){
            int temp=iAndH[i][0];
            int tempNum=1;
            int j=i+1;
            temp+=iAndH[i][1];
            int startI=iAndH[i][0];
            while(j<=num+i-1){
                int toCal=j>num-1?j-num:j;
                if(temp<=iAndH[toCal][0]){
                    break;
                }
                if(startI>iAndH[toCal][0]){
                    j++;
                    continue;
                }
                temp=temp>(iAndH[toCal][0]+iAndH[toCal][1])?temp:(iAndH[toCal][0]+iAndH[toCal][1]);
                tempNum++;
                j++;
            }
            res[i]=tempNum;
        }
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }
}
