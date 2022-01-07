package com.moonspirit.acm.leetcode.p0071;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 双端队列。O(n) O(n)
 */
class SolutionA {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            throw new IllegalArgumentException("非法输入");
        }

        int n = path.length();
        StringBuilder sb = new StringBuilder();
        Deque<String> deque = new LinkedList<>();
        for (int i = 0; i <= n; i++) {
            if (i == n || path.charAt(i) == '/') {
                String name = sb.toString();
                sb = new StringBuilder();
                if ("..".equals(name)) {  // 弹出栈顶元素
                    if (!deque.isEmpty()) {
                        deque.pollLast();
                    }
                } else if (".".equals(name)) {  // 不做处理
                } else if (name.length() > 0) {  // 压入栈中
                    deque.offerLast(name);
                }
            } else {
                sb.append(path.charAt(i));
            }
        }

        sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append("/");
            sb.append(deque.pollFirst());
        }
        if (sb.length() == 0) {
            sb.append("/");
        }
        return sb.toString();
    }
}
