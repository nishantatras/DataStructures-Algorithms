public class BST {

    private BinaryTreeNode<Integer> root;
    private int size;

    public boolean isPresent(int x){
        return isPresentHelper(root, x);
    }

    //Independent of Bst object
    private static boolean isPresentHelper(BinaryTreeNode<Integer> root,int x){
       if(root ==null){
        return false;
       }
       if (root.data == x) {
           return true;
       }

       if (x < root.data) {
           return isPresentHelper(root.left,x);
       } else {
           return isPresentHelper(root.right,x);
       }
    }

    public void insert(int x){
    root = insertHelper(root, x);
    size++;
    }

    private static BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> root,int x){
     if(root == null){
        BinaryTreeNode<Integer> newRoot = new BinaryTreeNode<Integer>(x);
        return newRoot;
     } 
     if(x >= root.data){
        root.right =insertHelper(root.right, x);
     }
     if (x < root.data) {
         root.left = insertHelper(root.left, x);
     }
     return root;
    }


    public boolean deleteData(int x){
    BSTDeleteReturn obj= deleteDataHelper(root, x); 
    root = obj.root;

    if(obj.deleted){
    size--;
    }
    return obj.deleted;
    }

    private BSTDeleteReturn deleteDataHelper(BinaryTreeNode<Integer> root, int x){
        if(root == null){
            return new BSTDeleteReturn(null, false);
        }

        if(root.data < x){
            BSTDeleteReturn Objright = deleteDataHelper(root.right, x);
            root.right = Objright.root;
            Objright.root =root;
            return Objright;
        }


        if (root.data > x) {
            BSTDeleteReturn Objleft = deleteDataHelper(root.left, x);
            root.left = Objleft.root;
            Objleft.root = root;
            return Objleft;
        }

        if(root.left == null && root.right == null){
            return new BSTDeleteReturn(null, true);
        }
        if (root.left != null && root.right == null) {
            return new BSTDeleteReturn(root.left, true);
        }
        if (root.left == null && root.right != null) {
            return new BSTDeleteReturn(root.right, true);
        }

        int rightMin = minimum(root.right);
        root.data = rightMin;
        BSTDeleteReturn objRight = deleteDataHelper(root.right, rightMin);
        root.right = objRight.root;

    return new BSTDeleteReturn(root,true);
    } 

    public static int minimum(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int leftMin = minimum(root.left);
        int rightMin = minimum(root.right);
        return Math.min(root.data, Math.min(leftMin, rightMin));
    }

    public int size(){
        return size;
    }

    public void printTree(){
    printTreeHelper(root);
    }

    private static void printTreeHelper(BinaryTreeNode<Integer> root){
    if(root == null){
        return ;
    }

    System.out.print(root.data + ":");
    if(root.left != null){
        System.out.print("L "+ root.left.data+ ",");
    }
    if (root.right != null) {
        System.out.print("R " + root.right.data);
    }
    System.out.println();
    printTreeHelper(root.left);
    printTreeHelper(root.right);
    }
}
