package com.company;

import java.util.Scanner;

/**
 * Created by 11239 on 2018/9/6.
 * <p>
 * 26进制加法运算
 * <p>
 * 规定：a-z 表示 0-25
 * 给定两串字符串，相加之后输出
 */
public class HuaWei09061 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String inputFirst = sc.nextLine();
        String inputSecond = sc.nextLine();
        char[] inputFirstArray = inputFirst.toCharArray();
        char[] inputSecondArray = inputSecond.toCharArray();
        int length = inputFirstArray.length > inputSecondArray.length ? inputFirstArray.length : inputSecondArray.length;
        char[] res = new char[length];
        int indexFirst = inputFirstArray.length - 1;
        int indexSecond = inputSecondArray.length - 1;
        int jinwei = 0;

        for (int i = length - 1; i >= 0; i--) {
            if (indexFirst < 0) {
                res[i] = (char) (inputSecondArray[indexSecond] + jinwei);
                indexSecond--;
                continue;
            }
            if (indexSecond < 0) {
                res[i] = (char) (inputFirstArray[indexFirst] + jinwei);
                indexFirst--;
                continue;
            }
            res[i] = (char) ((inputFirstArray[indexFirst] + inputSecondArray[indexSecond] + jinwei - 2 * 'a') % 26 + 'a');
            jinwei = (inputFirstArray[indexFirst] + inputSecondArray[indexSecond] - 2 * 'a') / 26;
            indexFirst--;
            indexSecond--;
        }

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
        }
    }
}
