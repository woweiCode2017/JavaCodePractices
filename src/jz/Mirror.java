package jz;

/**
 * Created by 11239 on 2018/8/6.
 * 操作给定的二叉树
 * 将其变换为原来的二叉树的镜像
 */
public class Mirror {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val=val;
        }
    }

    public void Mirror(TreeNode root){
        if(root==null)
            return;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        Mirror(root.left);
        Mirror(root.right);
    }

}
