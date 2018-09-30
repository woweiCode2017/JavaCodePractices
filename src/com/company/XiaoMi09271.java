package com.company;

import java.util.*;

/**
 * Created by 11239 on 2018/9/27.
 *
 * 集合合并
 *
 */
public class XiaoMi09271 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int nums=Integer.valueOf(sc.nextLine());
        List<HashSet<String>> res=new ArrayList<HashSet<String>>(nums);

        for(int i=0;i<nums;i++){
            HashSet<String> tempRes=new HashSet<>();
            String tempIn=sc.nextLine();
            String tempInArray[]=tempIn.split(" ");
            for(int j=0;j<tempInArray.length;j++){
                tempRes.add(tempInArray[j]);
            }
            res.add(tempRes);
        }

        int indexs[]=new int[2];
        //判断是否存在两个集合有交集
        while(existJiaoJi(res,indexs)){
            conbaimRes(res,indexs);
        }

        List<Integer> outRes=new ArrayList<>(2);
        outRes.add(res.size());
        int maxSize=0;
        Iterator<HashSet<String>> it=res.iterator();
        while(it.hasNext()){
            int tempSize=it.next().size();
            if(tempSize>maxSize)
                maxSize=tempSize;
        }
        outRes.add(maxSize);

        for(int i=0;i<outRes.size();i++){
            System.out.println(outRes.get(i));
        }
    }

    private static void conbaimRes(List<HashSet<String>> res, int[] indexs) {
        HashSet<String> first=res.get(indexs[0]);
        HashSet<String> second=res.get(indexs[1]);
        if(indexs[0]>indexs[1]){
            res.remove(indexs[0]);
            res.remove(indexs[1]);
        }else{
            res.remove(indexs[1]);
            res.remove(indexs[0]);
        }
        Iterator<String> it=first.iterator();
        while(it.hasNext()){
            second.add(it.next());
        }
        res.add(second);
    }

    private static boolean existJiaoJi(List<HashSet<String>> res,int[] indexs) {
        boolean flag=false;
        indexs[0]=indexs[1]=0;
        for(int i=0;i<res.size()-1;i++){
            for(int j=i+1;j<res.size();j++){
                HashSet<String> first=res.get(i);
                HashSet<String> second=res.get(j);
                Iterator<String> itFirst=first.iterator();
                Iterator<String> itSecond=second.iterator();
                HashSet<String> res1=new HashSet<>();
                HashSet<String> res2=new HashSet<>();
                while(itFirst.hasNext()){
                    res1.add(itFirst.next());
                }
                while(itSecond.hasNext()){
                    res2.add(itSecond.next());
                }
                res1.retainAll(res2);
                if(res1.size()>0){
                    indexs[0]=i;
                    indexs[1]=j;
                    flag=true;
                    return flag;
                }
            }
        }
        return flag;
    }
}
