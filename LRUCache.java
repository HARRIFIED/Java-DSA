import java.util.*;

class Node {
    int key;
    int value;
    Node prev;
    Node next;

    Node (int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    Map<Integer, Node> map;
    Node left;
    Node right;
    int capacity;
    public LRUCache(int capacity) {
        // L -> 1 <- R 
        this.capacity = capacity;
        this.map = new HashMap<>(); // store key and pointer to node;
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);

        this.left.next = this.right; // left -> right
        this.right.prev = this.left; // left -> <- right
    }

    // Insert from the right (most recently used)    
    private void insertRight(Node node) {
        Node rightPrev = this.right.prev;
        node.next = this.right;
        this.right.prev = node;
        node.prev = rightPrev;
        rightPrev.next = node;
    }
    // remove from any where on the list
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //
    public int get(int key) {
        if (this.map.containsKey(key)) {
            Node nodeValue = this.map.get(key);
            this.remove(nodeValue); //remove node from current position
            this.insertRight(nodeValue); // insert node at the right (before the right dummy node)
            return nodeValue.value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        Node newNode = new Node(key, value);
        if (this.map.containsKey(key)) {
            // this.remove(newNode);
            this.insertRight(newNode);
            this.map.put(key, newNode);
        } else {
            if (this.map.size() > this.capacity) {
                this.remove(this.left.next);
                this.insertRight(newNode);
                // this.map.remove(this.left.next.key);
                this.map.put(key, newNode);
            } else {
                this.insertRight(newNode);
                this.map.put(key, newNode);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */