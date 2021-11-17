package com.moonspirit.acm.leetcode.p0168;

/**
 * 进制转换。O(logn) O(1)
 * <p>
 * 从0开始的N进制，每一位数值范围为[0, N)，逢N进一；
 * 从1开始的N进制，每一位数值范围为[1, N]，每位转换前需执行减一操作，实现整体偏移。
 */
class SolutionA {
    public String convertToTitle(int columnNumber) {
        if (columnNumber <= 0) {
            throw new IllegalArgumentException("非法输入");
        }

        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            sb.append((char) ('A' + columnNumber % 26));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}
