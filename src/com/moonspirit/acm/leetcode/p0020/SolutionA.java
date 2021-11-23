package com.moonspirit.acm.leetcode.p0020;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 哈希表+栈。O(n) O(n+|c|)
 * <p>
 * 对于左括号：压入栈顶；
 * 对于右括号：如果栈空或匹配失败，返回失败；否则，匹配成功，弹出栈顶。
 */
class SolutionA {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException("非法输入");
        }
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stk = new Stack<>();
        Map<Character, Character> dict = new HashMap<>();
        dict.put(')', '(');
        dict.put(']', '[');
        dict.put('}', '{');
        for (char ch : s.toCharArray()) {
            if (dict.containsKey(ch)) { // 右括号
                if (stk.isEmpty() || dict.get(ch) != stk.peek()) {
                    return false;
                } else {
                    stk.push(ch);
                }
            } else { // 左括号
                stk.pop();
            }
        }
        return stk.isEmpty();
    }
}
