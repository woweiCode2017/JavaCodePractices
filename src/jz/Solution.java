package jz;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by 11239 on 2018/7/8.
 * 从尾到头打印单链表
 */
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        List<Integer> result=new ArrayList<Integer>();
        Stack<ListNode> stack=new Stack<ListNode>();
        while (listNode!=null){
            stack.push(listNode);
            listNode=listNode.next;
        }
        while(!stack.empty()){
            result.add(stack.pop().val);
        }
        return (ArrayList)result;
    }

    class ListNode{
        int val;
        ListNode next=null;
        ListNode(int val){
            this.val=val;
        }
    }
}
