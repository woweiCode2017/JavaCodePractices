package jz;

/**
 * Created by 11239 on 2018/7/29.
 * 输入一个整数数组
 * 将数组中的奇数放入数组前半部分，偶数放入后半部分
 * 要求保持奇数和奇数之间的相对位置不变
 */
public class ReOrderArray {
    public int[] reOrderArray(int[] array){
        if(array.length<2)
            return array;
        int[] result=new int[array.length];
        int oddNum=0;
        for (int i=0;i<array.length;i++){
            if((array[i]&1)==1){
                oddNum++;
            }
        }
        int oddPoint=0,evenPoint=oddNum;
        for(int i=0;i<array.length;i++){
            if((array[i]&1)==1){
                result[oddPoint++]=array[i];
            }else{
                result[evenPoint++]=array[i];
            }
        }
        return result;
    }

}
