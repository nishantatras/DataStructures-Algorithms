public class LinkedList {
    private Node head;

    public static void main(String[] args) {
        // LinkedList llist = new LinkedList();
        // Node five = new Node(5);
        // Node four = new Node(4, five);
        // Node third = new Node(3,four);
        // Node second = new Node(2, third);

        // llist.head = new Node(1, second);
        // // LinkedList.printll(llist);
        // // llist.printithNode(llist,3);
        // // System.out.println(llist.lengthll(llist));
        // LinkedList.printll(llist);

        // LinkedList l1=new LinkedList();
        // Node n3=new Node(3);
        // Node n2=new Node(2,n3);
        // l1.head=new Node(1,n2);

        // Node  n0=new Node(0);
        // LinkedList.push(l1,n0);

        // Node n4 = new Node(4);
        // LinkedList.append(l1,n4);

        // Node n5 = new Node(5);
        // LinkedList.insertnode(l1,3,n5);

        // LinkedList.cuttail(l1);
        // LinkedList.deletenode(l1,5);

        // LinkedList.printll(l1);
        LinkedList l1 = new LinkedList();
        Node n17 = new Node(20);
        Node n16 = new Node(17, n17);
        Node n15 = new Node(12, n16);
        Node n14 = new Node(9, n15);
        Node n13 = new Node(7, n14);
        Node n12 = new Node(5, n13);
        l1.head = new Node(0, n12);

        LinkedList l2 = new LinkedList();
        Node n27 = new Node(7);
        Node n26 = new Node(6, n27);
        Node n25 = new Node(5, n26);
        Node n24 = new Node(4, n25);
        Node n23 = new Node(3, n24);
        Node n22 = new Node(2, n23);
        l2.head = new Node(1, n22);

        // LinkedList l3=new LinkedList();
        // l3.head=l3.merge(l1.head, l2.head);
        // l3.printll();

        LinkedList l4 = new LinkedList();
        Node n47 = new Node(20);
        Node n46 = new Node(4, n47);
        Node n45 = new Node(0, n46);
        Node n44 = new Node(9, n45);
        Node n43 = new Node(2, n44);
        Node n42 = new Node(15, n43);
        l4.head = new Node(10, n42);
        
        l4.swapNodes(l4.head, 1, 3);
        l4.printll();
        // l4.head=l4.mergeSort(l4.head);
        // l4.printll();
        // l1.appendlastn(6);
        // l1.printll();
        // l1.printllrec(l1.head);
        // l1.printithNode(5);
        // l1.peek();
        // Node n8=new Node(8);
        // l1.push(n8);
        // l1.append(n8);
        // Node n1=new Node(1);
        // l1.printll();
        // l1.push(n1);
        // l1.printll();
        // l1.pop();
        // l1.printll();
        // Node nnode = new Node(3);
        // l1.insertnode(1, nnode);
        // l1.printll();

        // l1.printll();
        // System.out.println();
        // l1.deletenode(4);
        // l1.printll();

        // Node n8=new Node(8);
        // System.out.println(l1.findNode(n8));
        // System.out.println(l1.findNode(1));
        // System.out.println(l1.findNoderec(l1.head, 1));
        // System.out.println(l1.findNoderec(l1.head, 0));
        // l1.printll();
        // System.out.println();
        // l1.removeduplicate();
        // l1.printll();

        // l1.appendlastn(7);
        // l1.printll();
        
        // System.out.println(l1.midPoint());
        // System.out.println(l1.midPoint().data);
        
    //     l1.printll();
    //    System.out.print(l1.isPallindrome(l1.head, l1.head));

    // l1.reverse();
    // l1.printll();
         
    // l1.deletenoderec(l1.head,n4);
    // l1.printll();

    }

    public  Node merge(Node head1,Node head2){
    if(head1==null){
    return head2;
    }
    if(head2==null){
    return head1;
    }
     Node head=null;
     Node tail=null;
     Node t1=head1;
     Node t2=head2;
     
     if(t1.data<t2.data){
     head=t1;
     tail=t1;
     t1=t1.next;
     }
     else{
     head = t2;
     tail = t2;
     t2 = t2.next;   
     }

     while(t1!=null&&t2!=null){
        if (t1.data < t2.data) {
             tail.next=t1;
             tail=t1;
             t1 = t1.next;
         } else {
             tail.next = t2;
             tail = t2;
             t2 = t2.next;
         }
     }

     if(t1==null){
         tail.next = t2;
     }
     else{
         tail.next=t1;
     }

      return head; 
    }

    //Error
    // public Node mergeSort(Node head1){
    // if(head1==null){
    // return null;
    // }
    // if(head1.next==null){
    // return head1;
    // }
    // Node mid=midPoint(head1);
    // Node head2=mid.next;
    // mid.next=null;
    // Node left=mergeSort(head1);
    // Node right=mergeSort(head2);
    // return merge(left,right);
    // }

    public static Node midPoint(Node head) {
        // Approach 1
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void printll() {
        Node temp = this.head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void printllrec(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.data);
        printllrec(head.next);
    }

    public void printithNode(int index) {
        // Node temp = this.head;
        // int i = 0;
        // while (temp != null && i <= index) {
        // if (i == index - 1) {
        // System.out.println(temp.data);
        // }
        // i++;
        // temp = temp.next;
        // }
        // System.out.println();
        // OR
        Node temp = this.head;
        int i = 1;
        while (temp != null && i < index) {
            i++;
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    public int lengthll() {
        Node temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    public void peek() {
        System.out.println(this.head + ": Top Node");
        System.out.println(this.head.data + ": Top Node Value");
    }

    public void push(Node me) {
        me.next = this.head;
        this.head = me;
    }

    public void append(Node me) {
        Node temp = this.head;
        while (temp != null && temp.next != null) {
            temp = temp.next;
        }
        temp.next = me;
    }

    public void insertnode(int index, Node me) {

        if (index == 1) {
            me.next = this.head;
            this.head = me;
        } else {
            Node temp = this.head;
            int i = 1;
            while (temp != null && i < index) {
                i++;
                temp = temp.next;
            }
            me.next = temp.next;
            temp.next = me;
        }
    }

    public Node pop() {
        this.head = this.head.next;
        return this.head;
    }

    public void cuttail(LinkedList l) {
        Node temp = this.head;
        while (temp != null && temp.next != null && temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    public void deletenode(int index) {
        Node temp = this.head;
        if (index == 1) {
            this.head = temp.next;
        } else {
            // int i = 1;
            // index--;
            // while (temp != null&&i < index) {
            // i++;
            // temp = temp.next;
            // }
            // temp.next = temp.next.next;
            int i = 1;
            Node prev = null;
            while (temp.next != null && i < index) {
                i++;
                prev = temp;
                temp = temp.next;
            }
            prev.next = temp.next;
        }
    }

    // public Node deletenoderec(Node head,Node me) {
    // if(head==null){
    // return null;
    // }
    // Node temp=deletenoderec(head.next, me);
    // if(temp==me){
    // return temp.next;
    // }
    // return temp;
    // }
    

    public boolean findNode(int nodeval) {
        Node temp = this.head;
        while (temp != null) {
            if (temp.data == nodeval) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public boolean findNode(Node n) {
        Node temp = this.head;
        while (temp != null) {
            if (temp == n) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public boolean findNoderec(Node head,int nodeval) {
    if(head==null){
    return false;
    }

    boolean isfound=findNoderec(head.next,nodeval);

    if(isfound==true){
    return true;
    }
    else{
    if(nodeval==head.data){
    return true;
    }
    return false;
    }
    }

    public boolean findNoderec(Node head,Node me) {
        if (head == null) {
            return false;
        }
        boolean isfound = findNoderec(head.next, me);

        if (isfound == true) {
            return true;
        } else {
            if (me == head) {
                return true;
            }
            return false;
        }
    }

    public void removeduplicate() {
        // Node temp = this.head;
        // while (temp != null && temp.next != null) {
        //     if (temp.data == temp.next.data) {
        //         temp.next = temp.next.next;
        //     } else {
        //         temp = temp.next;
        //     }
        // }

        //opimized
        if (head == null) {
            return ;
        }
        if (head.next == null) {
            return ;
        }
        Node prev = this.head;
        Node curr = head.next;

        while (curr != null) {
            if (prev.data == curr.data) {
                prev.next = curr.next;
            } else if (prev.data != curr.data)
                prev = curr;
            curr = curr.next;
        }
    }

    public void appendlastn(int n) {
        Node temp1 = this.head;
        int l = this.lengthll();
        if (n >= l||n==0) {
            return;
        }
        for (int i = 1; i < l; i++) {
            temp1 = temp1.next;
        }

        temp1.next = this.head;
        Node temp2 = this.head;
        for (int i = 1; i < l - n; i++) {
            temp2 = temp2.next;
        }
        this.head=temp2.next;
        temp2.next = null;
    }

    public void reverse(){
    if(head==null){
    return ;
    }
    if(head.next==null){
    return ;
    }
    Node prev=null;
    Node curr=this.head;
    Node temp=null;
    
    while(curr!=null){
    
    temp = curr.next;
    curr.next=prev;
    prev=curr;
    curr = temp; 
    }
    this.head=prev;
    }
   //10 15 2 0 9 4 20
    public static Node swapNodes(Node head, int i, int j) {
        // Your code goes here
        if (i == j) {
            return head;
        }
        Node px = null;
        Node cx = head;
        int l = 0;
        while (cx != null && l != i) {
            px = cx;
            cx = cx.next;
            l++;
        }

        Node py = null;
        Node cy = head;
        int m = 0;
        while (cy != null && m != j) {
            py = cy;
            cy = cy.next;
            m++;
        }

        if (cx == null || cy == null) {
            return head;
        }

        if (px != null) {
            px.next = cy;
        } else {
            head = cy;
        }

        if (py != null) {
            py.next = cx;
        } else {
            head = cx;
        }

        Node temp = cx.next;
        cx.next = cy.next;
        cy.next = temp;

        return head;
    }
    //requires optimization
    // public boolean isPallindrome(Node right,Node left){
    //     if (right== null){
    //         return true;
    //     }
    //     boolean isp = isPallindrome(right.next,left);
    //     if (isp == false){
    //         return false;
    //     }
    //     boolean isp1 = (right.data == left.data);
    //     left = left.next;
    //     return isp1;
}