package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 11239 on 2018/9/21.
 *
 * 最优人员分配问题
 *
 *   2
     2 2 1
     99 98
     98 99
     3 2 1
     99 98
     96 92
     94 94
 *
 * 198
   194
 */
public class SanFor09214 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int nums=Integer.valueOf(sc.nextLine());
        int params[][]=new int[nums][3];
        List<String[]> values=new ArrayList<>(nums);

        for(int i=0;i<nums;i++){
            String tempNums=sc.nextLine();
            String tempNumsArray[]=tempNums.split(" ");
            for(int j=0;j<3;j++){
                params[i][j]=Integer.valueOf(tempNumsArray[j]);
            }
            String tempVlaues[]=new String[Integer.valueOf(tempNumsArray[0])];
            for(int j=0;j<Integer.valueOf(tempNumsArray[0]);j++){
                tempVlaues[j]=sc.nextLine();
            }
            values.add(tempVlaues);
        }

        int res[]=new int[nums];
        for(int i=0;i<nums;i++){
            res[i]=getMaxValue(params[i],values.get(i));
        }

        for(int i=0;i<nums;i++){
            System.out.println(res[i]);
        }
    }

    private static int getMaxValue(int[] param, String[] strings) {
        int res=0;
        int persons=param[0];
        int partMent=param[1];
        int needPersons=param[2];
        int value[][]=new int[persons][partMent];
        for(int i=0;i<persons;i++){
            String temp[]=strings[i].split(" ");
            for(int j=0;j<partMent;j++){
                value[i][j]=Integer.valueOf(temp[j]);
            }
        }

        return res;
    }
}
