import java.util.*;
/*
    Design and implement a data structure for a Least Frequently Used (LFU) cache.

    Implement the LFUCache class:

    LFUCache(int capacity) Initializes the object with the capacity of the data structure.
    int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
    void put(int key, int value) Update the value of the key if present, or inserts the key if not already present. 
    When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. 
    For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
    To determine the least frequently used key, a use counter is maintained for each key in the cache. The key with the smallest use counter is the least frequently used key.

    When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation). 
    The use counter for a key in the cache is incremented either a get or put operation is called on it.

    The functions get and put must each run in O(1) average time complexity.
 */

class Node {
    int key;
    int value;
    int freq;
    Node prev;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.freq = 1;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node left;
    Node right;
    int size;

    DoublyLinkedList() {
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.size = 0;

        this.left.next = this.right;
        this.right.prev = this.left;
    }

    void insertLeft(Node node) {
        Node next = this.left.next;
        this.left.next = node;
        node.prev = this.left;
        node.next = next;
        next.prev = node;
        this.size++;
    }

    void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        //detach node for garbage collector
        node.prev = null;
        node.next = null;
        this.size--;
    }

    Node removeRight() {
        if (this.size == 0) {
            return null;
        }
        Node nodeToRemove = this.right.prev;
        this.remove(nodeToRemove);
        return nodeToRemove;
    }

    boolean isEmpty() {
        return this.size == 0;
    }
}

class LFUCache {
    private final int capacity;
    private final Map<Integer, Node> keyNode;
    private final Map<Integer, DoublyLinkedList> freqList;
    private int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.keyNode = new HashMap<>();
        this.freqList = new HashMap<>();
        this.minFreq = 0;
    }
    
    public int get(int key) {
        if (!this.keyNode.containsKey(key)) {
            return -1;
        }

        Node node = this.keyNode.get(key);
        this.increaseFreq(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (this.capacity == 0) {
            return;
        }

        if (this.keyNode.containsKey(key)) {
            Node node = this.keyNode.get(key);
            node.value = value;
            this.increaseFreq(node);
        } else {
            if (this.keyNode.size() >= this.capacity) {
                DoublyLinkedList list = this.freqList.get(this.minFreq);
                Node nodeToRemove = list.removeRight();
                this.keyNode.remove(nodeToRemove.key);
            }

            Node newNode = new Node(key, value);
            this.keyNode.put(key, newNode);

            DoublyLinkedList list = this.freqList.getOrDefault(1, new DoublyLinkedList());
            list.insertLeft(newNode);
            this.freqList.put(1, list);
            this.minFreq = 1; //set back to 1 for every new put
        }
    }

    private void increaseFreq(Node node) {
        int oldFreq = node.freq;
        DoublyLinkedList oldList = this.freqList.get(oldFreq);
        oldList.remove(node);

        if (oldFreq == this.minFreq && oldList.isEmpty()) {
            minFreq++;
        }

        node.freq++; //bump the node freq
        DoublyLinkedList list = this.freqList.getOrDefault(node.freq, new DoublyLinkedList());
        list.insertLeft(node);
        this.freqList.put(node.freq, list);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */