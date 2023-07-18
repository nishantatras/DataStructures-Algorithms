public class QueueUsingArray{
    private int front,rear,size;
    private int[] arr;

    public QueueUsingArray(){
        arr=new int[5];
        front=-1;
        rear=-1;
        size=0;
    }

    public QueueUsingArray(int capacity) {
        arr = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int front() throws QueueEmptyException{
        if(size()==0){
        QueueEmptyException e=new QueueEmptyException();
        throw e;
        }
        return arr[front];
    }

    public void enqueue(int x) throws QueueFullException{
        if(size==arr.length){
        // throw new QueueFullException();
        doubleCapacity();
        }
        if(size()==0){
        front++;
        }
        size++;
        // rear++;
        // if(rear==arr.length){
        // rear=0;
        // }OR
        rear=(rear+1)%arr.length;
        arr[rear]=x;
    
        //To check how the new arr is build after double capacity method
        // for (int j = 0; j < arr.length; j++) {
        //     System.out.println(arr[j]);
        // }
    }

    public int dequeue() throws QueueEmptyException{
        if (size() == 0) {
            QueueEmptyException e = new QueueEmptyException();
            throw e;
        }
        // front++;
        // if(front==arr.length){
        // front=0;
        // }OR
        int temp=arr[front];
        front=(front+1)%arr.length;
        size--;
        if (size() == 0) {
        front=-1;
        rear=-1;
        }
        return temp;
    }

    private void doubleCapacity(){
    int temp[]=arr;
    arr=new int[temp.length*2];
    int index=0;
    for(int i=front; i<temp.length; i++){
    arr[index]=temp[i];
    index++;
    }
    for (int i = 0; i < front; i++) {
    arr[index] = temp[i];
    index++;
    }
    front=0;
    rear=temp.length-1;
 
    System.out.println("doubleCapacity");
    }
}