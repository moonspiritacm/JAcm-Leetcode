package com.moonspirit.acm.leetcode.p1185;

/**
 * 模拟。O(1) O(1)
 */
class Solution {
    public static int[] DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static String[] STRS = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    public String dayOfTheWeek(int day, int month, int year) {
        if (day <= 0 || day > 31 || month <= 0 || month > 12 || year < 1971 || year > 2100) {
            throw new IllegalArgumentException("非法输入");
        }

        // 年份[1971, year - 1]天数，特殊处理闰年
        int sum = 4 + (year - 1971) * 365 % 7;  // 1970-12-31
        for (int i = 1971; i < year; i++) {
            if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                sum++;
            }
        }

        // 月份[1, month - 1]天数，特殊处理闰年二月
        for (int i = 1; i < month; i++) {
            sum += DAYS[i - 1];
        }
        if (month > 2 && (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)) {
            sum++;
        }

        // 天数
        sum += day;
        return STRS[sum % 7];
    }
}
