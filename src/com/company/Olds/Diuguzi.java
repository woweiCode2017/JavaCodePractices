package com.company.Olds;


import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Created by 11239 on 2018/8/28.
 */
public class Diuguzi {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] allAndAgain=sc.nextLine().split(" ");
        double all=Integer.valueOf(allAndAgain[0])+0.0;
        double again=Integer.valueOf(allAndAgain[1])+0.0;
        String[] jianglis=sc.nextLine().split(" ");
        double totalCount=0.0;
        for(int i=0;i<all;i++){
            totalCount+=Integer.valueOf(jianglis[i]);
        }
        double res=(totalCount/all)*(all/(all-again));
        System.out.println(String.format("%.2f",res));
    }
}
