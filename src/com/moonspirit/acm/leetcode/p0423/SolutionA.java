package com.moonspirit.acm.leetcode.p0423;

/**
 * z 0 - 0
 * w 2 - 2
 * u 4 - 4
 * x 6 - 6
 * g 8 - 8
 * h 3 8 - 3
 * f 4 5 - 5
 * v 5 7 - 7
 * o 0 1 2 4 - 1
 * i 5 6 8 9 - 9
 *
 *
 * <p>
 * 构建顺序：
 * - 0：zero，唯一元素z；
 * -
 */
public class SolutionA {
    class Solution {
        public String originalDigits(String s) {
            if (s == null || s.length() == 0) {
                throw new IllegalArgumentException("非法输入");
            }

            int[] nums = new int[26];
            int[] cnts = new int[10];
            for (char ch : s.toCharArray()) {
                nums[ch - 'a']++;
            }
            cnts[0] = nums['z' - 'a'];
            cnts[2] = nums['w' - 'a'];
            cnts[4] = nums['u' - 'a'];
            cnts[6] = nums['x' - 'a'];
            cnts[8] = nums['g' - 'a'];
            cnts[3] = nums['h' - 'a'] - cnts[8];
            cnts[5] = nums['f' - 'a'] - cnts[4];
            cnts[7] = nums['v' - 'a'] - cnts[5];
            cnts[1] = nums['o' - 'a'] - cnts[0] - cnts[2] - cnts[4];
            cnts[9] = nums['i' - 'a'] - cnts[5] - cnts[6] - cnts[8];
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                while (cnts[i]-- > 0) {
                    sb.append(i);
                }
            }
            return sb.toString();
        }
    }
}
