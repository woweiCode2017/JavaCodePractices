package jz;

import java.util.Vector;

/**
 * Created by 11239 on 2018/7/24.
 *
 * 查找旋转数组中的最小值
 * [0,1,1,1,1]
 * [1,1,1,0,1]   [1,0,1,1,1]
 */
public class MinInReverseArray {

    public Integer minNumInRotateArray(Vector<Integer> rotateArray){
        if(rotateArray.size()==0)
            return 0;
        int size=rotateArray.size();
        int left=0,right=size;
        int mid=0;
        while(rotateArray.get(left)>=rotateArray.get(right)){
            if(right-left==1){
                mid=right;
                break;
            }
            mid=left+(right-left)/2;
            if(rotateArray.get(left)==rotateArray.get(mid)&&rotateArray.get(mid)==rotateArray.get(right)){
                left++;
                right--;
            }else {
                if (rotateArray.get(mid) >= rotateArray.get(left)) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        return rotateArray.get(mid);
    }

}
