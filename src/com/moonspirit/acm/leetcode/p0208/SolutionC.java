package com.moonspirit.acm.leetcode.p0208;

import java.util.Arrays;

/**
 * 二维数组（静态创建）。O(L) O(nk)
 */
class TrieC {
    static final int N = 100009;
    static int[][] trie = new int[N][26];
    static int[] count = new int[N];
    static int index = 0;

    public TrieC() {
        for (int i = 0; i <= index; i++) {
            Arrays.fill(trie[i], 0);
        }
        Arrays.fill(count, 0);
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
