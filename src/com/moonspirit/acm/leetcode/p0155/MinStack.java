package com.moonspirit.acm.leetcode.p0155;

import java.util.Stack;

/**
 * 双栈。O(1) O(n)
 * <p>
 * 数据栈：按照正常顺序存储元素；辅助栈：存储与每个元素对应的最小值。
 * 入栈时，计算辅助栈栈顶值与入栈元素的最小值，将其压入辅助栈。
 */
class MinStack {
    Stack<Integer> data;
    Stack<Integer> help;

    public MinStack() {
        data = new Stack<>();
        help = new Stack<>();
    }

    public void push(int val) {
        data.push(val);
        if (help.isEmpty() || help.peek() > val) {
            help.push(val);
        } else {
            help.push(help.peek());
        }
    }

    public void pop() {
        data.pop();
        help.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return help.peek();
    }
}
