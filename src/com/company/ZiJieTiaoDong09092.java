package com.company;

import java.util.Scanner;

/**
 * Created by 11239 on 2018/9/9.
 * <p>
 * 划分部门，将关系紧密的小组划分为一个部门
 */
public class ZiJieTiaoDong09092 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.valueOf(sc.nextLine());
        int[][] inArray = new int[num][num];
        for (int i = 0; i < num; i++) {
            String temp = sc.nextLine();
            String[] tempArray = temp.split(" ");
            for (int j = 0; j < num; j++) {
                inArray[i][j] = Integer.valueOf(tempArray[j]);
            }
        }

        int count = 0;
        //扫描元素，是否为1，为1则开始循环，扫描相邻接的元素；划分一组
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                //判断第一个扫描元素
                if (inArray[i][j] != 0) {
                    getCompart(inArray, i, j, num);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void getCompart(int[][] inArray, int i, int j, int n) {
        if (i >= n || j >= n)
            return;
        if (inArray[i][j] == 0) {
            return;
        } else {
            inArray[i][j] = 0;
            getCompart(inArray, i + 1, j, n);
            getCompart(inArray, i, j + 1, n);
        }
    }
}
