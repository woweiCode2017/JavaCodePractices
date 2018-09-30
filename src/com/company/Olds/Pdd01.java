package com.company.Olds;

import java.util.Scanner;

/**
 * Created by 11239 on 2018/7/22.
 */
public class Pdd01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }
}
