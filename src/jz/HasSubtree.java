package jz;

/**
 * Created by 11239 on 2018/8/3.
 * 输入两个二叉树 A,B
 * 判断B是不是A的子结构
 * 约定空树不是任意一个树的子结构
 *
 * 注意：二叉树相关的操作有大量的指针操作，在每次使用指针的时候
 * 判断是否为空指针，如果是应该怎么处理
 */
public class HasSubtree {
    class TreeNode{
        int val=0;
        TreeNode left=null;
        TreeNode right=null;

        public TreeNode(int val){
            this.val=val;
        }
    }

    public boolean HasSubTree(TreeNode root1,TreeNode root2){
        if(root2==null)
            return false;
        if(root1==null)
            return false;
        boolean flag=false;
        if(root1.val==root2.val)
            flag=isSubTree(root1,root2);
        if(!flag){
            flag=HasSubTree(root1.left,root2);
            if(!flag){
                flag=HasSubTree(root1.right,root2);
            }
        }
        return flag;
    }

    private boolean isSubTree(TreeNode root1, TreeNode root2) {
        if(root2==null)
            return true;
        if(root1==null)
            return false;
        if(root1.val==root2.val){
            return isSubTree(root1.left,root2.left)&&isSubTree(root1.right,root2.right);
        }else{
            return false;
        }
    }

}
