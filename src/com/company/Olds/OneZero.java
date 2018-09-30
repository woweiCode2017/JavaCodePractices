package com.company.Olds;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 11239 on 2018/8/28.
 */
public class OneZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ins = sc.nextLine().split(" ");
        printRes(ins, 0, new StringBuilder());
    }

    private static void printRes(String[] chs, int start, StringBuilder sb) {
        if (start >= chs.length) {
            System.out.println(sb.toString());
            return;
        }
        int temp = Integer.valueOf(chs[start]);
        if (temp == 0) {
            StringBuilder sb1=new StringBuilder();
            for(int i=0;i<sb.length();i++){
                sb1.append(sb.charAt(i));
            }
            printRes(chs, start + 1, sb1.append(start));
            printRes(chs, start + 1, sb);
        } else {
            printRes(chs, start + 1, sb.append(start));
        }
    }
}
