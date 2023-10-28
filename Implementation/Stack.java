public class Stack {

    // Implementing Stack Using Array
    // private int[] arr;
    // private int index;
    // private int size;
    // public Stack() {
    // arr = new int[10];
    // index = -1;
    // size = 0;
    // }

    // private void push(int data) {
    // if (size >= arr.length + 1) {
    // System.out.println("Stack is Full");
    // return;
    // } else {
    // index++;
    // size++;
    // arr[index] = data;
    // }
    // }

    // private int pop() {
    // if (size <= 0) {
    // return -1;
    // } else {
    // int temp = arr[index];
    // index--;
    // size--;
    // return temp;
    // }
    // }

    // private int peek() {
    // if (size <= 0) {
    // return -1;
    // } else {
    // return arr[index];
    // }
    // }

    // private void print() {
    // if (size <= 0) {
    // System.out.println("Stack is Empty");
    // return;
    // }
    // for (int i = 0; i <= index; i++) {
    // System.out.println(arr[i]);
    // System.out.println("-----");
    // }
    // System.out.println();
    // }

    // Implementing Stack using LinkedList
    Node head;
    int capacity;
    int size;

    public Stack() {
        head = null;
        size = 0;
        capacity = 10;
    }

    private void push(int data) {
        if (size >= capacity) {
            System.out.println("Stack is Full");
            return;
        } else {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
            size++;
        }
    }

    private int pop() {
        if (size <= 0) {
            return -1;
        } else {
            int temp = head.data;
            head = head.next;
            size--;
            return temp;
        }
    }

    private int peek() {
        if (size <= 0) {
            return -1;
        } else {
            return head.data;
        }
    }

    private void print() {
        if (size <= 0) {
            System.out.println("Stack is Empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            System.out.println("-------");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        s.print();
        System.out.println(s.pop());
        System.out.println(s.pop());
        s.print();
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}