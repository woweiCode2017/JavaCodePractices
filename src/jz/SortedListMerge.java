package jz;

/**
 * Created by 11239 on 2018/8/1.
 * 输入两个单调递增的链表
 * 输出两个链表合成后的链表
 * 需要合成后的链表满足单调不减规则
 *
 */
public class SortedListMerge {
    class ListNode{
        int val;
        ListNode next=null;
        ListNode(int val){
            this.val=val;
        }
    }

    public ListNode Merge(ListNode list1,ListNode list2){
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        ListNode mergeNode=null,currentNode=null;
        if(list1.val<=list2.val){
            mergeNode=currentNode=list1;
            list1=list1.next;
        }else{
            mergeNode=currentNode=list2;
            list2=list2.next;
        }
        while(list1!=null||list2!=null){
            if(list1==null){
                currentNode.next=list2;
                list2=list2.next;
                currentNode=currentNode.next;
            }else if(list2==null){
                currentNode.next=list1;
                list1=list1.next;
                currentNode=currentNode.next;
            }else{
                if(list1.val<=list2.val){
                    currentNode.next=list1;
                    list1=list1.next;
                    currentNode=currentNode.next;
                }else{
                    currentNode.next=list2;
                    list2=list2.next;
                    currentNode=currentNode.next;
                }
            }
        }
        return mergeNode;
    }

}
