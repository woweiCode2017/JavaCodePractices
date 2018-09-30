package com.company.Olds;

import java.io.OutputStream;
import java.util.Scanner;

/**
 * Created by 11239 on 2018/8/28.
 */
public class Yuyunsuan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.valueOf(sc.nextLine());
        int[][] nums = new int[num][2];
        for (int i = 0; i < num; i++) {
            String in=sc.nextLine();
            String[] ins=in.split(" ");
            nums[i][0]=Integer.valueOf(ins[0]);
            nums[i][1]=Integer.valueOf(ins[1]);
        }
        for(int i=0;i<num;i++){
            int tar=nums[i][0];
            int index=nums[i][1];
            int count=0;
            int out=0;
            int temp=1;
            while(count<index){
                if((tar+temp)==(tar|temp)){
                    out=temp;
                    count++;
                }
                    temp++;
            }
        System.out.println(out);
        }
    }
}
