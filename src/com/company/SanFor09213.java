package com.company;

import java.util.Scanner;

/**
 * Created by 11239 on 2018/9/21.
 *
 * 连续最小值
 *
 */
public class SanFor09213 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int nums=Integer.valueOf(sc.nextLine());
        int dayNum[]=new int[nums];

        for(int i=0;i<nums;i++){
            dayNum[i]=Integer.valueOf(sc.nextLine());
        }

        int res=0;
        int temp=0;
        int i=0;
        while(i<nums){
            if(temp>0)
                temp=0;
            if(temp<res)
                res=temp;
            if(dayNum[i]<0){
                temp+=dayNum[i];
                i++;
            }else{
                if(temp+dayNum[i]<0){
                    temp+=dayNum[i++];
                }else{
                    temp=0;
                    i++;
                }
            }
        }
        System.out.println(res);
    }
}
