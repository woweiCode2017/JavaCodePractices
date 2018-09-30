package SortAlgorithms;

/**
 * Created by 11239 on 2018/8/6.
 * 插入排序
 * 在要排序的数组中，假设前n-1个数已经排好序
 * 将第n个数插入其中，使得这n个数也是排序好的
 * 时间复杂度O(n^2)
 *
 */
public class InsertSort {
    public static int[] insertSort(int [] arr){
        int temp;
        for(int i=0;i<arr.length-1;i++){    //注意arr.length时会越界，当循环嵌套时务必注意内外圈的互相限制
            for(int j=i+1;j>0;j--){
                if(arr[j]<arr[j-1]){
                    temp=arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                }else{
                    break;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] res=insertSort(new int[]{42,20,17,13,28,14,23,15});
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+",");
        }
    }

}
