package com.company.Olds;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 11239 on 2018/8/11.
 */
public class InterPoint {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int time,weakTime;
            time=sc.nextInt();
            weakTime=sc.nextInt();
            int [] interPoint=new int[time];
            int [] weakPoint=new int[time];
            for(int i=0;i<time;i++){
                interPoint[i]=sc.nextInt();
            }
            for(int j=0;j<time;j++){
                weakPoint[j]=sc.nextInt();
            }
            int baseRes=0,sleeptime=0;
            List<Integer> points=new ArrayList<>();
            for(int i=0;i<time;i++){
                if(weakPoint[i]==1){
                    baseRes+=interPoint[i];
                }else{
                    sleeptime++;
                    points.add(i);
                }
            }
            int [] res=new int[sleeptime];
            for(int j=0;j<sleeptime;j++){
                int begin=points.get(j);
                for(int k=0;k<3;k++){
                    if(begin+k>time-1){break;}
                    if(weakPoint[begin+k]==0){
                        res[j]+=interPoint[begin+k];
                    }
                }
            }
            int max=res[0];
            for(int i=0;i<res.length;i++){
                if(res[i]>max)
                    max=res[i];
            }
            System.out.println(max+baseRes);
        }
    }

