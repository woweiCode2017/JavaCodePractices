package jz;

/**
 * Created by 11239 on 2018/7/29.
 * 给定一个单向链表
 * 输出倒数第K个节点
 */
public class FindKthToTail {
    class ListNode{
        int val;
        ListNode next=null;

        ListNode(int val){
            this.val=val;
        }
    }

    public ListNode FindKthToTail(ListNode head,int k){
        if(head==null||k==0)
            return null;
        ListNode firstPoint=head,secondPoint=head;
        for(--k;k>0;k--){
            if(firstPoint.next!=null){
                firstPoint=firstPoint.next;
            }else{
                return null;
            }
        }
        while(firstPoint.next!=null){
            firstPoint=firstPoint.next;
            secondPoint=secondPoint.next;
        }
        return secondPoint;
    }
}
