package SortAlgorithms;

/**
 * Created by 11239 on 2018/8/6.
 * 快速排序
 * 分治思想，数列中取一个数，将比此数小的放左边，大的放右边
 * 重复步骤，直到各个区间只有一个数
 * 挖坑填数
 * a[0]挖坑；从后往前，找一个比key小的数填a[0]
 * 从前往后，找大于key的数填在后面的坑中
 * i==j时结束
 *
 * 时间复杂度 O(NlogN)  ???
 *
 */
public class QuickSort {
    public static int[] quickSort(int[] arr,int l,int r){
        if (l>=r)
            return arr;
        int i=l,j=r;
        int key=arr[i];
        while(i<j){
            while(i<j&&arr[j]>=key)
                j--;
            if(i<j){
                arr[i]=arr[j];
                i++;
            }
            while(i<j&&arr[i]<=key)
                i++;
            if(i<j){
                arr[j]=arr[i];
                j--;
            }
            arr[i]=key;
            quickSort(arr,l,i-1);
            quickSort(arr,i+1,r);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] res=quickSort(new int[]{42,20,17,13,28,14,23,15},0,7);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+",");
        }
    }
}
