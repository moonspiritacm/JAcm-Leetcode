package com.moonspirit.acm.leetcode.p0796;

/**
 * 搜索子串。O(n) O(n)
 * <p>
 * s+s包含了所有s通过旋转得到的字符串，只需要检查goal是否为s+s的子串即可。
 * <p>
 * KMP算法时间复杂度 O(n+k)，普通子串匹配算法时间复杂度 O(nk)，其中n和k分别为原串和子串的长度。
 * Java中的 `str.contains()` 实际调用的是 `indexOf()`，纸面时间复杂度 O(nk)，JVM对其存在优化，导致时间复杂度优于 O(nk)。
 */
class SolutionA {
    public boolean rotateString(String s, String goal) {
        if (s == null || goal == null) {
            throw new IllegalArgumentException("非法输入");
        }

        return s.length() == goal.length() && (s + s).contains(goal);
    }
}
