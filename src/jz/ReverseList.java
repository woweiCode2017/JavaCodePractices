package jz;

/**
 * Created by 11239 on 2018/7/30.
 * 输入一个链表
 * 反转链表，输出新链表的头
 */
public class ReverseList {
    class ListNode{
        int val;
        ListNode next=null;
        ListNode(int val){
            this.val=val;
        }
    }

    public ListNode ReverseList(ListNode head){
        if(head==null||head.next==null)
            return head;
        ListNode current=head;
        ListNode next=head.next;
        ListNode tmp=null;
        current.next=null;
        while(next!=null){
            tmp=next.next;
            next.next=current;
            current=next;
            next=tmp;
        }
        return current;
    }
}
