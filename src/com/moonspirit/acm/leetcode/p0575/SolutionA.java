package com.moonspirit.acm.leetcode.p0575;

import java.util.HashSet;
import java.util.Set;

/**
 * 贪心。O(n) O(n)
 * <p>
 * 假设糖果种类数m，总个数n，能够分到的最大糖果种类数Math.min(n/2,m)。
 * 当m>=n/2时，从m类糖果中选取n/2类糖果组成一份，每份糖果选取一颗，达到最大种类数n/2；
 * 当m<n/2时，先从每份糖果选取一颗组成一份，再使用重复糖果凑齐n/2，达到最大种类数m。
 */
class SolutionA {
    public int distributeCandies(int[] candyType) {
        if (candyType == null || candyType.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : candyType) {
            set.add(num);
        }
        return Math.min(candyType.length / 2, set.size());
    }
}
