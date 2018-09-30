package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 11239 on 2018/9/8.
 * 翻牌子  每次操作相邻的所有牌
 *
 * 统计向下的牌个数
 *
 */
public class WangYi09081 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=Integer.valueOf(sc.nextLine());
        int[][] params=new int[num][2];
        for(int i=0;i<num;i++){
            String ins=sc.nextLine();
            String[] inArray=ins.split(" ");
            params[i][0]=Integer.valueOf(inArray[0]);
            params[i][1]=Integer.valueOf(inArray[1]);
        }
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<num;i++){
            int row=params[i][0];
            int col=params[i][1];
            int temp=getNum(row,col);
            res.add(temp);
        }
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }
    }

    private static int getNum(int row, int col) {
        int res=0;
        int[][] pais=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                pais[i][j]=0;
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                //核心牌行
                pais[i][j]=1-pais[i][j];
                if(j-1>=0)
                    pais[i][j-1]=1-pais[i][j-1];
                if(j+1<col)
                    pais[i][j+1]=1-pais[i][j+1];
                //上一行
                if(i-1>=0){
                   pais[i-1][j]=1-pais[i-1][j];
                    if(j-1>=0)
                        pais[i-1][j-1]=1-pais[i-1][j-1];
                    if(j+1<col)
                        pais[i-1][j+1]=1-pais[i-1][j+1];
                }
                //下一行
                if(i+1<row){
                    pais[i+1][j]=1-pais[i+1][j];
                    if(j-1>=0)
                        pais[i+1][j-1]=1-pais[i+1][j-1];
                    if(j+1<col)
                        pais[i+1][j+1]=1-pais[i+1][j+1];
                }
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(pais[i][j]!=0)
                    res+=1;
            }
        }
        return res;
    }
}
