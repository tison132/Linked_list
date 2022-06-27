/*
Name : kavin J
details: program to perform adding,deliting,traversing ,displaying elements in the linked list
*/
import java.util.*;
class ll {
    private Node head;
    private Node tail;
    public int size;

    // <--------------------constructor-part-for-initializing----------------------------------->
    public class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public ll() {
        this.size = 0;
    }

    // <--------------insertion-part-starts------------------>
    public void insetfirst(int val) { // insert at first
        Node node = new Node(val);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void insertlast(int val) { // insert at the last
        if (tail == null) {
            insetfirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;

    }

    public void insert(int val, int index) {
        if (index == 0) {
            insetfirst(val);
            return;
        }
        if (index == size) {
            insertlast(val);
            return;
        }
        Node node = new Node(val);
        Node temp = get(index - 1);
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    // <-------------insertion-part-ends-------------------->
    // <----------Method-to-get-middle-node-address-using-index---------->
    public Node get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // --------------------get-part-ends------------------------------------>
    // <--------------------deletion-part-starts----------------------------->
    public void deletefirst() { // delete first node
        System.out.println("deleted value:" + head.val);
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
    }

    public void deletelast() {
        if (size <= 1) {
            deletefirst();
            return;
        }
        System.out.println("deleted value:" + tail.val);
        Node secondlast = get(size - 2);
        secondlast.next = null;
        tail = secondlast;
        size--;
    }

    public void delete(int index) {
        if (index == 0) {
            deletefirst();
            return;
        }
        if (index == size - 1) {
            deletelast();
            return;
        }
        Node prev_node = get(index - 1);
        System.out.println("deleted value : " + prev_node.next.val);
        prev_node.next = prev_node.next.next;
        size--;

    }

    // <--------------------deletion-part-ends------------------------------>
    // <-------------display-part-starts-------------------->
    public void display() {
        Node temp = head;
        System.out.println("***ELEMENTS IN THE LINKED LIST***");
        while (temp != null) {
            System.out.print(temp.val + "-->");
            temp = temp.next;
        }
        System.out.println("END");
    }
    // <-------------display-part-ends---------------------->
};

public class linked_list_operations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ll list = new ll();
        int choice = 0;
        while (choice != -1) {
            System.out.println("Enter your choice : ");
            System.out.println("1--->Insertion");
            System.out.println("2--->deletion");
            System.out.println("3--->display");
            System.out.println("-1--->exit");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the index and value to be inserted: ");
                    int pos=scan.nextInt();
                    int val=scan.nextInt();
                    list.insert(val, pos);
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Enter the index to be deleted: ");
                    int ind=scan.nextInt();
                    list.delete(ind);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("-----Elements in linked list------");
                    list.display();
                    break;
                case -1:
                    System.out.println("Program exited");
                default:
                    System.out.println("Invalid input");
                    break;
            }

        }
    }
}
