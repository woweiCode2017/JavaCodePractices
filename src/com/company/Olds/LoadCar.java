package com.company.Olds;

import java.awt.font.FontRenderContext;
import java.util.Scanner;

/**
 * Created by 11239 on 2018/7/22.
 */
public class LoadCar {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String [] inNums=str.split(" ");
        int[] nums=new int[inNums.length];
        for(int i=0;i<inNums.length;i++){
            nums[i]=Integer.parseInt(inNums[i]);
        }
        int test=0;
        for(int i=0;i<nums.length;i++){
            test+=nums[i];
        }
        if(test<=300){
            System.out.print(1);
            return;
        }
        int carNum=0;
        int nowLod=0;
        for(int i=0;i<nums.length;){
            if(nowLod+nums[i]>300){
                nowLod=0;
                carNum++;
            }
            nowLod+=nums[i++];
        }
        System.out.print(carNum);
        return;
    }

}
