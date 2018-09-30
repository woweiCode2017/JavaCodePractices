package com.company;

import java.util.Scanner;

/**
 * Created by 11239 on 2018/9/15.
 *
 * 六位数字，变更一位数字，使之变成幸运数字
 * 最少几次
 */
public class AQiYi09151 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String ins=sc.nextLine();
        char[] insArray=ins.toCharArray();
        int nums[]=new int[insArray.length];
        for(int i=0;i<insArray.length;i++){
            nums[i]=insArray[i]-'0';
        }

        int times=0;
        boolean flag=((nums[0]+nums[1]+nums[2])==(nums[3]+nums[4]+nums[5]));
        while(!flag){
            //变更数字
            int before=nums[0]+nums[1]+nums[2];
            int after=nums[3]+nums[4]+nums[5];
            int dif=Math.abs(before-after);
            if(before>after){
                int maxToUp=findMaxToUP(nums,1);
                int maxToBottom=findMaxToBottom(nums,0);
                if(maxToUp>maxToBottom){
                    //增加after
                    if(maxToUp>=dif){
                        change(dif,1,1,nums);
                    }else{
                        change(maxToUp,1,1,nums);
                    }
                }else{
                    //减少before
                    if(maxToBottom>=dif){
                        change(dif,0,0,nums);
                    }else{
                        change(maxToBottom,0,0,nums);
                    }
                }
            }else{
                //后段较大  较小后端 增加前端
                int maxToUp=findMaxToUP(nums,0);
                int maxToBottom=findMaxToBottom(nums,1);
                if(maxToUp>maxToBottom){
                    //增加before
                    if(maxToUp>=dif){
                        change(dif,1,0,nums);
                    }else{
                        change(maxToUp,1,0,nums);
                    }
                }else{
                    //减少after
                    if(maxToBottom>=dif){
                        change(dif,0,1,nums);
                    }else{
                        change(maxToBottom,0,1,nums);
                    }
                }
            }
            // 判断是否幸运数字
            flag=isLuckyNum(nums);
            times++;
        }
        System.out.println(times);
    }

    private static void change(int dif, int addOrsub, int bOrA, int[] nums) {
        if(bOrA>0){
            //后半段
            if(addOrsub>0){
                //增加
                int min=3;
                int minNum=9-nums[3];
                if(minNum<(9-nums[4])){
                    minNum=9-nums[4];
                    min=4;
                }
                if(minNum<(9-nums[5])){
                    minNum=9-nums[5];
                    min=5;
                }
                nums[min]=nums[min]-0+dif;
            }else{
                //减少
                int max=3;
                int maxNum=nums[3]-0;
                if(maxNum<(nums[4]-0)){
                    maxNum=nums[4]-0;
                    max=4;
                }
                if(maxNum<(nums[5]-0)){
                    maxNum=nums[5]-0;
                    max=5;
                }
                nums[max]=nums[max]-0-dif;
            }
        }else{
            //前半段
            if(addOrsub>0){
                //增加
                int min=0;
                int minNum=9-nums[0];
                if(minNum<(9-nums[1])){
                    minNum=9-nums[1];
                    min=1;
                }
                if(minNum<(9-nums[2])){
                    minNum=9-nums[2];
                    min=2;
                }
                nums[min]=nums[min]-0+dif;
            }else{
                //减少
                int max=0;
                int maxNum=nums[0]-0;
                if(maxNum<(nums[1]-0)){
                    maxNum=nums[1]-0;
                    max=1;
                }
                if(maxNum<(nums[2]-0)){
                    maxNum=nums[2]-0;
                    max=2;
                }
                nums[max]=nums[max]-0-dif;
            }
        }
    }

    private static int findMaxToBottom(int[] nums, int i) {
        int num=0;
        if(i>0){
            num=nums[3]-0;
            if(num<(nums[4]-0))
                num=nums[4]-0;
            if(num<(nums[5]-0))
                num=nums[5]-0;
        }else{
            num=nums[0]-0;
            if(num<(nums[1]-0))
                num=nums[1]-0;
            if(num<(nums[2]-0))
                num=nums[2]-0;
        }
        return num;
    }

    private static int findMaxToUP(int[] nums, int i) {
        int num=0;
        if(i==0){
            num=9-nums[0];
            if(num<(9-nums[1]))
                num=9-nums[1];
            if(num<(9-nums[2]))
                num=9-nums[2];
        }else{
            num=9-nums[3];
            if(num<(9-nums[4]))
                num=9-nums[4];
            if(num<(9-nums[5]))
                num=9-nums[5];
        }
        return num;
    }

    private static boolean isLuckyNum(int[] nums) {
        boolean flag;
        int before=nums[0]+nums[1]+nums[2];
        int after=nums[3]+nums[4]+nums[5];
        flag=(before==after);
        return flag;
    }
}
