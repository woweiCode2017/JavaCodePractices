package com.company;

import java.util.Scanner;

/**
 * Created by 11239 on 2018/9/15.
 *
 * 二进制字符串相加
 *
 */
public class WeiPinHui09152 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String ins=sc.nextLine();
        String insArray[]=ins.split(" ");

        String first=insArray[0];
        String second=insArray[1];

        int len=first.length()>second.length()?first.length():second.length();
        char[] firstArray=first.toCharArray();
        char[] secondArray=second.toCharArray();
        int nums[][]=new int[len][2];
        int res[]=new int[len+1];

        //填充nums
        for(int i=0;i<len;i++){
            nums[i][0]=firstArray[i]-'0';
            nums[i][1]=secondArray[i]-'0';
        }
        //求res
        for(int i=0;i<len;i++){
            res[i+1]=nums[i][0]+nums[i][1];
        }

        //进位
        int ahead=0;
        for(int index=len;index>=0;index--){
            int temp=res[index]+ahead;
            res[index]=temp%2;
            ahead=temp/2;
        }
        //输出
        StringBuilder sb=new StringBuilder();
        int start=0;
        while(res[start]==0){
            start++;
        }
        for(;start<=len;start++){
            sb.append(res[start]);
        }
        System.out.println(sb.toString());
    }
}
