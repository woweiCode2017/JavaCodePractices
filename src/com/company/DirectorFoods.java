package com.company;

import java.util.Scanner;

/**
 * Created by 11239 on 2018/9/15.
 *
 * 判断局长N种食物在M天后的P类食物分数排名
 *
 */
public class DirectorFoods {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        //FirstLine
        String firstLine=sc.nextLine();
        String [] firstArrays=firstLine.split(" ");
        int kind=Integer.valueOf(firstArrays[0]);
        int day=Integer.valueOf(firstArrays[1]);
        int target=Integer.valueOf(firstArrays[2]);

        int [] res=new int[kind];
        String[] modes=new String[day];
        int [] nums=new int[day];

        //second Line
        String secondLine=sc.nextLine();
        String secondArrays[]=secondLine.split(" ");
        for(int i=0;i<secondArrays.length;i++){
            int tempRes=Integer.valueOf(secondArrays[i]);
            res[i]=tempRes;
        }

        for(int i=0;i<day;i++){
            String temps=sc.nextLine();
            String tempsArray[]=temps.split(" ");
            modes[i]=tempsArray[0];
            nums[i]=Integer.valueOf(tempsArray[1]);
        }

        //处理所有day
        for(int i=0;i<day;i++){
            String mode=modes[i];
            int num=nums[i];
            if("A".equals(mode)){
                res[num-1]-=1;
            }else{
                res[num-1]+=1;
            }
        }

        //排序
        int index[]=new int[kind];
        for(int i=0;i<kind;i++){
            index[i]=0;
        }
        int rand=0;
        if(target!=findMin(res,index)){
            rand++;
        }
        System.out.println(rand);
    }

    private static int findMin(int[] res, int[] index) {
        int tempIndex = 0;
        int tempMin = Integer.MIN_VALUE;
        for (int i = 0; i < res.length; i++) {
            if (index[i] >= 0) {
                continue;
            } else {
                if (tempMin >= res[i]) {
                    tempMin = res[i];
                    tempIndex = i;
                }
            }
        }
         index[tempIndex]=1;
        return tempIndex;
    }

}
