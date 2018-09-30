package com.company;

import java.util.*;

/**
 * Created by 11239 on 2018/9/6.
 * 统计字符串s中在k长度的区间内包含重复元素的个数大于t的区间个数
 */
public class Meituan09062 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String params=sc.nextLine();
        String paramsArray[]=params.split(" ");
        int count=Integer.valueOf(paramsArray[0]);
        int len=Integer.valueOf(paramsArray[1]);
        int time=Integer.valueOf(paramsArray[2]);
        String numsInput=sc.nextLine();
        String[] numsArray=numsInput.split(" ");
        int begin=0;
        int end=len;
        int res=0;
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<len;i++){
            putInMap(map,numsArray[i]);
        }
        while(end<count){
            res+=checkNum(map,time);
            delOutMap(map,numsArray[begin++]);
            putInMap(map,numsArray[end++]);
        }
        res+=checkNum(map,time);
        System.out.println(res);
    }

    private static void delOutMap(Map<String, Integer> map, String s) {
        map.put(s,map.get(s)-1);
    }

    private static int checkNum(Map<String, Integer> map, int time) {
        int count=0;
        List<Map.Entry<String,Integer>> list=new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        if(list.get(list.size()-1).getValue()>=time)
            count+=1;
        return count;
    }

    private static void putInMap(Map<String, Integer> map, String s) {
        if(map.containsKey(s)){
            map.put(s,map.get(s)+1);
        }else{
            map.put(s,1);
        }
    }
}
