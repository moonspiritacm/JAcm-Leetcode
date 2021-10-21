package com.moonspirit.acm.leetcode.p0208;

/**
 * 二维数组。O(L) O(nk)
 *
 * 使用二维数组实现，需要预先估算数组大小。
 * 理论上，数组规模约等于字符总数，
 */
class Trie {
    int N = 100000;
    int[][] trie;
    int[] count;
    int index;

    public Trie() {
        trie = new int[N][26];
        count = new int[N];
        index = 0;
    }

    public void insert(String s) {
        int i = 0;
        for (char ch : s.toCharArray()) {
            int j = ch - 'a';
            if (trie[i][j] == 0) {
                trie[i][j] = ++index;
            }
            i = trie[i][j];
        }
        count[i]++;
    }

    public boolean search(String s) {
        int i = 0;
        for (char ch : s.toCharArray()) {
            int j = ch - 'a';
            if (trie[i][j] == 0) {
                return false;
            }
            i = trie[i][j];
        }
        return count[i] != 0;
    }

    public boolean startsWith(String s) {
        int i = 0;
        for (char ch : s.toCharArray()) {
            int j = ch - 'a';
            if (trie[i][j] == 0) {
                return false;
            }
            i = trie[i][j];
        }
        return true;
    }
}
