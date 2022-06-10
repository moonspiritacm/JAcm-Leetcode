package com.moonspirit.acm.leetcode.p0675;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    private int dist(List<List<Integer>> forest, int i, int j, int ii, int jj) {
        int[][] dp = new int[m][n];
        dp[i][j]=0;
        return 0;
    }

    public int cutOffTree(List<List<Integer>> forest) {
        if(forest==null || forest.size()==0 || forest.get(0).size()==0) {
            throw new IllegalArgumentException("非法输入");
        }

        int m = forest.size();
        int n = forest.get(0).size();
        Map<Integer, Integer> map = new TreeMap<>();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int h = forest.get(i).get(j);
                if(h>1) {
                    map.put(h,i*n+j);
                }
            }
        }

        int res = 0;
        int i = 0;
        int j = 0;
        for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
            int value = entry.getValue();
            int ii = value/n;
            int jj = value%n;
            res += dist(forest, i, j, ii, jj);
            forest.get(ii).get(jj)=1;
        }
        return res;
    }
}
