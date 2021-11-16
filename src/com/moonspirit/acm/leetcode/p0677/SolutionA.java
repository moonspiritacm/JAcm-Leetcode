package com.moonspirit.acm.leetcode.p0677;

class MapSum {
    TrieNode root;

    public MapSum() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode node = root;
        for (char ch : key.toCharArray()) {
            if (node == null) {
                node = new TrieNode();
            }
            node = node.children[ch - 'a'];
        }
        if (node == null) {
            node = new TrieNode();
        }
        node.value = val;
        node.isLeaf = true;
    }

    public int sum(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            if (node == null) {
                return 0;
            }
            node = node.children[ch - 'a'];
        }
        return dfs(node);
    }

    private int dfs(TrieNode root) {
        if (root == null) {
            return 0;
        }

        int res = 0;
        for (TrieNode node : root.children) {
            if (node == null) {
                continue;
            }
            if (node.isLeaf) {
                res += node.value;
            } else {
                res += dfs(node);
            }
        }
        return res;
    }
}

class TrieNode {
    int value;
    boolean isLeaf;
    TrieNode[] children;

    public TrieNode() {
        this.value = 0;
        this.isLeaf = false;
        this.children = new TrieNode[26];
    }
}
