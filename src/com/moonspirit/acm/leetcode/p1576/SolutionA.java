package com.moonspirit.acm.leetcode.p1576;

/**
 * 字符串模拟。O(n) O(1)
 * <p>
 * 保证替换字符与前后字符（若存在）不同，最多在3个字符内找到替换值，并不需要遍历所有字母，不妨使用a、b、c。
 */
class SolutionA {
    public String modifyString(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException("非法输入");
        }

        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '?') {
                char c1 = i == 0 ? '0' : chs[i - 1];
                char c2 = i == chs.length - 1 ? '0' : chs[i + 1];
                for (char ch = 'a'; ch <= 'c'; ch++) {
                    if (ch != c1 && ch != c2) {
                        chs[i] = ch;
                        break;
                    }
                }
            }
        }
        return new String(chs);
    }
}
