package design;

import java.util.HashMap;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制
 * 146
 * 思路：构建双向链表和使用hashmap使得获取元素时间复杂度为O(1)
 */
public class LRUCache {

    private Map<Integer, Node> nodeMap = new HashMap<>();

    private DoubleList doubleList = new DoubleList();

    private int cap;

    private class Node {

        public int key;

        public int val;

        public Node pre = null;

        public Node next = null;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private class DoubleList {

        public Node head = null;

        public Node tail = null;

        public int size = 0;

        // 新增节点
        public void addFirst(Node node) {
            if (head == null && tail == null) {
                head = tail = node;
            } else {
                Node cur = head;
                node.next = cur;
                cur.pre = node;
                head = node;
            }
            size++;
        }

        // 删除节点
        public void remove(Node node) {
            if (head == null && tail == null) {
                return;
            } else if (head == node && tail == node) {
                head = tail = null;
            } else if (head == node) {
                Node cur = head.next;
                cur.pre = null;
                node = null;
                head = cur;
            } else if (tail == node) {
                Node cur = tail.pre;
                cur.next = null;
                node = null;
                tail = cur;
            } else {
                Node pre = node.pre;
                Node next = node.next;
                node = null;
                pre.next = next;
                next.pre = pre;
            }
            size--;
        }

        // 如果容量满了删除最后一个节点
        public Node removeLast() {
            Node cur = tail;
            remove(cur);
            return cur;
        }
    }

    public LRUCache(int cap) {
        this.cap = cap;
    }


    public int get(int key) {
        Node cur = nodeMap.get(key);
        if (cur == null) {
            return -1;
        }
        int val = cur.val;
        put(key, val);
        return val;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (nodeMap.containsKey(key)) {
            Node oldNode = nodeMap.get(key);
            doubleList.remove(oldNode);
            doubleList.addFirst(node);
            nodeMap.put(key, node);
        } else {
            // 如果满了则删除最后一个元素
            if (cap == doubleList.size) {
                Node oldNode = doubleList.removeLast();
                nodeMap.remove(oldNode.key);
            }
            doubleList.addFirst(node);
            nodeMap.put(key, node);
        }
    }
}
