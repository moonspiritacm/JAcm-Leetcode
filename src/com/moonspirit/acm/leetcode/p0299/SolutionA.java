package com.moonspirit.acm.leetcode.p0299;

/**
 * 模拟。O(n) O(C)
 * <p>
 * 如果相同位置的字符相同，Bulls++；
 * 如果相同位置的字符不同，使用哈希表/数组统计词频，Cows为各数字词频较小值总和。
 */
class SolutionA {
    public String getHint(String secret, String guess) {
        if (secret == null || secret.length() == 0 || guess == null || guess.length() == 0 || secret.length() != guess.length()) {
            throw new IllegalArgumentException("非法输入");
        }

        char[] chs = secret.toCharArray();
        char[] chg = guess.toCharArray();
        int[] nums = new int[10];
        int[] numg = new int[10];
        int a = 0;
        int b = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == chg[i]) {
                a++;
            } else {
                nums[chs[i] - '0']++;
                numg[chg[i] - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            b += Math.min(nums[i], numg[i]);
        }
        return a + "A" + b + "B";
    }
}
