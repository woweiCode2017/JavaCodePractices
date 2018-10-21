package jz;

/**
 * Created by ChenZhipeng on 2018/10/21.
 *
 * 在一个字符串中，全部由字母组成, 区分大小写
 * 找到第一个只出现一次的字符，并返回它的位置
 * 如果没有则返回-1
 *
 * A-Z 65-90
 * a-z 97-122
 * 0-9 48-57
 *
 */
public class FirstNotRepeat {
    public int FirstNotRepeatingChar(String str){
        int result=-1;
        char[] strArray=str.toCharArray();
        int[] cs=new int['z'];
        for(char c:strArray){
            cs[(int)c-1]++;
        }
        for(int i=0;i<strArray.length;i++){
            if(cs[(int)strArray[i]-1]==1){
                result=i;
                break;
            }
        }
        return result;
    }
}
