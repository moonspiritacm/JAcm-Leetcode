package com.moonspirit.acm.leetcode.p1447;

import java.util.ArrayList;
import java.util.List;

class SolutionA {
    public List<String> simplifiedFractions(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("非法输入");
        }

        List<String> res = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (gcd2(i, j) == 1) {
                    res.add(j + "/" + i);
                }
            }
        }
        return res;
    }

    /**
     * 辗转相除法，又名欧几里得算法，用于求解任意两个正整数的最大公因数。该方法无需进行素因数分解，易于编程实现，O(log(a+b))。
     * 引理：若a=bq+c（a、b、c、q均为正整数），则（a,b）=（b,c）。
     * ①对于正整数a、b，不妨假设a>=b，a除b余c，根据引理可知（a,b）=（b,c）；
     * ②令a=b、b=c，重复以上过程，直到余数为0，该除数就是两数的最大公约数。
     *
     * @param a 较大数（被除数）
     * @param b 较小数（除数）
     * @return 最大公约数
     */
    private int gcd1(int a, int b) {
        return b == 0 ? a : gcd1(b, a % b);
    }

    /**
     * 更相减损术，O(max(a,b))。
     * 每次用较大数减较小数，将差值与减数比较，重复以上过程，直到差值与减数相等，该减数就是两数的最大公约数。
     *
     * @param a 正整数
     * @param b 正整数
     * @return 最大公约数
     */
    private int gcd2(int a, int b) {
        while (true) {
            if (a > b) {
                a -= b;
            } else if (a < b) {
                b -= a;
            } else {
                return a;
            }
        }
    }
}
