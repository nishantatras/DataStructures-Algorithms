import java.util.Queue;

public class QueueUsingStacks<T> {

    public QueueUsingStacks() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public int size() {
        return s1.size();
    }

    public boolean isEmpty() {
        return s1.size() == 0;
    }

    public T front() throws QueueEmptyException {
        if (s1.size() == 0) {
            QueueEmptyException e = new QueueEmptyException();
            throw e;
        }
        // while (!s1.isEmpty()) {
        // s2.push(s1.pop());
        // }
        // T temp = s2.peek();

        // while (!s2.isEmpty()) {
        // s1.push(s2.pop());
        // }
        // return temp;
        return s1.peek();
    }

    public void enqueue(T val) {
        if (s1.size() == 0) {
            s1.push(val);
        } else {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(val);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
    }

    public T dequeue() throws QueueEmptyException {
        if (s1.size() == 0) {
            QueueEmptyException e = new QueueEmptyException();
            throw e;
        }
        // while(!s1.isEmpty()){
        // s2.push(s1.pop());
        // }
        // T temp=s2.pop();

        // while(!s2.isEmpty()){
        // s1.push(s2.pop());
        // }
        // return temp;
        return s1.pop();
    }
}
