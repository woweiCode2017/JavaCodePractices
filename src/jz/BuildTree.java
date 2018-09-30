package jz;

/**
 * Created by 11239 on 2018/7/12.
 *
 * 通过前序遍历和中序遍历重构二叉树
 */
public class BuildTree {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val=x;
        }
    }
    public static void main(String[] args){
        int[] pre={1,2,3,4,5,6,7};
        int[] in={3,2,4,1,6,5,7};
        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        System.out.print(root);
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        /*判断条件如何获得？*/
        if (startPre>endPre||startIn>endIn){
            return null;
        }
        TreeNode root=new TreeNode(pre[startPre]);
        for (int i=startIn;i<=endIn;i++){
            if (in[i]==pre[startPre]){
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=reConstructBinaryTree(pre,startPre+i-startIn+1,endPre,in,i+1,endIn);
                break;
            }
        }
       return root;
    }
}
