package jz;

/**
 * Created by 11239 on 2018/9/6.
 *
 * 判断是否是二叉树的后序遍历结果
 *
 */
public class TreeBST {
    public static void main(String[] args) {
        System.out.println(VerifySquenceOfBST());
    }

    public static boolean VerifySquenceOfBST() {
        int[] sequence=new int[] {4,8,6,12,16,14,10};
        if(null==sequence||sequence.length==0)
            return false;
        return isTreeBST(sequence,0,sequence.length-1);
    }

    private static boolean isTreeBST(int[] sequence, int start, int end) {
        if(start>=end)
            return true;
        int i=start;
        for(;i<end;i++){
            if(sequence[i]>sequence[end])
                break;
        }
        for(int j=i;j<end;j++){
            if(sequence[j]<sequence[end])
                return false;
        }
        return isTreeBST(sequence,start,i-1)&&isTreeBST(sequence,i,end-1);
    }
}
