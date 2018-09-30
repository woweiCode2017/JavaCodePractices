package com.company.Olds;

import java.util.*;

/**
 * Created by 11239 on 2018/8/18.
 */
public class MakeRoads {


    static int calculate(int[] locations) {
        int[][] distanceMat; // 距离矩阵
        int pointNum = locations.length;
        distanceMat = new int[pointNum][pointNum];
        int[] disInt = new int[pointNum * (pointNum - 1) / 2];
        String[] disString = new String[pointNum * (pointNum - 1) / 2];

        int index = 0;
        for (int i = 0; i < pointNum - 1; i++) {
            distanceMat[i][i] = 0;
            for (int j = i + 1; j < pointNum; j++) {
                distanceMat[i][j] = distance(locations[i], locations[j]);
                disInt[index] = distanceMat[i][j];
                disString[index] = i + " " + j;
                index++;
                distanceMat[j][i] = distanceMat[i][j];
            }
        }

        int length = 0;
        Set<Integer> gets = new HashSet<>(pointNum);

        while (gets.size() < pointNum) {
            int minIndex = 0;
            for (int i = 1; i < disInt.length; i++) {
                if (disInt[i] < disInt[minIndex]) {
                    minIndex = i;
                }
            }
            String[] tempInt = disString[minIndex].split(" ");
            if (gets.add(new Integer(tempInt[0]))) {
                gets.add(new Integer(tempInt[1]));
                length += disInt[minIndex];
                disInt[minIndex] = 10001;
            } else if (gets.add(new Integer(tempInt[1]))) {
                gets.add(new Integer(tempInt[0]));
                length += disInt[minIndex];
                disInt[minIndex] = 10001;
            }
            for(int j=0;j<gets.size()-1;j++){
                for(int k=j+1;k<gets.size();k++){
                    String temp=null;
                  //  String temp=gets[j]+" "+gets.iterator().next();                      ?????
                    for(int m=0;m<disString.length;m++){
                        if(temp.equals(disString[m])){
                            disInt[m]=10001;
                        }
                    }
                }
            }
        }
        return length;
    }


    static int distance(int first, int last) {
        return first > last ? first : last;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine().trim());
        int[] locations = new int[num];
        String[] inLocations = sc.nextLine().split(" ");
        for (int i = 0; i < num; i++) {
            locations[i] = Integer.parseInt(inLocations[i]);
        }
        System.out.println(calculate(locations));
    }
}
