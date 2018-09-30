package com.company;

import java.util.Scanner;

/**
 * Created by 11239 on 2018/9/15.
 *
 * 找出矩阵中第k小的元素
 *
 * 矩阵每行每列元素按升序排列
 *
 */
public class WeiPinHui09151 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String kAndN=sc.nextLine();
        String[] kAndNArrays=kAndN.split(" ");
        int k=Integer.valueOf(kAndNArrays[0]);
        int n=Integer.valueOf(kAndNArrays[1]);

        //建立二维矩阵
        int[][] nums=new int[n][n];

        //填充矩阵
        for(int i=0;i<n;i++){
            String tempIns=sc.nextLine();
            String tempInsArray[]=tempIns.split(" ");
            for(int j=0;j<n;j++){
                nums[i][j]=Integer.valueOf(tempInsArray[j]);
            }
        }

        int row=0,col=n-1;
        int index=row*n+col+1;
        while(index!=k){
            if(index<k){
                row++;
            }else{
                if(col==0){
                    row--;
                    col=n-1;
                }else{
                    col--;
                }
            }
            index=row*n+col+1;
        }
        System.out.println(nums[row][col]);
    }
}
