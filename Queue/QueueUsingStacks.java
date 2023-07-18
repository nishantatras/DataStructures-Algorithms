import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueUsingStacks<T> {
   Queue<T> q1;
   Queue<T> q2;

    public QueueUsingStacks(){
    q1 = new LinkedList<>();
    q2 = new LinkedList<>();
    }

    public int size() {
        return q1.size();
    }

    public boolean isEmpty() {
        return q1.size() == 0;
    }

    public T front() throws QueueEmptyException {
        if (q1.size() == 0) {
            QueueEmptyException e = new QueueEmptyException();
            throw e;
        }
        // while (!s1.isEmpty()) {
        //     s2.push(s1.pop());
        // }
        // T temp = s2.peek();

        // while (!s2.isEmpty()) {
        //     s1.push(s2.pop());
        // }
        // return temp;
        return q1.peek();
    }

    public void enqueue(T val) {
     if(s1.size()==0){
     q1.add(val);
     }   
     else{
     while(!q1.isEmpty()){
     q2.add(q1.poll());
     }
     q1.poll(val);
     while(!q2.isEmpty()){
     q1.add(q2.poll());
     }
     }
    }

    public T dequeue() throws QueueEmptyException {
        if (s1.size()== 0) {
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
        return q1.poll();
    }
}
