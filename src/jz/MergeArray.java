package jz;

import java.net.SocketPermission;

/**
 * Created by 11239 on 2018/7/20.
 */
public class MergeArray {

    public static void main(String[] args) {
       //System.out.print(merge(new int[] {78,79,85,90},new int []{83,85,87,98}));
        int [] result=merge(new int[] {78,79,85,90},new int []{83,85,87,98});
        for (int i=0;i<result.length;i++){
            System.out.print(result[i]+",");
        }
    }

    public static int[] merge(int []A ,int [] B){
        int[] C=new int[A.length+B.length];
        int i=0,j=0,k=0;
        for(;k<C.length;k++){
            if(i>=A.length){
                C[k]=B[j++];
            }else if(j>B.length){
                C[k]=A[i++];
            }else if(A[i]<=B[j]){
                C[k]=A[i++];
            }else{
                C[k]=B[j++];
            }
        }
        return C;
    }
}
