package SortAlgorithms;

/**
 * Created by 11239 on 2018/8/9.
 * 归并排序
 *
 * 分治，将两个有序的数组合并
 *
 * 时间复杂度 O(nlogn)
 */
public class MergeSort {

    public static int[] mergeSort(int[] arr){
        divide(arr,0,arr.length-1);
        return arr;
    }

    private static void divide(int[] arr,int first,int last) {
        if(first<last){
            int middle=(first+last)/2;
            divide(arr,first,middle);
            divide(arr,middle+1,last);
            merge(arr,first,middle,last);
        }
    }

    private static void merge(int[] arr, int first, int middle, int last) {
        int i=first;
        int m=middle;
        int j=middle+1;
        int n=last;
        int k=0;
        int[] temp=new int[last-first+1];
        while(i<=m&&j<=last){
            if(arr[i]<=arr[j]){
                temp[k]=arr[i];
                i++;
                k++;
            }else{
                temp[k]=arr[j];
                j++;
                k++;
            }
        }
        while(i<=m){
            temp[k]=arr[i];
            i++;
            k++;
        }
        while(j<=last){
            temp[k]=arr[j];
            j++;
            k++;
        }
        for(int l=first;l<=last;l++){
            arr[l]=temp[l-first];
        }
    }

    public static void main(String[] args) {
        int[] res=mergeSort(new int[]{42,20,17,13,28,14,23,15});
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+",");
        }
    }
}
