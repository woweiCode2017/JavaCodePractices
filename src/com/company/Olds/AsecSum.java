package com.company.Olds;

        import java.util.Scanner;

/**
 * Created by 11239 on 2018/8/28.
 */
public class AsecSum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String [] getIn=sc.nextLine().split(" ");
        int[] nums=new int[getIn.length];
        for(int i=0;i<getIn.length;i++){
            nums[i]=Integer.valueOf(getIn[i]);
        }
        int max=0;
        for(int i=0;i<nums.length;i++){
            int tem=nums[i];
            int temMax=nums[i];
            for(int j=i+1;j< nums.length;j++){
                if(nums[j]>temMax){
                    temMax=nums[j];
                    tem+=nums[j];
                }
            }
            if(tem>max)
                max=tem;
        }
        System.out.println(max);
    }
}
