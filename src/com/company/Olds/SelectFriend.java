package com.company.Olds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 11239 on 2018/8/5.
 * 从输入中找出最可能是给出的用户的朋友的序号
 */
public class SelectFriend {
    public int getFriend(){
        Scanner sc=new Scanner(System.in);
        String useStr=sc.nextLine();
        int userNum=Integer.valueOf(useStr.split(" ")[0]);
        int target=Integer.valueOf(useStr.split(" ")[1]);
        List<String []> userFriends=new ArrayList<String []>();
        for(int i=userNum;i>0;i--){
            String temp=sc.nextLine();
            userFriends.add(temp.split(" "));
        }
        String [] compares= userFriends.get(target);
        List<String> compList=Arrays.asList(compares);
        int [] counts=new int[userNum];
        for(int i=1;i<userFriends.size();i++){
            int count=0;
            String [] temp=userFriends.get(i);
            for(int j=0;j<temp.length;j++){
                if(compList.contains(temp[j])){
                    count++;
                }
            }
            counts[i]=count;
        }
        int max=counts[0],res=-1;
       for(int i=1;i<counts.length;i++){
            if(counts[i]>max){
                max=counts[i];
                res=i;
            }
       }
       return max>0?res:-1;
    }

}
