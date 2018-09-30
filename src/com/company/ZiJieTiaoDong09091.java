package com.company;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by 11239 on 2018/9/9.
 *
 * 查找字符串中最长不重复子串
 *
 */
public class ZiJieTiaoDong09091 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String in=sc.nextLine();
        char[] inArray=in.toCharArray();

        int tempLength=0;
        int maxLength=0;

        int [] position=new  int[26];
        for(int i=0;i<26;i++){
            position[i]=-1;
        }

        for(int i=0;i<inArray.length;i++){
            int before=position[inArray[i]-'a'];
            if(before<0||i-before>tempLength){
                tempLength++;
            }else{
                if(tempLength>maxLength){
                    maxLength=tempLength;
                }
                tempLength=i-before;
            }
            position[inArray[i]-'a']=i;
        }
        if(tempLength>maxLength)
            maxLength=tempLength;
        System.out.println(maxLength);
    }
}
