package SortAlgorithms;

/**
 * Created by 11239 on 2018/8/6.
 * 冒泡排序
 * 两个数比较大小，较大的数下沉，较小的数冒起来
 * 两两比较交换位置，一轮过后最大的数被放置在最后的位置
 * 时间复杂度 O(n^2)
 *
 */
public class BubbleSort {
    public static int[] BubbleSort(int [] arr){
        int temp;
        for (int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-1-i;j++){    //注意数组越界的情况arr.length-i
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] res=BubbleSort(new int[]{42,20,17,13,28,14,23,15});
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+",");
        }
    }
}
