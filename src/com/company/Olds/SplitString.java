package com.company.Olds;

import java.util.Scanner;

/**
 * Created by 11239 on 2018/8/5.
 * 切分字符串形成两个数字
 */
public class SplitString {
    public static int splitString(){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        char[] nums=str.toCharArray();
        int count=0;
        for(int i=1;i<nums.length;i++){
            int[] first=new int [i];
            int[] second=new int[nums.length-i];
            for(int j=0;j<nums.length;j++) {
                if (j < i) {
                    first[j] = nums[j];
                } else {
                    second[j - i] = nums[j];
                }
            }
                count+=getCount(first);
                count+=getCount(second);
        }
        return count;
    }
    private static int getCount(int[] nums) {
        if(nums.length==1&&nums[0]==0)
            return 0;
        if(nums[0]==0){
            for(int i=1;i<nums.length;i++){
                if(nums[nums.length-1]==0) {
                    return 0;
                }
                if(nums[i]==0){
                    return i;
                }
            }
        }
        return nums.length-1;
    }

    public static void main(String[] args) {
        System.out.print(splitString());
    }
}
