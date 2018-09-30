package SortAlgorithms;

/**
 * Created by 11239 on 2018/8/10.
 * 基数排序
 *
 * 创建数组A[MaxValue],将每个数放到相应的位置上，遍历数组即为排序后的结果
 * 空间开销太大
 *
 * 通过基数来限制空间，设置基数为10，通过多轮排序
 *
 * 时间复杂度 O(d(n+r))
 *
 */
public class RadixSort {
    public static int[] radixSort(int [] arr){
        int n=arr.length;
        int[] temp=new int[n];
        int k=2;    //最大的位数
        int r=10;   //基数
        int [] cnt=new int[10];

        for (int i=0,rtok=1;i<k;i++,rtok*=r) {
            for (int j = 0; j < cnt.length; j++)
                cnt[j] = 0;
            for (int j = 0; j < arr.length; j++)
                cnt[(arr[j] / rtok) % r]++;
            for (int j = 1; j < cnt.length; j++)
                cnt[j] = cnt[j - 1] + cnt[j];
            //for (int j = 0; j < arr.length; j++) {    不可从小到大，会造成倒序排列
            for(int j=n-1;j>=0;j--){
                cnt[(arr[j] / rtok) % r]--;
                temp[cnt[(arr[j] / rtok) % r]] = arr[j];
            }
            for (int j = 0; j < n; j++)
                arr[j] = temp[j];
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] res=radixSort(new int[]{42,20,17,13,28,14,23,15});
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+",");
        }
    }

}
