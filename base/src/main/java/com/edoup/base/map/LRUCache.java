package com.edoup.base.map;

import java.util.HashMap;
import java.util.Map;

/**
 * <p></p>
 *
 * @author edoup
 * @date 2020/12/5 23:50
 */
public class LRUCache {


    class Node<K, V> {

        K key;
        V val;
        Node<K, V> pre;
        Node<K, V> next;

        public Node() {
            this.pre = this.next = null;
        }

        Node(K key, V val) {
            this.key = key;
            this.val = val;
            this.pre = this.next = null;
        }
    }

    class DoubleLinkedList<K, V> {

        Node<K, V> head;
        Node<K, V> tail;

        public DoubleLinkedList() {
            this.head = new Node<>();
            this.tail = new Node<>();
            this.head.next = tail;
            this.tail.pre = head;
        }

        public void addNodeToHead(Node node) {
            node.next = this.head.next;
            node.pre = this.head;
            this.head.next.pre = node;
            this.head.next = node;
        }

        public void removeNode(Node node) {
            node.next.pre = node.pre;
            node.pre.next = node.next;
            node.next = null;
            node.pre = null;
        }

        public Node getLastNode() {
            return this.tail.pre;
        }

        public void removeLastNode() {
            tail.pre = tail.pre.pre;
            tail.pre.next.pre = null;
            tail.pre.next.next = null;
            tail.pre.next = tail;
        }
    }


    Map<Integer, Node> map;
    int capacity;
    DoubleLinkedList doubleLinkedList;

    LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        doubleLinkedList = new DoubleLinkedList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node<Integer, Integer> node = map.get(key);
        doubleLinkedList.removeNode(node);
        doubleLinkedList.addNodeToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            doubleLinkedList.removeNode(node);
            doubleLinkedList.addNodeToHead(node);
        } else {
            Node<Integer, Integer> node = new Node<>(key, value);
            map.put(key, node);
            doubleLinkedList.addNodeToHead(node);
            if (map.size() > capacity) {
                Node lastNode = doubleLinkedList.getLastNode();
                map.remove(lastNode.key);
                doubleLinkedList.removeNode(lastNode);
            }
        }
    }


    public static void main(String[] args) {
        LRUCache lru = new LRUCache(3);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.put(3, 3);
        System.out.println(lru.map.keySet());
        lru.put(4, 4);
        System.out.println(lru.map.keySet());
        lru.put(2, 5);
        System.out.println(lru.map.keySet());
        System.out.println(lru.get(2));
    }
}
