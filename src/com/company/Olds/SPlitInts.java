package com.company.Olds;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by 11239 on 2018/8/28.
 */
public class SPlitInts {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        char [] numToString=String.valueOf(num).toCharArray();
        Set nums=new HashSet<String>();
        for(int i=0;i<numToString.length;i++){
            if(numToString[i]=='0')
                continue;
            StringBuilder sb=new StringBuilder();
            sb.append(numToString[i]);
            nums.add(sb.toString());
            for(int j=i+1;j<numToString.length;j++){
                sb.append(numToString[j]);
                nums.add(sb.toString());
            }
        }
        int count=0;
        Iterator it = nums.iterator();
        while(it.hasNext()){
            String numGet=it.next().toString();
            int number=Integer.valueOf(numGet);
            if(number%3==0)
                count++;
        }
        System.out.println(count);
    }
}
