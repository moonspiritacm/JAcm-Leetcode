package com.moonspirit.acm.leetcode.p0306;

public String stringAdd(String s, int firstStart, int firstEnd, int secondStart, int secondEnd) {
        StringBuffer third = new StringBuffer();
        int carry = 0, cur = 0;
        while (firstEnd >= firstStart || secondEnd >= secondStart || carry != 0) {
        cur = carry;
        if (firstEnd >= firstStart) {
        cur += s.charAt(firstEnd) - '0';
        --firstEnd;
        }
        if (secondEnd >= secondStart) {
        cur += s.charAt(secondEnd) - '0';
        --secondEnd;
        }
        carry = cur / 10;
        cur %= 10;
        third.append((char) (cur + '0'));
        }
        third.reverse();
        return third.toString();
        }

        作者：LeetCode-Solution
        链接：https://leetcode-cn.com/problems/additive-number/solution/lei-jia-shu-by-leetcode-solution-cadc/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
