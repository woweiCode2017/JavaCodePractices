package com.company.Olds;


import java.util.Scanner;

/**
 * Created by 11239 on 2018/8/27.
 */
public class BuildCity {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int nums=Integer.valueOf(sc.nextLine());
        int[] xs=new int[nums];
        int[] ys=new int[nums];
        for(int i=0;i<nums;i++){
            String ins=sc.nextLine();
            String[] tempIns=ins.split(" ");
            xs[i]=Integer.valueOf(tempIns[0]);
            ys[i]=Integer.valueOf(tempIns[1]);
        }
        int xmin=xs[0];
        int xmax=xs[0];
        for(int i=1;i<nums;i++){
            if(xs[i]<xmin)
                xmin=xs[i];
            if(xs[i]>xmax)
                xmax=xs[i];
        }
        int ymin=ys[0];
        int ymax=ys[0];
        for(int i=1;i<nums;i++){
            if(ys[i]<ymin)
                ymin=ys[i];
            if(ys[i]>ymax)
                ymax=ys[i];
        }
        int length=(xmax-xmin)>(ymax-ymin)?(xmax-xmin):(ymax-ymin);
        System.out.println(length*length);
    }

}
