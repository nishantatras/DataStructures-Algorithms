public class DoubleLinkedList {
    // Each List is recognized by its head
    DoubleNode head;
    // size helps maintain no elm remove or search when list is empty
    // capacity is the max no of nodes in the list
    int size, capacity;

    // constructor
    DoubleLinkedList() {
        size = 0;
        capacity = 10;
        head = null;
    }

    // When Node is given to whom node should be attached
    public void add(DoubleNode node, int data) {
        // case 1
        if (size + 1 > capacity) {
            System.out.println("Max DoubleLinkedList Size Reached");
            ;
            return;
        }
        DoubleNode newNode = new DoubleNode(data);

        // case 2
        if (node == null) {
            head = newNode;
        }
        // case3
        else {
            DoubleNode temp = node.next;
            node.next = newNode;
            newNode.next = temp;
            newNode.prev = node;
            temp.prev = newNode;
        }
        size++;
    }

    public void remove(DoubleNode node) {
        // case1
        if (size <= 0 || node == null) {
            System.out.println("Linked List is Empty");
            return;
        }
        // case2
        if (!this.contains(node)) {
            return;
        }
        // case 3
        else if (node.next == null) {
            head = null;
            size--;
        }
        // case 3
        else {
            DoubleNode temp1 = node.prev;
            DoubleNode temp2 = node.next;
            temp1.next = temp2;
            temp2.prev = temp1;
        }
    }

    public boolean contains(DoubleNode node) {
        if (size <= 0) {
            System.out.println("Linked List is Empty");
            return false;
        }

        DoubleNode temp = head;
        while (temp != null) {
            if (temp == node) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int getIndex(DoubleNode node) {
        if (size <= 0) {
            System.out.println("Linked List is Empty");
            return -1;
        }

        if (!this.contains(node)) {
            return -1;
        }

        DoubleNode temp = head;
        int index = 0;
        while (temp != null) {
            if (temp == node) {
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
        DoubleNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoubleLinkedList l = new DoubleLinkedList();

    }
}

// Node class defined each node packet which has its data and pointer to the
// next node / referenced by object of type node in java
class DoubleNode {
    int data;
    DoubleNode next;
    DoubleNode prev;

    DoubleNode(int data) {
        this.data = data;
        this.next = null;
    }

    DoubleNode(int data, DoubleNode next) {
        this.data = data;
        this.next = next;
    }

    DoubleNode(int data, DoubleNode next, DoubleNode prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

}
