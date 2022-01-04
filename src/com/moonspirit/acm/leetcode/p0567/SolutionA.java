package com.moonspirit.acm.leetcode.p0567;

/**
 * 滑动窗口。
 *
 * 算法逻辑：
 * 1.初始化。将滑动窗口压满，取得目标值；
 * 2.滑动窗口。每往前滑动一次，更新目标值（删除和添加一个元素）。
 *
 * 时间复杂度：
 * 1.统计目标字符串词频
 */
class SolutionA {
    private boolean check(int[] s1, int[] s2) {
        for (int i = 0; i < 26; i++) {
            if (s1[i] != s2[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
            throw new IllegalArgumentException("非法输入");
        }
        if (s1.length() > s2.length()) {
            return false;
        }

        int n1 = s1.length();
        int n2 = s2.length();
        int[] dict = new int[26];
        int[] wins = new int[26];
        for (char ch : s1.toCharArray()) {
            dict[ch - 'a']++;
        }
        for (int i = 0; i < n1; i++) {
            wins[s2.charAt(i) - 'a']++;
        }
        if (check(dict, wins)) {
            return true;
        }
        for (int i = n1; i < n2; i++) {
            wins[s2.charAt(i - n1) - 'a']--;
            wins[s2.charAt(i) - 'a']++;
            if (check(dict, wins)) {
                return true;
            }
        }
        return false;
    }
}
