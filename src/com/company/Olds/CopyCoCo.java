package com.company.Olds;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 11239 on 2018/7/22.
 */
public class CopyCoCo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int number=sc.nextInt();
        String[] names=new String[]{"Alice","Bob","Cathy","Dave"};
        if(number<=4){
            System.out.print(names[number-1]);
            return;
        }
        int lun=0;
        int nowNum=4;
        int total=0;
        List<Integer> totals=new ArrayList<Integer>();
        while(total<=number){
            total+=nowNum;
            totals.add(total);
            lun++;
            nowNum*=2;
        }
        int resLun=lun;
        int lunCount=4*(2^lun);
        int index=number-totals.get(lun-2);
        int nameIndex=0;
        for(int count=index;count<=lun;count=count-(lunCount/4)){
            if (count==lun){
                System.out.print(names[nameIndex]);
                return ;
            }
            nameIndex++;
        }
        System.out.print(names[nameIndex]);
        return;
    }
}
