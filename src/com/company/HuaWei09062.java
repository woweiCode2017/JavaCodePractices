package com.company;

import sun.misc.Compare;

import java.util.*;

/**
 * Created by 11239 on 2018/9/6.
 * 给出一串字符串，按字符串出现的频次从低到高打印
 * 次数相同时，字符小的先打印
 *
 */
public class HuaWei09062 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        if(input.length()==0)
            System.out.println("false");;
        char[] inputArray=input.toCharArray();
        HashMap<String,Integer> map=new HashMap<>();
        StringBuilder sb=new StringBuilder();
        StringBuilder sbInt=new StringBuilder();
        for(int i=0;i<inputArray.length;i++){
            if(inputArray[i]>='0'&&inputArray[i]<='9'){
                while(i<inputArray.length&&inputArray[i]>='0'&&inputArray[i]<='9'){
                    sbInt.append(inputArray[i]);
                    i++;
                }
                i--;
                map.put(sb.toString(),new Integer(sbInt.toString()));
                sb=new StringBuilder();
                sbInt=new StringBuilder();
            }else{
                sb.append(inputArray[i]);
            }
        }
        List<Map.Entry<String,Integer>> list=new ArrayList<>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>(){
            @Override
            public int compare(Map.Entry<String,Integer> first,Map.Entry<String,Integer> second) {
                if(first.getValue().equals(second.getValue())){
                    return  first.getKey().compareTo(second.getKey());
                }else{
                    return first.getValue().compareTo(second.getValue());
                }
            }
        });
        for(int i=0;i<list.size();i++){
            int temp=list.get(i).getValue();
            String val=list.get(i).getKey();
            for(int j=0;j<temp;j++){
                System.out.print(val);
            }
        }
    }
}
