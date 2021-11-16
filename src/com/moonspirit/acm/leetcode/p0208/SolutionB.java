package com.moonspirit.acm.leetcode.p0208;

/**
 * 二维数组（动态创建）。O(L) O(nk)
 */
class TrieB {
    static final int N = 100009;
    int[][] trie;
    int[] count;
    int index;

    public TrieB() {
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
