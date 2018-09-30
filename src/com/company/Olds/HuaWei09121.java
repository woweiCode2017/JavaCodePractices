package com.company.Olds;

import java.util.*;

/**
 * Created by 11239 on 2018/9/12.
 *
 * 输出最后一个只出现一次的字符
 *
 */
public class HuaWei09121 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String ins=sc.nextLine();
        char[] inArray=ins.toCharArray();
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<inArray.length;i++){
            getCharTime(map,inArray[i]);
        }
        List<String> list=new ArrayList<>();
        for(int i=0;i<inArray.length;i++){
            addOnceChar(list,inArray[i],map);
        }
        if(list.size()>0) {
            System.out.println(list.get(list.size() - 1));
        }else{
            System.out.println("NULL");
        }
    }

    private static void addOnceChar(List<String> list, char c, Map<String, Integer> map) {
        String target=c+"";
        Integer time=map.get(target);
        if(time.equals(1)){
            list.add(target);
        }
    }

    private static void getCharTime(Map<String, Integer> map, char c) {
        String target=c+"";
        if(map.containsKey(target)){
            map.put(target,map.get(target)+1);
        }else{
            map.put(target,1);
        }
    }
}
