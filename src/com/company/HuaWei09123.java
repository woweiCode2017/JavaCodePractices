package com.company;

import java.util.Scanner;
import java.util.Vector;

/**
 * Created by 11239 on 2018/9/12.
 *
 * 字符串数字相乘
 *
 */
public class HuaWei09123 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char[] num1=sc.nextLine().toCharArray();
        char[] num2=sc.nextLine().toCharArray();

        int capacity=num1.length+num2.length;
        Vector<Integer> vs=new Vector<>(capacity);
        for(int i=0;i<capacity;i++){
            vs.add(0);
        }

        int index=num1.length+num2.length-2;
        for(int i=0;i<num1.length;i++){
            for(int j=0;j<num2.length;j++){
                vs.set(index - i - j, (vs.get(index-i-j)+(num1[i] - '0') * (num2[j] - '0')));
            }
        }

        int more=0;
        for(int i=0;i<capacity;i++){
            vs.set(i,vs.get(i)+more);
            more=vs.get(i)%10;
            more=vs.get(i)/10;
        }

        int i=vs.size()-1;
        while(vs.get(i).equals(0)){
            if(i>0){
                i--;
            }else{
                System.out.println("0");
                return;
            }
        }
        StringBuilder sb=new StringBuilder();
        while(i>=0){
                sb.append(vs.get(i));
                i--;
        }
        System.out.println(sb.toString());
    }

    //通过版
    private void pass() {
        Scanner in = new Scanner(System.in);
        String num1 = in.nextBigInteger().toString();
        String num2 = in.nextBigInteger().toString();
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        bigMultify(arr1, arr2);

    }
    public static void bigMultify(char[] arr1,char[] arr2) {
        int length1 = arr1.length;
        int length2 = arr2.length;
        int[] res = new int[length1+length2-1];
        int[] intArr1 = new int[length1];
        for (int i = 0; i < length1; i++) {
            intArr1[i] = arr1[i]-'0';
        }
        int[] intArr2 = new int[length2];
        for (int i = 0; i < length2; i++) {
            intArr2[i] = arr2[i]-'0';
        }
        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                res[i+j]+=intArr1[i]*intArr2[j];
            }
        }
        for(int i =res.length-1; i > 0 ;i--){
            res[i-1] += res[i] / 10;
            res[i] = res[i] % 10;
        }
        for (int i : res) {
            System.out.print(i);
        }
    }
}
