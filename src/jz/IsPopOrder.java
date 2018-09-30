package jz;

import java.util.Stack;

/**
 * Created by 11239 on 2018/8/19.
 *
 * 给定两个整数序列
 * 第一个序列表示栈压入顺序，判断第二个序列是否可能为该栈的弹出顺序
 *
 */
public class IsPopOrder {
    public boolean IsPopOrder(int[] pushA,int[] popA){
        if(null==pushA)
            return false;
        if(pushA.length!=popA.length)
            return false;
        Stack<Integer> push=new Stack<>();
        int i=0,j=0;
        push.push(pushA[i++]);
        while(j<popA.length){
            while(push.peek()!=popA[j]){
                if(i==pushA.length){
                    return false;
                }else{
                    push.push(pushA[i++]);
                }
            }
            j++;
            push.pop();
        }
        return true;
    }
}
