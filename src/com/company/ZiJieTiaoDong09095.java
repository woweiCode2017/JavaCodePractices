package com.company;

import java.util.*;

/**
 * Created by 11239 on 2018/9/9.
 *
 * 抖音红人问题
 */
public class ZiJieTiaoDong09095 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int personNum=Integer.valueOf(sc.nextLine());
        int relationNum=Integer.valueOf(sc.nextLine());
        String relation=sc.nextLine();
        String[] relaArray=relation.split(" ");

        Map<String,HashSet<String>> resMap=new HashMap<>();
        //创建所有的人员及被关注信息
        for(int i=0;i<personNum;i++){
            HashSet<String> watcher=new HashSet<>();
            resMap.put(String.valueOf(i),watcher);
        }
        //创建关注信息
        Map<String,HashSet<String>> resWatch=new HashMap<>();
        for(int i=0;i<relationNum;i++){
            String person=relaArray[2*i];
            String watch=relaArray[2*i+1];
            if(resWatch.containsKey(person)){
                resWatch.get(person).add(watch);
            }else{
                HashSet<String> tempSet=new HashSet<>();
                tempSet.add(watch);
                resWatch.put(person,tempSet);
            }
        }
        //统计被关注者
        for(Map.Entry<String,HashSet<String>> entry:resMap.entrySet()){
            getFlowWatchher(entry.getKey(),entry.getValue(),resWatch);
        }
        int count=0;
        for(Map.Entry<String,HashSet<String>> entry:resMap.entrySet()){
            if(entry.getValue().size()>=personNum-1)
                count++;
        }
        System.out.println(count);
    }

    private static void getFlowWatchher(String key, HashSet<String> value, Map<String, HashSet<String>> resWatch) {

    }
}
