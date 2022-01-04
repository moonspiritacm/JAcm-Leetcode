package com.moonspirit.acm.leetcode.p0475;

import java.util.Arrays;

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        if(houses==null||houses.length==0||heaters==null||heaters.length==0) {
            throw new IllegalArgumentException("非法输入");
        }

        int res = 0;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        for(int i=0, j=0; i<houses.length; i++) {
            while(j<heaters.length&&heaters[j]<houses[i]) {
                j++;
            }
            if(j==heaters.length) {
                res = Math.max(res, houses[i]-heaters[j-1]);
            } else if(j==0) {
                res = Math.max(res, heaters[j]-houses[i]);
            } else {
                res = Math.max(res, Math.min(heaters[j]-houses[i], houses[i]-heaters[j-1]));
            }
        }
        return res;
    }
}
