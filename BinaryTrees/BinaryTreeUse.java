import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;


public class BinaryTreeUse {

    public static BinaryTreeNode<Integer> takeInput(){
    System.out.println("Enter the root data");
    Scanner s=new Scanner(System.in);
    int rootdata=s.nextInt();
    if(rootdata==-1){
        s.close();
    return null;
    }

    BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(rootdata);
    BinaryTreeNode<Integer> left = takeInput();
    BinaryTreeNode<Integer> right = takeInput();
    root.left=left;
    root.right=right;
    s.close();
    return root;
    }

    public static BinaryTreeNode<Integer> takeInputadv(boolean isRoot, int parentData,boolean isleft) {
        if(isRoot){
        System.out.println("Enter the root data");
        }
        else{
            if (isleft) {
                System.out.println("Enter the left child of "+parentData);
            } else {
                 System.out.println("Enter the right child of " + parentData);
            }
        }
        Scanner s = new Scanner(System.in);
        int rootdata = s.nextInt();
        if (rootdata == -1) {
            s.close();
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootdata);
        BinaryTreeNode<Integer> left = takeInputadv(false,rootdata,true);
        BinaryTreeNode<Integer> right = takeInputadv(false,rootdata,false);
        root.left = left;
        root.right = right;
        s.close();
        return root;
    }

    public static void PreOrder(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data+": ");
        if(root.left!=null){
        System.out.print("L: "+root.left.data+" ");
        }
        if (root.right != null) {
            System.out.print("R: " + root.right.data + " ");
        }
        System.out.println();
        PreOrder(root.left);
        PreOrder(root.right);
    }
    
    public static void PostOrder(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        PostOrder(root.left);
        PostOrder(root.right);
        System.out.print(root.data + ": ");
        if (root.left != null) {
            System.out.print("L: " + root.left.data + " ");
        }
        if (root.right != null) {
            System.out.print("R: " + root.right.data + " ");
        }
        System.out.println();

    }
    
    public static void InOrder(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        InOrder(root.left);
        System.out.print(root.data + ": ");
        if (root.left != null) {
            System.out.print("L: " + root.left.data + " ");
        }
        if (root.right != null) {
            System.out.print("R: " + root.right.data + " ");
        }
        System.out.println();
        InOrder(root.right);
    }

    public static int numofNodes(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int n = 1+numofNodes(root.left)+numofNodes(root.right);
        return n;
    }

    public static int sumofNodes(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int sum = root.data + sumofNodes(root.left) + sumofNodes(root.right);
        return sum;
    }

    public static int maxofNodes(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int max = Math.max(root.data,Math.max( maxofNodes(root.left),maxofNodes(root.right)));
        return max;
    }

    public static int Nodesgreater(BinaryTreeNode<Integer> root,int val) {
        if (root == null) {
            return 0;
        }
        int n=Nodesgreater(root.left, val)+Nodesgreater(root.right, val);
        if(root.data>val){
        n++;
        }
        return n;
    }

    public static int heightofTree(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        return 1+Math.max(heightofTree(root.left),heightofTree(root.right));
    }


    public static int numofLeaves(BinaryTreeNode<Integer> root) {
        if(root==null){
            return 0;
        }
        if (root.left==null&&root.right==null) {
            return 1;
        }
        return numofLeaves(root.left)+numofLeaves(root.right);
    }

    public static void NodesatDepth(BinaryTreeNode<Integer> root,int depth) {
        if (root == null) {
        return;
        }
        if(depth==0){
        System.out.print(root.data+" ");
        return;
        }
        NodesatDepth(root.left, depth-1);
        NodesatDepth(root.right, depth-1);
    }

    public static void ReplaceNodeswithDepth(BinaryTreeNode<Integer> root, int depth) {
        if (root == null) {
            return;
        }
        root.data=depth;
        ReplaceNodeswithDepth(root.left, depth+1);
        ReplaceNodeswithDepth(root.right, depth+1);
    }

    public static boolean isPresent(BinaryTreeNode<Integer> root, int val) {
        if (root == null) {
            return false;
        }
        if (root.data == val) {
            return true;
        }

        return isPresent(root.left, val)||isPresent(root.right, val);
    }

    public static void NodesWithoutSibling(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        if(root.right==null&&root.left==null){
        return ;
        }
        else if (root.right == null) {
        System.out.println(root.left.data);
        }
        else if (root.left == null) {
        System.out.println(root.right.data);
        }
        NodesWithoutSibling(root.left);
        NodesWithoutSibling(root.right);
    }

    public static BinaryTreeNode<Integer> RemoveLeaves(BinaryTreeNode<Integer> root){
    
        if(root==null){
        return null;
        }
        if(root.left==null&&root.right==null){
        return null;
        }
        root.left=RemoveLeaves(root.left);
        root.right=RemoveLeaves(root.right);

        return root;
    } 

    //Extra space for temp node
    public static void MirrorTree(BinaryTreeNode<Integer> root) {

        if (root == null) {
            return ;
        }
        if (root.left == null && root.right == null) {
            return ;
        }

        MirrorTree(root.left);
        MirrorTree(root.right);

        BinaryTreeNode<Integer> temp=root.left;
        root.left = root.right;
        root.right = temp;
    }
//REDO
    // public static BinaryTreeNode<Integer> MirrorTreeadv(BinaryTreeNode<Integer> root,boolean isleft) {

    //     if (root == null) {
    //         return null;
    //     }
    //     if (root.left == null && root.right == null) {
    //         return root;
    //     }
        
    //     root.right=MirrorTreeadv(root.left,true);
    //     root.left = MirrorTreeadv(root.right,false);

    //     return root;
    // }
    
    //O(nlogn)
    public static boolean BalancedTree(BinaryTreeNode<Integer> root) {

        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }

        int lh=heightofTree(root.left);
        int rh=heightofTree(root.right);

        if(Math.abs(lh-rh)<=1){
        return BalancedTree(root.left)&&BalancedTree(root.right);
        }
        else{
        return false;
        }
    }
    
    //O(n)
    public static BalancedTreeReturn BalancedTreeReturn(BinaryTreeNode<Integer> root) {

        if (root == null) {
            int height=0;
            boolean isbal=true;
            BalancedTreeReturn ans=new BalancedTreeReturn();
            ans.height=height;
            ans.isbal=isbal;
            return ans;

        }

        BalancedTreeReturn left=BalancedTreeReturn(root.left);
        BalancedTreeReturn right = BalancedTreeReturn(root.right);
        boolean isbal=true;
        int height=1+Math.max(left.height,right.height);
        if(Math.abs(left.height-right.height)>1){
        isbal=false;
        }
        if (left.isbal==false||right.isbal==false){
        isbal = false;
        }
  
        BalancedTreeReturn ans=new BalancedTreeReturn();
        ans.height=height;
        ans.isbal=isbal;
        return ans;
    }
    
    public static int DiameterofTree(BinaryTreeNode<Integer> root) {

        if (root == null) {
            return 0;
        }
        
        int lh=heightofTree(root.left);
        int rh=heightofTree(root.right);

        int ld = DiameterofTree(root.left);
        int rd = DiameterofTree(root.right);
        
        return Math.max(lh+rh+1,Math.max(ld,rd));
    }

    public static Diameter DiameterofTreeadv(BinaryTreeNode<Integer> root) {

        if (root == null) {
            int height = 0;
            int diameter=0;
            Diameter ans = new Diameter();
            ans.height =height;
            ans.diameter=diameter;
            return ans;
        }

        Diameter left =  DiameterofTreeadv(root.left);
        Diameter right = DiameterofTreeadv(root.right);
        int height = 1 + Math.max(left.height, right.height);
        int diameter=Math.max(left.height+right.height+1,Math.max(left.diameter,right.diameter));
        
        Diameter ans=new Diameter();
        ans.height = height;
        ans.diameter=diameter;
        return ans;
    }

    public static BinaryTreeNode<Integer> takeInputLvlwise() {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter Root Data:");
        int data=s.nextInt();

        if(data==-1){
            s.close();
            return null;
        }

        BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(data);
        Queue<BinaryTreeNode<Integer>> q=new LinkedList<BinaryTreeNode<Integer>>();
        
        q.add(root);

        while(!q.isEmpty()){
            BinaryTreeNode<Integer> front=q.poll();
            System.out.println("Enter left child of "+front.data);
            int l=s.nextInt();
            if(l!=-1){
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(l);
                front.left=leftChild;
                q.add(leftChild);
            }
        
            System.out.println("Enter right child of " + front.data);
            int r = s.nextInt();
            if (r != -1) {
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(r);
                front.left = rightChild;
                q.add(rightChild);
            }
        }
        s.close();
        return root;
    }

    public static void LevelOrderTransversal(BinaryTreeNode<Integer> root) {
    if(root==null){
    return;
    }

    Queue<BinaryTreeNode<Integer>> q=new LinkedList<BinaryTreeNode<Integer>>();
    q.add(root);

    while(!q.isEmpty()){
    BinaryTreeNode<Integer> front=q.poll();
    if(front.left!=null){
    q.add(front.left);
    }
    if(front.right!=null){
    q.add(front.right);
    }

    System.out.print(front.data + ": ");
    if (front.left != null) {
        System.out.print("L: " + front.left.data + " ");
    }
    if (front.right != null) {
        System.out.print("R: " + front.right.data + " ");
    }
    System.out.println();
    }
    }    

    public static BinaryTreeNode<Integer>  buildTree(int[] in,int[] pre,int pres,int pree,int ins,int ine){

        if(pres>pree ||ins>ine){
        return null;
        }
        
        int rootval=pre[pres];
        BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(rootval);

        int k=0;
        for(int i=ins; i<=ine; i++){
            if(rootval==in[i]){
                k=i;
                break;
            }
        }

        root.left=buildTree(in, pre, pres+1, pres+(k-ins), ins, k-1);
        root.right = buildTree(in, pre, pres + (k-ins)+1, pree,k+1,ine);

        return root;
    } 
    public static void main(String[] args) {
        // BinaryTreeNode<Integer> l1r2 = new BinaryTreeNode<Integer>(4);
        // BinaryTreeNode<Integer> r1l2 = new BinaryTreeNode<Integer>(5);
        // BinaryTreeNode<Integer> l1 = new BinaryTreeNode<Integer>(2,null,l1r2);
        // BinaryTreeNode<Integer> r1 = new BinaryTreeNode<Integer>(3,null,r1l2);
        // BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1, l1, r1);
     
        // BinaryTreeNode<Integer> root = takeInputLvlwise();
        // BinaryTreeNode<Integer> root=takeInputadv(true,0,true);
        // System.out.println("Preorder");
        // PreOrder(root);
        // System.out.println("PostOrder");
        // PostOrder(root);
        // System.out.println("Inorder");
        // InOrder(root);

        // System.out.println(numofNodes(root));
        // System.out.println(sumofNodes(root));
        // System.out.println(maxofNodes(root));
        // System.out.println(Nodesgreater(root, 5));
        // System.out.println(heightofTree(root));
        // System.out.println(numofLeaves(root));

        // NodesatDepth(root, 3);
        // ReplaceNodeswithDepth(root,0);
        // PreOrder(root);

        // System.out.println(isPresent(root, 10));
        // NodesWithoutSibling(root);
        
        // root = RemoveLeaves(root);
        // PreOrder(root);

        // PreOrder(root);
        // MirrorTree(root);
        // PreOrder(root);
        // PreOrder(root);
        // root=MirrorTreeadv(root,false);
        // PreOrder(root);

        // System.out.println(BalancedTree(root));
        // BalancedTreeReturn ans= BalancedTreeReturn(root);
        // System.out.println(ans.isbal);

        // Diameter ans=DiameterofTreeadv(root);
        // System.out.println(ans.diameter);
        // int[] in={4,2,5,1,3};
        // int[] pre={1,2,4,5,3};
        // BinaryTreeNode<Integer> root=buildTree(in, pre, 0, pre.length-1, 0, in.length-1);

        // LevelOrderTransversal(root);
        
        BinaryTreeNode<Integer> root = takeInputLvlwise();
        rightview(root);
    }
}
