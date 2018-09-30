package com.company.Olds;

import java.util.*;

/**
 * Created by 11239 on 2018/8/9.
 * 号码归属地查询
 */
public class NumberCheck {
    public static void numberCheck(){
        Scanner sc=new Scanner(System.in);
        int bandNum=sc.nextInt();
        List<HashMap<String,String>> numsAndRules=new ArrayList<HashMap<String,String>>(bandNum*2);
        while(bandNum>0){
            int ruleNum=sc.nextInt();
            HashMap<String,String> rule=new HashMap<>(ruleNum);
            while(ruleNum>0){
                String ruleIn="";
                while("".equals(ruleIn))
                    ruleIn=sc.nextLine();
                String[] numAndPlace=ruleIn.split(" ");
                String temprule=numAndPlace[0];
                if(temprule.matches(".*x.*")){
                    rule.put(temprule.substring(0,temprule.indexOf('x')),numAndPlace[1]);
                }else{
                    rule.put(temprule,numAndPlace[1]);
                }
                ruleNum--;
            }
            numsAndRules.add(rule);
            int numberNum=sc.nextInt();
            HashMap<String,String> res=new HashMap<>(numberNum);
            while(numberNum>0){
                String numIn="";
                while("".equals(numIn))
                    numIn=sc.nextLine();
                res.put(numIn,"");
                numberNum--;
            }
            numsAndRules.add(res);
            bandNum--;
        }
        for(int i=0;i<bandNum;i++){
            HashMap<String,String> rules=numsAndRules.get(i*2);
            HashMap<String,String> nums=numsAndRules.get(i*2+1);
            for (Map.Entry<String,String> numentry:nums.entrySet()) {
                String numtar=numentry.getKey();
                for (Map.Entry<String,String> ruleentry:rules.entrySet()) {
                    if(numtar.contains(ruleentry.getKey())){
                        nums.put(numentry.getKey(),ruleentry.getValue());
                        break;
                    }
                    nums.put(numentry.getKey(),"unKnown");;
                }
            }
        }
        for(int i=0;i<bandNum;i++){
            HashMap<String,String> nums=numsAndRules.get(i*2+1);
            for(Map.Entry<String,String> entry:nums.entrySet()){
                System.out.println(entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        numberCheck();
    }
}
