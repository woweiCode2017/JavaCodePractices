package com.company.Olds;

import java.util.Scanner;

/**
 * Created by 11239 on 2018/8/11.
 */
public class InOut {

    //单行输入输出
    public static void inOutOne(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }

    //多行输入输出
    public static void inOutTwo(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0, x;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                x = sc.nextInt();
                ans += x;
            }
        }
        System.out.println(ans);
    }

    private static void inOutThree(String[] args){
        Scanner in=new Scanner(System.in);
        int time=in.nextInt();
        System.out.println(time);
        for(int i=0;i<time;i++){
            System.out.println(in.nextLine());
        }
    }

    public static void main(String[] args) {
        inOutThree(new String[] {});
    }
}
