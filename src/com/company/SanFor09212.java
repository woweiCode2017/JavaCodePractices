package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 11239 on 2018/9/21.
 *
 * 求解二元一次方程组
 *
 */
public class SanFor09212 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int nums=Integer.valueOf(sc.nextLine());
        List<String> list=new ArrayList<>(nums);
        List<String> res=new ArrayList<>(nums);

        for(int i=0;i<nums;i++){
            list.add(sc.nextLine());
        }

        for(int i=0;i<nums;i++){
            res.add(getResult(list.get(i)));
        }

        for(int i=0;i<nums;i++){
            System.out.println(res.get(i));
        }
    }

    private static String getResult(String s) {
        String res="UNKNOWN";
        String params[]=s.split(" ");
        int paramsToInt[]=new int[params.length];
        for(int i=0;i<params.length;i++){
            paramsToInt[i]=Integer.valueOf(params[i]);
        }
        for(int i=1;i<=paramsToInt[2]/paramsToInt[0];i++){
            int re=paramsToInt[2]-i*paramsToInt[0];
            if(re%paramsToInt[1]==0){
                int j=re/paramsToInt[1];
                int sum=i*paramsToInt[3]+j*paramsToInt[4];
                if(sum==paramsToInt[5]){
                    res=i+" "+j;
                    break;
                }
            }
        }
        return res;
    }
}
