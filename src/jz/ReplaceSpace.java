package jz;

/**
 * Created by 11239 on 2018/7/6.
 * 替换字符串中的空格
 */
public class ReplaceSpace {
    public static void main(String args){
        StringBuffer str=new StringBuffer(1024);
        System.out.print(replaceSpace(str));
    }

    private static String replaceSpace(StringBuffer str){
        char[] getStr=str.toString().toCharArray();
        StringBuffer giveStr=new StringBuffer();
        for(int i=0;i<getStr.length;i++){
            char c=getStr[i];
            if (' '==c){
                giveStr.append("%20");
            }else{
                giveStr.append(c);
            }
        }
        return giveStr.toString();
    }
}
