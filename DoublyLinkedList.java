import java.util.*;

class DNode {
    String data;
    DNode next;
    DNode prev;

    DNode(String data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DoublyLinkedList {
    DNode head;
    DNode tail;
    DoublyLinkedList(String data) {
        this.head = new DNode(data);
        this.tail = this.head;
    }
    
    void append(String data) {
        DNode newNode = new DNode(data);
        this.tail.next = newNode;
        newNode.prev = this.tail;
        this.tail = newNode;
    }   

    void remove(String data) {
        DNode node = new DNode(data);
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            this.head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            this.tail = node.prev;
        }
    }


    List<String> printList() {
        DNode current = this.head;
        List<String> list = new ArrayList<String>();
        while (current != null) {
            list.add(current.data);
            current = current.next;
        }
        return list;
    }

    // @Override
    // public String toString() {
    //     StringBuilder sb = new StringBuilder();
    //     DNode current = this.head;
    //     while (current != null) {
    //         sb.append(current.data);
    //         if (current.next != null) sb.append(" -> ");
    //         current = current.next;
    //     }
    //     return sb.toString();
    // }
}
