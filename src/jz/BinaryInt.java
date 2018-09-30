package jz;

/**
 * Created by 11239 on 2018/7/28.
 * 输入一个整数，输出该数二进制表示中1的个数
 * 负数用 补码表示
 * 0b 二进制
 * 0  八进制
 * 0x  十六进制
 * 无前缀  十进制
 * & 与运算   | 或运算    ^ 异或运算   ~取反   <<左移   >>带符号右移    >>>无符号右移
 * 异或运算：两位二进制数，某位上的两个数不同时返回1，相同时返回0
 *
 * 原码：真值转换为相应的二进制形式
 * 反码：正数反码同原码，负数反码是原码除符号位取反
 * 补码：正数补码同原码，负数补码为反码末位加1
 * 补码求真值：正数直接求，负数除符号位按位取反，末位加1
 *
 * int 转 byte 型取低8位
 */

public class BinaryInt {
    public int NumberOf1(int n){
        int count=0;
        while(n!=0){
            n=(n-1)&n;
            count++;
        }
     return count;
    }
}
