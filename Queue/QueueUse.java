public class QueueUse {
public static void main(String[] args) throws QueueEmptyException,QueueFullException{
    // QueueUsingArray q=new QueueUsingArray(5);
    QueueUsingStacks<Integer> q=new QueueUsingStacks<>();
    for(int i=1; i<=6; i++){
    q.enqueue(i);
    }
    System.out.println("------" + q.size() + "------");
    while(!q.isEmpty()){
    System.out.println(q.dequeue());
    }
    q.enqueue(10);
    q.enqueue(11);
    System.out.println("------" + q.size() + "------");
    System.out.println(q.dequeue());
    System.out.println(q.dequeue());
    q.enqueue(15);
    System.out.println("------" + q.size() + "------");
    System.out.println(q.dequeue());
    // System.out.println(q.dequeue());
    System.out.println("------"+q.size()+"------");
}    
}
