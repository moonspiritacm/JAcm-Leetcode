package com.moonspirit.acm.leetcode.p0146;

import java.util.HashMap;
import java.util.Map;

/**
 * 双向链表。O(1) O(n)
 * <p>
 * 双向链表按照访问时间存储键值对，靠近头部是最近使用的，靠近尾部是最久未使用的。
 * 哈希表<key, node>用于快速定位双向链表中的节点。
 */
class LRUCache {
    int cap;
    Node head, tail;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();
        head = new Node(Integer.MIN_VALUE, Integer.MIN_VALUE);
        tail = new Node(Integer.MIN_VALUE, Integer.MIN_VALUE);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            refresh(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = null;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.val = value;
        } else {
            if (map.size() == cap) {
                map.remove(delete());
            }
            node = new Node(key, value);
            map.put(key, node);
        }
        refresh(node);
    }

    private void refresh(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private int delete() {
        Node node = tail.prev;
        node.prev.next = tail;
        tail.prev = node.prev;
        return node.key;
    }
}

class Node {
    int key, val;
    Node prev, next;

    public Node() {
    }

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
