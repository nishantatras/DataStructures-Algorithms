public class QueueUsingLL<T> {
    Node<T> front;
    Node<T> rear;
    int size;

    public QueueUsingLL(){
    front=null;
    rear=null;
    size=0;
    }

    public int size(){
    return size;
    }

    public boolean isEmpty(){
    return size==0;
    }

    public T front() throws QueueEmptyException{
    if(size==0){
    QueueEmptyException e = new QueueEmptyException();
    throw e;
    }
    return front.data;
    }

    public void enqueue(T val){
    Node<T> newNode= new Node<>(val);
    if(size==0){
    front=newNode;
    rear=newNode;
    }
    else{
    rear.next=newNode;
    rear=newNode;
    }
    size++;
    }

    public T dequeue() throws QueueEmptyException{
    if(size==0){
    QueueEmptyException e=new QueueEmptyException();
    throw e;
    }
    T temp = front.data;
    size--;
    if(size==0){
    front=null;
    rear=null;
    }
    else{
    front=front.next;
    }
    return temp;
    }
}
