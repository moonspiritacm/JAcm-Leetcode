package com.moonspirit.acm.leetcode.p0504;

/**
 * 模拟。O(log|n|) O(log|n|)
 * <p>
 * 对于数字0，输出“0”，而不是“”，使用do……while循环，保证至少输出一个数字。
 * 如果题目不做限制，必须考虑负数变正数的溢出问题。
 */
class SolutionA {
    public String convertToBase7(int num) {
        boolean sign = true;
        if (num < 0) {
            sign = false;
            num = -num;
        }

        StringBuilder sb = new StringBuilder();
        do {
            sb.append(num % 7);
            num /= 7;
        } while (num != 0);

        if (!sign) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }
}
