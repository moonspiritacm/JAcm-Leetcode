package com.moonspirit.acm.leetcode.p0020;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 栈。O(n) O(n+c)
 */
class SolutionA {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
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
            if (stk.isEmpty() || !dict.containsKey(ch) || dict.get(ch) != stk.peek()) {
                stk.push(ch);
            } else {
                stk.pop();
            }
        }
        return stk.isEmpty();
    }
}
