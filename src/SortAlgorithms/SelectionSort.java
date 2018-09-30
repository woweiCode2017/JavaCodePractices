package SortAlgorithms;

/**
 * Created by 11239 on 2018/8/6.
 * 选择排序
 * 用第一个元素依次与剩余的n-1个元素比较替换
 * 最终第一个元素为最小的元素
 * 时间复杂度O(n^2)
 *
 */
public class SelectionSort {
    public static int[] selectionSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int minIndex=i;
            for(int j=i;j<arr.length;j++){
                if(arr[j]<arr[minIndex])
                    minIndex=j;
            }
            if(minIndex!=i){
                int temp=arr[i];
                arr[i]=arr[minIndex];
                arr[minIndex]=temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] res=selectionSort(new int[]{42,20,17,13,28,14,23,15});
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+",");
        }
    }
}
