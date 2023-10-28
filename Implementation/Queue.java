public class Queue {
    // // Implementin Queue using Array
    // private int[] arr;
    // private int f, r;

    // public Queue() {
    // arr = new int[10];
    // f = 0;
    // r = 0;
    // }

    // private void enqueue(int data) {
    // if (r == arr.length) {
    // System.out.println("Queue is Full");
    // return;
    // } else {
    // arr[r++] = data;
    // }
    // }

    // private int dequeue() {
    // if (f == r) {
    // System.out.println("Queue is Empty");
    // return -1;
    // } else {
    // // O(N) but fill array completely
    // // int temp = arr[f];
    // // for (int i = 1; i <= r; i++) {
    // // arr[i - 1] = arr[i];
    // // }
    // // r--;
    // int temp = arr[f++];
    // return temp;
    // }
    // }

    // private int peek() {
    // if (f == r) {
    // System.out.println("Queue is Empty");
    // return -1;
    // } else {
    // return arr[f];
    // }
    // }

    // public boolean isFull() {
    // return r == arr.length;
    // }

    // public boolean isEmpty() {
    // return f == r;
    // }

    // private void print() {
    // if (f == r) {
    // System.out.println("Queue is Empty");
    // return;
    // }
    // for (int i = f; i < r; i++) {
    // System.out.println(arr[i]);
    // System.out.println("-----");
    // }
    // System.out.println();
    // }

    // // Implementin Queue using LinkedList

    Node head;
    int size, capacity;

    public Queue() {
        head = null;
        size = 0;
        capacity = 10;
    }

    private void enqueue(int data) {
        Node newNode = new Node(data);
       if(size == 0){
        head = newNode;
       }
       else if(size == capacity){
        System.out.println("Queue has reached max capacity");
       }
       else{
        Node temp = head;
        while(temp != null){
            temp = temp.next;
        }
        temp.next = newNode;
       }
    }

    private int dequeue() {
        if (head == null) {
            System.out.println("Queue is Empty");
        }

        int temp = head.data;
        head = head.next;
        return temp;
    }

    private int peek() {
        if (head == null) {
            System.out.println("Queue is Empty");
        }
        return head.data;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void print() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            System.out.println("---------");
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.print();
        q.dequeue();
        q.dequeue();
        q.print();
        System.out.println(q.isEmpty());
        System.out.println(q.isFull());
        System.out.println(q.peek());

    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}