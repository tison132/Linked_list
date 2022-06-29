import java.util.*;

class DLL {
    private Node head;
    private int size = 0;

    private class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    // <-------------------Insertion-part--------------------->
    public void insertFirst(int val) { // method to insert at first
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        size++;
        // System.out.println("size="+size);
    }

    public void insertLast(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            size++;
            return;
        }
        Node target = get(size - 1);
        node.prev = target;
        node.next = null;
        target.next = node;
        size++;
    }

    public void insert(int val, int pos) {
        if (pos == 0) {
            insertFirst(val);
            return;
        }
        if (pos == size) {
            insertLast(val);
            return;
        }
        Node node = new Node(val);
        Node prev_node = get(pos - 1);
        node.next = prev_node.next;
        prev_node.next = node;
        node.prev = prev_node;
        node.next.prev = node;
        size++;
    }

    // <-------------------Insertion-part-ends-------------------->
    // <-------------------Deletion-part-starts------------------->
    public void deleteFirst() {
        if (head != null) {
            System.out.println("Delted value : " + head.val);
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void deleteLast() {
        Node sec_last = get(size - 2);
        System.out.println("Deleted value : " + sec_last.next.val);
        sec_last.next = null;
        size--;
    }

    public void delete(int index) {
        if (index == 0) {
            deleteFirst();
            return;
        }
        if (index == size - 1) {
            deleteLast();
            return;
        }
        Node p = get(index - 2);
        System.out.println("Deleted value=" + p.next.val);
        p.next = p.next.next;
        p.next.next.prev = p;
        size--;
    }

    // <-------------------Deletion-part-ends--------------------->
    // <-------------------Method-to-display-DLL------------------>
    public void display() { // dispaly method
        Node temp = head;
        System.out.println("***Elements-in-the-Linked-list");
        while (temp != null) {
            System.out.print(temp.val + "-->");
            temp = temp.next;
        }
        System.out.print("END\n");
    }

    public void displayRev() { // display in reverse order
        Node last = get(size - 1);
        while (last != null) {
            System.out.print(last.val + "-->");
            last = last.prev;
        }
        System.out.print("END\n");
    }

    // <------------------------------------------------------>
    public Node get(int index) {
        Node target = head;
        for (int i = 0; i < index; i++) {
            target = target.next;
        }
        return target;
    }

}

public class doubly_linked_list {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DLL list = new DLL();
        int choice = 0;
        while (choice != -1) {
            System.out.println("Enter your choice : ");
            System.out.println("1--->Insertion");
            System.out.println("2--->deletion");
            System.out.println("3--->display");
            System.out.println("4--->display in reverse");
            System.out.println("-1--->exit");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the index and value to be inserted: ");
                    int pos = scan.nextInt();
                    int val = scan.nextInt();
                    list.insert(val, pos);
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Enter the index to be deleted: ");
                    int ind = scan.nextInt();
                    list.delete(ind);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("-----Elements in linked list------");
                    list.display();
                    break;
                case 4:
                    System.err.println("-------reverse-of-linked-list------");
                    list.displayRev();
                case -1:
                    System.out.println("Program exited");
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
}