package jz;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by 11239 on 2018/9/6.
 *
 * 从上往下打印出二叉树的每个节点
 * 同层节点从左至右打印
 *
 * 二叉树的广度优先搜索,无法使用递归实现
 *
 */
public class PrintTree {

    static class TreeNode{
        int val=0;
        TreeNode left=null;
        TreeNode right=null;

        public TreeNode(int val){
            this.val=val;
        }
    }

    /*
    public static void main(String[] args) {
        TreeNode root=new TreeNode(0);
        if(null==root)
            System.out.println(false);;
        List<Integer> res=new ArrayList<>();
        res.add(root.val);
        getList(res,root);
        Iterator<Integer> iterator=res.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    private static void getList(List<Integer> res, TreeNode root) {
            if(null!=root.left)
                res.add(root.left.val);
            if(null!=root.right)
                res.add(root.right.val);
            getList(res,root.left);
            getList(res,root.right);
    }
    */

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<>();
        if(null==root)
            return list;
        Deque<TreeNode> quene=new LinkedList<TreeNode>();
        quene.add(root);
        while(!quene.isEmpty()){
            TreeNode t=quene.pop();
            list.add(t.val);
            if(t.left!=null)quene.add(t.left);
            if(t.right!=null)quene.add(t.right);
        }
        return list;
    }
}
