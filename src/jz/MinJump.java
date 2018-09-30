package jz;

/**
 * Created by 11239 on 2018/7/20.
 * 给定一个数组，位于第一个位置，数组中每个位置的元素值标识最多能跳几步
 * 问最少几次能调到最后一个位置
 * input: [2,3,1,1,4] output:2
 * process: 2,2-3-4
 */
public class MinJump {

    public static void main(String[] args) {
        System.out.print(jump(new int[]{2,3,1,1,4}));
    }

    private static int jump(int[] A){
     int target=A.length-1;
     int count=0;
     while(target>0){
         for(int i=0;i<A.length;i++){
             if(i+A[i]>=target){
                 target=i;
                 count++;
                 break;
             }
         }
     }
     return count;
    }

}
