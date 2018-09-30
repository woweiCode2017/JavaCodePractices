package com.company;

import java.util.Scanner;

/**
 * Created by 11239 on 2018/9/8.
 * 住房子
 */
public class WangYi09082 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.valueOf(sc.nextLine());
        int[][] params = new int[num][2];
        for (int i = 0; i < num; i++) {
            String ins = sc.nextLine();
            String[] inArray = ins.split(" ");
            params[i][0] = Integer.valueOf(inArray[0]);
            params[i][1] = Integer.valueOf(inArray[1]);
        }
        int [][] res=new int[num][2];
        for(int i=0;i<num;i++){
            res[i][0]=0;
        }
        for(int i=0;i<num;i++){
            int n=params[i][0];
            int k=params[i][1];
            int temp=getMaxNum(n,k);
            res[i][1]=temp;
        }
        for(int i=0;i<num;i++){
            System.out.println(res[i][0]+" "+res[i][1]);
        }
    }

    private static int getMaxNum(int n, int k) {
        int res=0;
        if(k<=1)
            return res;
        if(n-k<=1)
            return res;
        int contains=3;
        res=1;
        for(int i=1;i<k;i++){
            if(contains+2<=n){
                res++;
                contains+=2;
            }else{
                break;
            }
        }
        return res;
    }
}
