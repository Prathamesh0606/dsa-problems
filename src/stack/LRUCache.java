package stack;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    Node head = new Node(0,0);
    Node tail = new Node(0, 0);
    Map<Integer, Node> map = new HashMap<>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);

            return node.value;

        } else {
            return -1;
        }

    }


    public void put(int key, int value) {
        if(map.containsKey(key)) {
            remove(map.get(key));
        }

        if(map.size() == capacity) {
            remove(tail.prev);
        }

        insert(new Node(key, value));

    }

    private void remove(Node node) {
        map.remove(node.key);
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void insert(Node node) {
        map.put(node.key, node);
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;
    }


    class Node {
        Node prev, next;
        int key, value;
        public Node(int key, int val) {
            this.key = key;
            this.value = val;
        }

    }


}
