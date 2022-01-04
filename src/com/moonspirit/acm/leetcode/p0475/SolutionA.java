package com.moonspirit.acm.leetcode.p0475;

import java.util.Arrays;

/**
 * 二分+双指针。O(nlogn+mlogm+max(m,n)logL) O(logn+logm)
 * <p>
 * 二分查找确定最小加热半径（二段性）：
 * 小于最小加热半径，无法全部覆盖；
 * 大于等于最小加热半径，可以全部覆盖。
 * <p>
 * 双指针判断所给半径能否全部覆盖：
 * i指向当前房屋，j指向可能覆盖该房屋的最小下标光源。
 * 如果能够覆盖该房屋，继续遍历下一房屋，否则返回失败。
 * <p>
 * 时间复杂度：排序 O(nlogn+mlogm)，检查能否全部覆盖 O(max(m,n))，二分查找 O(logL)
 * 空间复杂度：排序 O(logn+logm)
 */
public class SolutionA {
    private boolean check(int[] houses, int[] heaters, int r) {
        for (int i = 0, j = 0; i < houses.length; i++) {
            // 可能覆盖该房屋的最小下标光源（房屋小于等于光源上界，但不一定大于等于光源下界）
            while (j < heaters.length && houses[i] > heaters[j] + r) {
                j++;
            }
            // 光源能否覆盖该房屋（房屋位于光源上下界范围内）
            if (j < heaters.length && heaters[j] - r <= houses[i] && houses[i] <= heaters[j] + r) {
                continue;
            }
            return false;
        }
        return true;
    }

    public int findRadius(int[] houses, int[] heaters) {
        if (houses == null || houses.length == 0 || heaters == null || heaters.length == 0) {
            throw new IllegalArgumentException("非法输入");
        }

        Arrays.sort(houses);
        Arrays.sort(heaters);
        int l = 0;
        int r = (int) 1e9;
        while (l < r) {
            int m = l + ((r - l) >> 1);
            if (check(houses, heaters, m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return r;
    }
}

    个人一般都写 left < right，因为 left <= right 时结束后会 left, right 相差 1 ，有时候不好判断结果是 left 还是 right（但不是说不能用 left <= right）

        left = mid + 1, right = mid 和 left = mid, right = mid - 1 两种写法取决于 mid = left + right >> 1 还是 mid = left + right + 1 >> 1，不难看出如果计算 mid 时向下取整再使用 left = mid 是会造成死循环的，向上取整再使用 right = mid 同理，所以一一对应

        其实二分查找的最简单的模板就两种，就是 cpp 中的 upper_bound() 和 lower_bound() 或者 python的 bisect.bisect_left() 和 bisect.bisect_right()