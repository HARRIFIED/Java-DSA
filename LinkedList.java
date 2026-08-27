import java.util.*;

class Node {
    String data;
    Node next;
    Node (String data) {
        this.data = data;
        this.next = null;
    }
}

//?TIP: When doing a fast.next.next we make sure fast and fast.nexts != null

public class LinkedList {
    Node head;
    Node tail;
    int length;
    LinkedList(String data) {
        this.head = new Node(data);
        this.tail = this.head;
        this.length = 1;
    }
    
    void append(String data) {
        /*
            a -> b -> null
         */
        Node newNode = new Node(data);
        this.tail.next = newNode;
        this.tail = newNode;
        this.length++;
    }   

    void prepend(String data) {
        /*
            c -> a -> b -> null 
         */

        Node newNode = new Node(data);
        newNode.next = this.head;
        this.head = newNode;
        this.length++;
    }

    List<String> traverseList() {
        List<String> arr = new ArrayList<>();
        Node current = this.head;
        while(current != null) {
            arr.add(current.data);
            current = current.next;
        }
        return arr;
    }

    // takes the node and the data you want to place after it
    void insert(Node node, String data) {
        /*
            c -> a -> e -> b -> null 
         */

        Node newNode = new Node(data);
        newNode.next = node.next;
        node.next = newNode;
        this.length++;
    }

    boolean remove(String data) { //with dummmy node
        /*
            c -> a -> e -> b -> null
        p   c     
         */

        Node current = this.head;
        if (current != null && current.data.equals(data)) {
            this.head = current.next;
            return true;
        }

        Node prev = null;
        while(current != null && !current.data.equals(data)) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        prev.next = current.next;
        return true;
    }

    Node removeAllMatchingNodes(String data) {
        /*
            nul -> e -> c -> b -> f -> c -> null
                   p         
         */
        
        Node dummy = new Node(null);
        dummy.next = this.head;
        Node prev = dummy;

        while (prev.next != null) {
            if (prev.next.data.equals(data)) {
                prev.next = prev.next.next;
             } else {
                prev = prev.next;
            }
        }
        this.head = dummy.next;
        System.out.println("head -> " + this.head.data);
        System.out.println("tail -> " + this.tail.data);
        return dummy.next;
    }

    /*
     null <- a <- b -> c -> null
              p  c   
     */
    Node reverse() {
        Node current = this.head;
        Node prev = null;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        this.head = prev;
        return prev;
    }
    /*
      a->b->c->d->e->null
            s
                  f
    */
    String findMiddle() { //fast and slow pointers
        Node slow = this.head;
        Node fast = this.head; 
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }   
        return slow.data.toString(); // middle element
    }

    Node deleteNthFromEnd(int n) {
        /*
            n = 3
            null -> a -> b -> c -> d -> e -> f -> null
                    s
                    f
         */

        Node dummy = new Node(null);
        dummy.next = this.head;

        Node slow = this.head; Node fast = this.head;
        // move fast from 0 -> n  times from 
        for (int i = 0; i < n; i++) {
            if (fast.next == null) {
                return this.head;
            }
            fast = fast.next;
        }

        while (fast.next != null) { 
            fast = fast.next;
            slow = slow.next;
        }
        // slow is before the target so point to the next after the target
        slow.next = slow.next.next; 
        return dummy.next;
    }

    //TODO
    Node removeMiddleNode() {
        return this.head;
    }
    //TODO: swap every two adjacent nodes and return its head
    Node swapPairs() {
        return this.head;
    }

    //TODO: reverse between
    Node reverseBetween(int m, int n) {
        return this.head;
    }

    //Floyd's algorithm -> Cycle detection in constant time
    // we can use a set to keep track of if we have seen a node before (from curr = curr.next) but that is O(n)
    boolean hasCycle() {
        Node slow = this.head;
        Node fast = this.head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    //return the node where the cycle begins
    //set can also be used here. When you get to an element already in the set it gets the start of the circle
    // and also gives the answer if the list is a cycle.
    Node detectCycle() {
        Node slow = this.head;
        Node fast = this.head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null; //we return null if there is no cycle in the list (if the loop breaks because f or f.next== null)
        }

        Node current = this.head;

        while (slow != current) {
            slow = slow.next;
            current = current.next;
        }
        return current; // where the cycles starts
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = this.head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(" -> ");
            current = current.next;
        }
        return sb.toString();
    }
}
