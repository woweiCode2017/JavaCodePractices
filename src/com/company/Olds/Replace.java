package com.company.Olds;

import java.util.Scanner;

/**
 * Created by 11239 on 2018/8/28.
 */
public class Replace {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String sentence=sc.nextLine();
        String tar=sc.nextLine();
        String rep=sc.nextLine();
        System.out.println(sentence.replace(tar,rep));
    }
}
