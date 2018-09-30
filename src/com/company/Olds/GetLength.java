package com.company.Olds;

import java.util.*;

/**
 * Created by 11239 on 2018/8/27.
 */
public class GetLength {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int nums=Integer.valueOf(sc.nextLine());
        int [] A=new int[nums];
        int [] B=new int[nums];
        String As=sc.nextLine();
        String Bs=sc.nextLine();
        String[] AsArray=As.split(" ");
        String[] BsArray=Bs.split(" ");
       // List a=new ArrayList<Integer>();
        for(int i=0;i<nums;i++){
            A[i]=Integer.valueOf(AsArray[i]);
            B[i]=Integer.valueOf(BsArray[i]);
        }
        int length=0;
        Set resutls=new HashSet<Integer>();
        for(int i=0;i<nums;i++){
            for(int j=i+1;j<nums;j++){
                int ai=A[i];
                int bj=B[j];
                Boolean b=ifbBehinda(ai,bj,B);
                if(b){
                    resutls.add(ai);
                    resutls.add(bj);
                }
            }
        }
        System.out.println(resutls.size());
    }
    private static Boolean ifbBehinda(int a,int b,int [] targets){
        Boolean res=false;
        int aIndex=0;
        int bIndex=0;
        for(int i=0;i<targets.length;i++){
            if(targets[i]==a)
                aIndex=i;
            if(targets[i]==b)
                bIndex=i;
        }
        return aIndex>bIndex;
    }
}
