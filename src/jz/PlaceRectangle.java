package jz;

/**
 * Created by 11239 on 2018/7/28.
 *
 * 可以将小矩形横排或竖排
 * 用n个2*1的小矩形无重叠的覆盖一个2*n的大矩形，有多少中方案
 * 斐波拉契数列
 */
public class PlaceRectangle {
    public int RectCover(int target) {
        if(target==0)
            return 0;
        int []result={1,2};
        if(target<=2)
            return result[target-1];
        int first=1,second=2;
        int num=0;
        for(int i=3;i<=target;i++){
            num=first+second;
            first=second;
            second=num;
        }
        return num;
    }
}
