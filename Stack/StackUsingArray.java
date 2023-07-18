// iMPLEMENTATING STACKUStackUsingArray USING ARRAY
// Complexity of each opration is O(1) exce int when capacity is doubled of stackUStackUsingArray
public class StackUsingArray {

    private int[] arr;
    private int top;

    public StackUsingArray() {
        top = -1;
        arr = new int[5];
    }

    public StackUsingArray(int cap) {
        top = -1;
        arr = new int[cap];
    }

    public void push(int x) {
        // Dynamic StackUsingArray
        if (top == arr.length - 1) {
            // StackUsingArrayFullException e=new StackUsingArrayFullException();
            // throw e;
            doubleCapacity();
        }
        // System.out.println("Length of StackUsingArray is Doubled");
        arr[++top] = x;
        System.out.println(x + " pushed into the StackUsingArray");
    }

    public int pop() throws StackEmptyException {
        if (top < 0) {
            StackEmptyException e = new StackEmptyException();
            throw e;
        } else {
            int x = arr[top--];
            return x;
        }
    }

    public int peek() throws StackEmptyException {
        if (top < 0) {
            // System.out.println("StackUsingArray UderFlow");
            // return -1;
            StackEmptyException e = new StackEmptyException();
            throw e;
        } else {
            int x = arr[top];
            return x;
        }
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        } else {
            return top + 1;
        }
    }

    public boolean isEmpty() {
        if (top < 0) {
            return true;
        } else {
            return false;
        }
    }

    public void printStackUsingArray() throws StackEmptyException {
        if (top < 0) {
            StackEmptyException e = new StackEmptyException();
            throw e;
        }
        for (int i = top; i > -1; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private void doubleCapacity() {
        int temp[] = arr;
        arr = new int[temp.length * 2];
        for (int i = 0; i < temp.length; i++) {
            arr[i] = temp[i];
        }
    }
}