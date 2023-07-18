// implementing Generic stack using linkedlist
//Complexity of each opration is O(1)
public class StackUsingLL<T> {

    private Node<T> head;
    private int size = 0;

    public void push(T x) {
        Node<T> newnode = new Node<T>(x);
        newnode.next = head;
        head = newnode;
        size++;
        System.out.println(x + " pushed into the stack");
    }

    public T pop() throws StackEmptyException {
        if (head == null) {
            StackEmptyException e = new StackEmptyException();
            throw e;
        }
        T x = head.data;
        head = head.next;
        size--;
        return x;
    }

    public T peek() throws StackEmptyException {

        if (head == null) {
            StackEmptyException e = new StackEmptyException();
            throw e;
        }
        return head.data;
    }

    public int size() {
        // T size = 0;
        // Node<T> temp = head;
        // while (temp != null) {
        // size++;
        // temp = temp.next;
        // }
        // no need for transversal,I had just declare a variable size whiv updates to ++
        // when push is called and -- when pop is called
        return size;
    }

    public boolean isEmpty() {
        // if (head == null) {
        // return true;
        // } else {
        // return false;
        // } OR
        return size == 0;
    }

    public void printStack() throws StackEmptyException {
        if (head == null) {
            StackEmptyException e = new StackEmptyException();
            throw e;
        }
        Node<T> temp = head;
        while (temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}