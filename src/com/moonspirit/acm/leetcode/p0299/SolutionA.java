package com.moonspirit.acm.leetcode.p0299;

/**
 * 模拟。O(n) O(C)
 * <p>
 * 对于字符相同的位置，自增Bulls；
 * 对于字符不同的位置，使用哈希表（数组）统计词频，各数字词频最小值之和，即为Cows。
 */
class SolutionA {
    public String getHint(String secret, String guess) {
        if (secret == null || secret.length() == 0 || guess == null || guess.length() == 0 || secret.length() != guess.length()) {
            return "0A0B";
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
