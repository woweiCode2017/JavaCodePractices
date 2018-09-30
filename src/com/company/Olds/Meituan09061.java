package com.company.Olds;

import java.util.Scanner;
import java.util.Vector;

/**
 * Created by 11239 on 2018/9/6.
 *
 * 给定n点，n-1条边
 *
 * n
 * 1 2
 * 2 4
 *
 * 输出距离
 * 求最短元素遍历路径
 */
public class Meituan09061 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String countIn=sc.nextLine();
        int count=Integer.valueOf(countIn);
        Vector<String> roads=new Vector<>(count);
        for(int i=1;i<count;i++){
            roads.add(sc.nextLine());
        }

        System.out.println(count);
    }
}
