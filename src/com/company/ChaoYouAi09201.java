package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 11239 on 2018/9/20.
 *
 * 合并输入的日期
 *
 */
public class ChaoYouAi09201 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=Integer.valueOf(sc.nextLine());
        int[] nums=new int[num];
        String ins=sc.nextLine();
        String insArray[]=ins.split(" ");
        for(int i=0;i<insArray.length;i++){
            nums[i]=Integer.valueOf(insArray[i]);
        }

        int firstIndex=0;
        int lastIndex=0;
        List<String> res=new ArrayList<>();
        for(int i=1;i<insArray.length;i++){
            if(nums[i]-nums[lastIndex]==1){
                lastIndex=i;
            }else{
                if(lastIndex-firstIndex+1>=3){
                    res.add(nums[firstIndex]+"-"+nums[lastIndex]);
                }else{
                    for(int j=firstIndex;j<=lastIndex;j++){
                        if(j!=i)
                        res.add(String.valueOf(nums[j]));
                    }
                }
                res.add(String.valueOf(nums[i]));
                firstIndex=lastIndex=i+1;
            }
        }
        if(firstIndex<nums.length){
            if(lastIndex-firstIndex+1>=3){
                res.add(nums[firstIndex]+"-"+nums[lastIndex]);
            }else{
                for(int i=firstIndex;i<nums.length;i++){
                    res.add(String.valueOf(nums[i]));
                }
            }
        }

        for(int i=0;i<res.size();i++){
            System.out.print(res.get(i)+" ");
        }
    }
}
