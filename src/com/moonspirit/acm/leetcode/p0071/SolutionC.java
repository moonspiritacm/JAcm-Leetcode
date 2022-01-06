package com.moonspirit.acm.leetcode.p0071;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 双端队列。O(n) O(n)
 */
class SolutionC {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            throw new IllegalArgumentException("非法输入");
        }

        int i = 0;
        int n = path.length();
        StringBuilder sb = new StringBuilder();
        Deque<String> deque = new LinkedList<>();
        while (i < n) {
            int j = i;
            while (j < n && path.charAt(j) != '/') {
                j++;
            }

            String str = path.substring(i, j);
            if ("..".equals(str)) {  // 弹出栈顶元素
                if (!deque.isEmpty()) {
                    deque.pollLast();
                }
            } else if (".".equals(str)) {  // 不做处理
            } else if (str.length() > 0) {  // 压入栈中
                deque.offerLast(str);
            }
            i = j + 1;
        }

        sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append('/');
            sb.append(deque.pollFirst());
        }
        if (sb.length() == 0) {
            sb.append('/');
        }
        return sb.toString();
    }
}
