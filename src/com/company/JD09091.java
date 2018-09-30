package com.company;

import java.util.*;

/**
 * Created by 11239 on 2018/9/9.
 *
 * 完全多部图
 *
 */
public class JD09091 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=Integer.valueOf(sc.nextLine());

        List<int[][]> listRoads=new ArrayList<>();
        int [] pointNum=new int[num];
        int [] roadNum=new int[num];
        for(int i=0;i<num;i++){
            String pointAndRoads=sc.nextLine();
            String[] parArray=pointAndRoads.split(" ");
            pointNum[i]=Integer.valueOf(parArray[0]);
            roadNum[i]=Integer.valueOf(parArray[1]);
            int [][] roads=new int[roadNum[i]][2];
            for(int j=0;j<roadNum[i];j++){
                  String getIn=sc.nextLine();
                  String getArray[]=getIn.split(" ");
                  roads[j][0]=Integer.valueOf(getArray[0]);
                  roads[j][1]=Integer.valueOf(getArray[1]);
            }
            listRoads.add(roads);
        }

        //判断是否全部图
        String [] res=new String[listRoads.size()];
        for(int i=0;i<listRoads.size();i++){
            boolean tempRes=check(pointNum[i],roadNum[i],listRoads.get(i));
            if(tempRes){
                res[i]="Yes";
            }else{
                res[i]="No";
            }
        }

        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }

    }

    private static boolean check(int n, int k, int[][] roads) {
        boolean res=true;
        //统计每个点的连接数
        int [][] lianjie=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                lianjie[i][j]=0;
            }
        }
        for(int i=0;i<k;i++){
            int row=roads[i][0];
            int col=roads[i][1];
            lianjie[row][col]=1;
        }
        //已分组


        //判断组间是否符合要求

        return res;
    }

}
