package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 11239 on 2018/9/21.
 *
 * 求木桶接水的最大量
 *
 */
public class SanFor09211 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int nums=Integer.valueOf(sc.nextLine());
        int banNums[]=new int[nums];
        List<String> banLength=new ArrayList<>();

        for(int i=0;i<nums;i++){
            banNums[i]=Integer.valueOf(sc.nextLine());
            banLength.add(sc.nextLine());
        }

        int res[]=new int[nums];
        for(int i=0;i<nums;i++){
            res[i]=getWaters(banNums[i],banLength.get(i));
        }
        for(int i=0;i<nums;i++){
            System.out.println(res[i]);
        }
    }

    private static int getWaters(int banNum, String s) {
        int res=0;
        int bans[]=new int[banNum];
        String banLength[]=s.split(" ");
        for(int i=0;i<banNum;i++){
            bans[i]=Integer.valueOf(banLength[i]);
        }

        int i=0;
        int temp=bans[i];
        while(i<banNum-1){
            boolean flag=false;
            for(int j=i+1;j<banNum;j++){
                if(bans[j]>=temp){
                    res+=temp*(j-i);
                    i=j;
                    temp=bans[j];
                    flag=true;
                    break;
                }
            }
            if(!flag){
               res+=bans[i+1];
               i++;
               temp=bans[i];
            }
        }
        return res;
    }
}
