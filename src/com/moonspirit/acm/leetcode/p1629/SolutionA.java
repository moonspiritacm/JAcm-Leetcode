package com.moonspirit.acm.leetcode.p1629;

/**
 * 模拟。O(n) O(1)
 */
class SolutionA {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        if (releaseTimes == null || releaseTimes.length == 0 || keysPressed == null || keysPressed.length() == 0 || releaseTimes.length != keysPressed.length()) {
            throw new IllegalArgumentException("非法输入");
        }

        int n = releaseTimes.length;
        int max = releaseTimes[0];
        char res = keysPressed.charAt(0);
        for (int i = 1; i < n; i++) {
            if (releaseTimes[i] - releaseTimes[i - 1] > max || releaseTimes[i] - releaseTimes[i - 1] == max && keysPressed.charAt(i) > res) {
                max = releaseTimes[i] - releaseTimes[i - 1];
                res = keysPressed.charAt(i);
            }
        }
        return res;
    }
}
