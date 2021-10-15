package com.moonspirit.acm.leetcode.p0136;

/**
 * 异或运算。O(n) O(1)
 *
 * 1.任意整数和它本身做异或运算的结果都等于0：x⊕x=0；
 * 2.任意整数和0做异或运算的结果都等于它本身：x⊕0=x；

 * 异或运算满足交换律和结合律，即 a \oplus b \oplus a=b \oplus a \oplus a=b \oplus (a \oplus a)=b \oplus0=ba⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。
 *
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/single-number/solution/zhi-chu-xian-yi-ci-de-shu-zi-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * 交换律：x \oplus y = y \oplus xx⊕y=y⊕x；
 *         结合律：(x \oplus y) \oplus z = x \oplus (y \oplus z)(x⊕y)⊕z=x⊕(y⊕z)；
 *         自反性：x \oplus y \oplus y = xx⊕y⊕y=x；
 *         任意整数和它本身做异或运算的结果都等于 0：x \oplus x = 0；
 *         ：x \oplus 0 = x；
 */


class SolutionA {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        for (int i = 1; i < nums.length; i++) {
            nums[0] ^= nums[i];
        }
        return nums[0];
    }
}
