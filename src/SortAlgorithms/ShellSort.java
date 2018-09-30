package SortAlgorithms;

/**
 * Created by 11239 on 2018/8/6.
 * 希尔排序
 * 对要排序的一组数字，按某一增量分为若干子序列，对子序列插入排序
 * 缩小增量，重复上述过程，直至增量为1
 * 如果数列基本有序，插入排序效率很高
 *
 * 时间复杂度 O(n^(3/2))
 *
 */
public class ShellSort {
    public static int[] shellSort(int[] arr){
        int incre=arr.length,temp=0;
        while(true){
            incre=incre/2;
            for(int i=0;i<incre;i++){
                for(int j=i+incre;j<arr.length;j+=incre){
                    for(int k=j;k>i;k-=incre){
                        if(arr[k]<arr[k-incre]){
                            temp=arr[k];
                            arr[k]=arr[k-incre];
                            arr[k-incre]=temp;
                        }
                        //else{break;}            官方解法为什么要加这一行？
                    }
                }
            }
            if(incre==1)
                break;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] res=shellSort(new int[]{42,20,17,13,28,14,23,15});
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+",");
        }
    }
}
