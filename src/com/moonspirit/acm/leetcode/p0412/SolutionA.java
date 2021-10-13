package com.moonspirit.acm.leetcode.p0412;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟。O(n) O(1)
 */
class SolutionA {
    public List<String> fizzBuzz(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            if (i % 3 == 0) {
                sb.append("Fizz");
            }
            if (i % 5 == 0) {
                sb.append("Buzz");
            }
            if (sb.length() == 0) {
                res.add(String.valueOf(i));
            } else {
                res.add(sb.toString());
            }
        }
        return res;
    }
}
