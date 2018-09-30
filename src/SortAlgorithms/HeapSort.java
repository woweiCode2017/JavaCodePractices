package SortAlgorithms;

/**
 * Created by 11239 on 2018/8/10.
 * 堆排序
 *堆中某个节点的值总是不大于或不小于其父节点的值
 *
 * 构建大根堆，每次插入数据时做出调整，共n/2次操作，每次时间O(logN)
 * 删除根时，恢复堆时间复杂度O(logN),共N-1次操作
 *
 * 时间复杂度O(NlogN)
 *
 */
public class HeapSort {

    public static int[] heapSort(int [] arr){
        int temp=0;
        MakeMinHeap(arr,arr.length);

        for(int i=arr.length-1;i>0;i--){
            temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            MinHeapFixdown(arr,0,i);
        }
        return arr;
    }

    private static void MinHeapFixdown(int[] arr, int i, int n) {
        int j=2*i+1;
        int temp=0;
        while(j<n){
            if(j+1<n&&arr[j+1]<arr[j]){
                j++;
            }
            if(arr[i]<=arr[j]){
                break;
            }
            temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i=j;
            j=2*i+1;
        }
    }

    private static void MakeMinHeap(int[] arr, int n) {
        for(int i=(n-1)/2;i>=0;i--){
            MinHeapFixdown(arr,i,n);
        }
    }

    public static void main(String[] args) {
        int[] res=heapSort(new int[]{42,20,17,13,28,14,23,15});
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+",");
        }
    }
}
