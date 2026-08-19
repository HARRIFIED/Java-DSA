import java.util.*;

class Node {
    String data;
    Node next;
    Node (String data) {
        this.data = data;
        this.next = null;
    }
}

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
     null <- a <- b <- c  null
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

        if (fast == null || fast.next == null) return null;
        while (this.head != slow) {
            this.head = this.head.next;
            slow = slow.next;
        }
        return head; // where the cycle begins
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
