package com.moonspirit.acm.leetcode.p0179;

import java.util.Arrays;

/**
 * 贪心。O(n^2) O(n)
 * <p>
 * 自定义排列顺序，不能使用基本类型，应该使用其对应的包装类型。
 */
由于是对 StringString 进行排序，当排序对象不是 JavaJava 中的基本数据类型时，不会使用快排（考虑排序稳定性问题）。Arrays.sort()的底层实现会「元素数量/元素是否大致有序」决定是使用插入排序还是归并排序。这里直接假定使用的是「插入排序」。复杂度为 O(n^2)O(n
        2
        )

        作者：AC_OIer
        链接：https://leetcode-cn.com/problems/largest-number/solution/gong-shui-san-xie-noxiang-xin-ke-xue-xi-vn86e/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

class SolutionA {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }

        int n = nums.length;
        Integer[] numsArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            numsArr[i] = nums[i];
        }
        Arrays.sort(nums);

        Arrays.sort(numsArr, (a, b) -> {
            String s1 = "" + a + b;
            String s2 = "" + b + a;
            return s2.compareTo(s1);
        });
        StringBuilder sb = new StringBuilder();
        for (int num : numsArr) {
            sb.append(num);
        }
        return sb.toString();
    }
}

class Solution {
    public String largestNumber(int[] nums) {
        Arrays.sort(numsArr, (x, y) -> {
            long sx = 10, sy = 10;
            while (sx <= x) {
                sx *= 10;
            }
            while (sy <= y) {
                sy *= 10;
            }
            return (int) (-sy * x - y + sx * y + x);
        });

        if (numsArr[0] == 0) {
            return "0";
        }
        StringBuilder ret = new StringBuilder();
        for (int num : numsArr) {
            ret.append(num);
        }
        return ret.toString();
    }
}
