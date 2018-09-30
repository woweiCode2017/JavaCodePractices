package com.company.Olds;

import java.util.Scanner;

/**
 * Created by 11239 on 2018/9/12.
 *
 * 反转字符串中的每个单词
 *
 */
public class HuaWei09122 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        String[] ins = str.split(" ");
        int i=0;
        for (; i < ins.length; i++) {
            char[] charArr = ins[i].toCharArray();
            StringBuilder sb = new StringBuilder();
            int j=charArr.length-1;
            for (; j >=0; j--) {
                sb.append(charArr[j]);
            }
            System.out.print(sb.toString());
            if(i<ins.length-1) {
                System.out.print(" ");
            }
        }
    }
}
