
import java.util.*;

class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList("Gratitude");
        linkedList.append("Halo");
        linkedList.append("boxx");
        linkedList.append("Thinking Out Loud");
        linkedList.append("Lovely");
        linkedList.append("Gratitude");
        linkedList.append("2002");
        System.out.println("Before ->" + linkedList.traverseList());
        linkedList.deleteNthFromEnd(3);
        System.out.println("After2 ->" + linkedList.traverseList());
    }
}
