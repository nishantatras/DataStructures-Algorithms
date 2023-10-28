public class LinkedList {
    // Each List is recognized by its head
    Node head;
    // size helps maintain no elm remove or search when list is empty
    // capacity is the max no of nodes in the list
    int size, capacity;

    // constructor
    LinkedList() {
        size = 0;
        capacity = 10;
        head = null;
    }

    // adding nodes to list
    // 1. list is full - return without adding a new node
    // 2. list is empty - create new head
    // 3. list has elements - store at last
    public void add(int data) {
        // case 1
        if (size + 1 > capacity) {
            System.out.println("Max LinkedList Size Reached");
            ;
            return;
        }

        // creating new node
        Node newNode = new Node(data);
        Node temp = head;

        // case 2
        if (temp == null) {
            head = newNode;
        }
        // case 3
        else {
            while (temp != null && temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
    }

    // Removal of Nodes from the LinkedList
    // 1. list is empty - return without removing any node
    // 2. Node to remove is head - change head pointer to node next to head
    // 3. Node to remove is present in between- use prev and curr pointer
    // 4. list doesn't have the node
    public void remove(int data) {
        // case1
        if (size <= 0) {
            System.out.println("Linked List is Empty");
            return;
        }
        Node curr = head;
        Node prev = null;

        // case4
        if (!this.contains(data)) {
            return;
        }
        // case 2
        else if (curr.data == data) {
            head = curr.next;
            size--;
        }
        // case 3
        else {
            while (curr != null) {
                if (curr.data == data) {
                    prev.next = curr.next;
                    size--;
                    return;
                }
                prev = curr;
                curr = curr.next;
            }
        }
    }

    // checks if a node is present in list
    public boolean contains(int data) {
        if (size <= 0) {
            System.out.println("Linked List is Empty");
            return false;
        }

        Node temp = head;
        while (temp != null) {
            if (temp.data == data) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // returning index of the node in the linkedlist
    public int getIndex(int data) {
        if (size <= 0) {
            System.out.println("Linked List is Empty");
            return -1;
        }

        if (!this.contains(data)) {
            return -1;
        }

        Node temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.data == data) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }

    public int size() {
        return this.size;
    }

    // printing all nodes from list
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.add(10);
        l.add(20);
        l.add(30);
        l.add(40);
        l.add(50);
        l.print();
        System.out.println(l.contains(40));
        System.out.println(l.contains(60));
        System.out.println(l.getIndex(60));
        System.out.println(l.getIndex(50));
        l.remove(10);
        l.remove(30);
        l.remove(40);
        l.remove(20);
        l.remove(50);
        l.remove(10);
        l.print();
        l.add(10);
        l.add(20);
        l.add(30);
        l.add(40);
        l.add(50);
        l.add(10);
        l.add(20);
        l.add(30);
        l.add(40);
        l.add(50);
        l.add(60);
        l.print();

    }
}

// Node class defined each node packet which has its data and pointer to the
// next node / referenced by object of type node in java
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}