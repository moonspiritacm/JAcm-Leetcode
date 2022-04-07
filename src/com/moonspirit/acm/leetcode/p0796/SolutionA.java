package com.moonspirit.acm.leetcode.p0796;

/**
 * 搜索子串。O(n) O(n)
 * <p>
 * s+s包含了所有s通过旋转得到的字符串，只需要检查goal是否为s+s的子串即可。
 * KMP算法的复杂度：O(n) O(n)。
 */
class SolutionA {
    public boolean rotateString(String s, String goal) {
        if (s == null || goal == null) {
            throw new IllegalArgumentException("非法输入");
        }

        return s.length() == goal.length() && (s + s).contains(goal);
    }
}
