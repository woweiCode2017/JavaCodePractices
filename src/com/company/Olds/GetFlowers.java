package com.company.Olds;

import java.util.Scanner;

/**
 * Created by 11239 on 2018/8/27.
 */
public class GetFlowers {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String nums=sc.nextLine();
        String[] numsArray=nums.split(" ");
        int times=Integer.valueOf(numsArray[0]);
        int types=Integer.valueOf(numsArray[1]);
        int[] timVie=new int[times];
        String timVieIn=sc.nextLine();
        String[] timeIns=timVieIn.split(" ");
        for(int i=0;i<times;i++){
            timVie[i]=Integer.valueOf(timeIns[i]);
        }
        int quests=Integer.valueOf(sc.nextLine());
        int qus[][]=new int[quests][2];
        for(int j=0;j<quests;j++){

        }

    }
}
