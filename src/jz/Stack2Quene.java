package jz;

import java.util.Stack;

/**
 * Created by 11239 on 2018/7/24.
 *
 * 利用两个stack构建一个Quene
 */
public class Stack2Quene {

    private Stack<Integer> stackIn=new Stack<Integer>();
    private Stack<Integer> stackOut=new Stack<Integer>();

    public Integer pop(){
        if(stackOut.isEmpty()){
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        if (stackOut.isEmpty())
            return null;
        return stackOut.pop();
    }

    public Integer push(Integer in){
        stackIn.push(in);
        return in;
    }

}
