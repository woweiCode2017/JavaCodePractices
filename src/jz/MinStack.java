package jz;

import java.util.Stack;

/**
 * Created by 11239 on 2018/8/19.
 * 定义栈的数据结构
 * 实现一个能够得到栈中包含的最小元素的min函数
 * 时间复杂度为O(1)
 */
public class MinStack {

    private Stack<Integer> minStack = new Stack<>();
    private Stack<Integer> stack = new Stack<>();
    private int min = Integer.MAX_VALUE;

    public void push(int node) {
        stack.push(node);
        if (node < min) {
            min = node;
        }
        minStack.push(min);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
        min = minStack.peek();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        System.out.print(min);
        return min;
    }

    public static void main(String[] args) {
        MinStack test = new MinStack();
        test.push(3);
        test.min();
        test.push(4);
        test.min();
        test.push(2);
        test.min();
        test.push(3);
        test.min();
        test.pop();
        test.min();
        test.pop();
        test.min();
        test.pop();
        test.min();
        test.push(0);
        test.min();
    }

}
