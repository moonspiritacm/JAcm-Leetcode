package com.moonspirit.acm.leetcode.p0208;

/**
 * TrieNode。O(L) O(nk)
 */
class TrieNode {
    TrieNode[] children;
    boolean isLeaf;

    public TrieNode() {
        this.isLeaf = false;
        this.children = new TrieNode[26];
    }
}

class TrieA {
    TrieNode root;

    public TrieA() {
        this.root = new TrieNode();
    }

    public void insert(String s) {
        TrieNode node = root;
        for (char ch : s.toCharArray()) {
            int i = ch - 'a';
            if (node.children[i] == null) {
                node.children[i] = new TrieNode();
            }
            node = node.children[i];
        }
        node.isLeaf = true;
    }

    private TrieNode searchPrefix(String s) {
        TrieNode node = root;
        for (char ch : s.toCharArray()) {
            int i = ch - 'a';
            if (node.children[i] == null) {
                return null;
            }
            node = node.children[i];
        }
        return node;
    }

    public boolean search(String s) {
        TrieNode node = searchPrefix(s);
        return node != null && node.isLeaf;
    }

    public boolean startsWith(String s) {
        TrieNode node = searchPrefix(s);
        return node != null;
    }
}
