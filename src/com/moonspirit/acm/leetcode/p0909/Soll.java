package com.moonspirit.acm.leetcode.p0909;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class Solution {
    int bfs() {
        Deque<Integer> d = new ArrayDeque<>();
        Map<Integer, Integer> m = new HashMap<>();
        d.addLast(1);
        m.put(1, 0);
        while (!d.isEmpty()) {
            int poll = d.pollFirst();
            int step = m.get(poll);
            if (poll == n * n) return step;
            for (int i = 1; i <= 6; i++) {
                int np = poll + i;
                if (np <= 0 || np > n * n) continue;
                if (nums[np] != -1) np = nums[np];
                if (m.containsKey(np)) continue;
                m.put(np, step + 1);
                d.addLast(np);
            }
        }
        return -1;
    }
}

作者：AC_OIer
        链接：https://leetcode-cn.com/problems/snakes-and-ladders/solution/gong-shui-san-xie-bfs-mo-ni-by-ac_oier-woh6/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
