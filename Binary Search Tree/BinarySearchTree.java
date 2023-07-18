import java.util.*;
public class BinarySearchTree{
    static Scanner s = new Scanner(System.in);
    //O(N)
    public static BinaryTreeNode<Integer> takeInputBST(boolean isroot,boolean isleft,int parent) {
        if (isroot) {
            System.out.println("Enter the root data");
        } else {
            if (isleft) {
                System.out.println("Enter the left child of " + parent);
            } else {
                System.out.println("Enter the right child of " + parent);
            }
        }
        // Scanner s = new Scanner(System.in);
        int rootdata = s.nextInt();
         if (rootdata == -1) {
            return null;
        }
        if(!isroot){
        while(isleft && rootdata > parent ){
            System.out.println("Left BinaryTreeNode<Integer> must be less than parent BinaryTreeNode<Integer>");
            System.out.println("Enter the left child of " + parent+" again");
            rootdata=s.nextInt();
        }
        while(!isleft && rootdata < parent){
            System.out.println("Right BinaryTreeNode<Integer> must be greater than parent BinaryTreeNode<Integer>");
            System.out.println("Enter the right child of " + parent + " again");
            rootdata =s.nextInt();
        }
    }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootdata);
        BinaryTreeNode<Integer> left = takeInput(false,true, rootdata);
        BinaryTreeNode<Integer> right = takeInput(false, false, rootdata);
        root.left = left;
        root.right = right;
        return root;
    }

    //O(N)
    public static BinaryTreeNode<Integer> takeInput(boolean isroot, boolean isleft, int parent) {
        if (isroot) {
            System.out.println("Enter the root data");
        } else {
            if (isleft) {
                System.out.println("Enter the left child of " + parent);
            } else {
                System.out.println("Enter the right child of " + parent);
            }
        }
        // Scanner s = new Scanner(System.in);
        int rootdata = s.nextInt();
        if (rootdata == -1) {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootdata);
        BinaryTreeNode<Integer> left = takeInput(false, true, rootdata);
        BinaryTreeNode<Integer> right = takeInput(false, false, rootdata);
        root.left = left;
        root.right = right;
        return root;
    }

    //O(N)
    public static void inorder(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    //best Case O(H)-BalancedTree
    // Worst Case O(N)-Skew tree
    public static boolean search(BinaryTreeNode<Integer> root,int target){
        if(root==null){
            return false;
        }

        if (root.data > target) {
            return search(root.left, target);
        }
        else if(root.data < target) {
            return search(root.right, target);
        }
        else{
            return true;
        }
    }

    //O(N) WORST case
    public static void searchinRange(BinaryTreeNode<Integer> root, int ll,int ul) {
        if (root == null) {
            return;
        }

        if (root.data < ll) {
            searchinRange(root.right,ll,ul);
        } else if (root.data > ul) {
            searchinRange(root.left,ll,ul);
        } else {
            System.out.print(root.data+" ");
            searchinRange(root.right,ll,ul);
            searchinRange(root.left,ll,ul);
        }
    }

    //O(N)
    public static BinaryTreeNode<Integer> buildBST(int[] arr,int si,int ei){
        if(si > ei){
        return null;
        }
        int mid=(si+ei)/2;
        BinaryTreeNode<Integer> root =new BinaryTreeNode<Integer>(arr[mid]);
        root.left = buildBST(arr, si, mid-1);
        root.right = buildBST(arr, mid+1, ei);
        return root;
    }
    
    public static int maximumofBST(BinaryTreeNode<Integer> root) {
        if (root.right != null) {
            return maximumofBST(root.right);
        } else {
            return root.data;
        }
    }

    public static int minimumofBST(BinaryTreeNode<Integer> root) {
        if (root.left != null) {
            return minimumofBST(root.left);
        } else {
            return root.data;
        }
    }

    public static boolean isBST(BinaryTreeNode<Integer> root){
       if(root == null){
        return true;
       }  
       int leftMax=maximum(root.left);
       if(leftMax >= root.data){
          return false;
       }
       int rightMin = minimum(root.right);
       if(rightMin < root.data){
          return false;
       }
       
       boolean isleft = isBST(root.left);
       boolean isright = isBST(root.right);
       return isleft&&isright;
    }

    public static int maximum(BinaryTreeNode<Integer> root){
        if(root==null){
            return Integer.MIN_VALUE;
        }
        int leftMax = maximum(root.left);
        int rightMax = maximum(root.right);
        return Math.max(root.data,Math.max(leftMax, rightMax));
    }

    public static int minimum(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int leftMin = minimum(root.left);
        int rightMin = minimum(root.right);
        return Math.min(root.data,Math.min(leftMin, rightMin));
    }

    public static IsBSTReturn isBST2(BinaryTreeNode<Integer> root) {
        if (root == null) {
            IsBSTReturn ans = new IsBSTReturn(Integer.MAX_VALUE,Integer.MIN_VALUE,true);
            return ans;
        }
        IsBSTReturn leftAns= isBST2(root.left);
        IsBSTReturn rightAns= isBST2(root.right);

        int min=Math.min(root.data, Math.min(leftAns.min,rightAns.min));
        int max = Math.max(root.data, Math.max(leftAns.max, rightAns.max));
         boolean isBST = true;
         if(leftAns.max >= root.data){
            isBST = false;
         }
         if (rightAns.min < root.data) {
             isBST = false;
         }
         if(!leftAns.isBST){
            isBST = false;
         }
         if (!rightAns.isBST) {
             isBST = false;
         }
        
         IsBSTReturn ans = new IsBSTReturn(min, max, isBST);
         return ans;
    }

    public static boolean isBST3(BinaryTreeNode<Integer> root,int minRange,int maxRange){
        if(root==null){
            return true;
        }
        if(root.data < minRange ||root.data >maxRange){
            return false;
        }

        boolean isLeftWithinRange = isBST3(root.left,minRange,root.data -1);
        boolean isRightWithinRange = isBST3(root.right,root.data+1,maxRange);
        
        return isLeftWithinRange&&isRightWithinRange;
    }

    public static int RelaceWithSum(BinaryTreeNode<Integer> root,int sum){
    if(root ==null){
        return sum;
    }
    sum = RelaceWithSum(root.right,sum);
    sum += root.data;
    root.data = sum;
    sum = RelaceWithSum(root.left,sum);
     return sum;
    }

    public static ArrayList<Integer> PathToNode(BinaryTreeNode<Integer> root,int x){
        if(root ==null){
            return null;
        }

        if(root.data == x){
           ArrayList<Integer> res = new ArrayList<>();
           res.add(x);
           return res;
        }

            ArrayList<Integer> left = PathToNode(root.left,x);
            if (left != null) {
                left.add(root.data);
                return left;
            }
            ArrayList<Integer> right = PathToNode(root.right, x);
            if (right != null) {
                right.add(root.data);
                return right;
            }
        return null;
    }

    
  
    public static void main(String[] args) 
    {
    //  BinaryTreeNode<Integer> root = takeInput(true,true,0);

    //  inorder(root);
    //  System.out.println(search(root,5));
    //  searchinRange(root, 10, 20);

    // int arr[]={1,2,3,4,5,6,7};
    // Arrays.sort(arr);
    // BinaryTreeNode<Integer> root = buildBST(arr,0,arr.length-1);
    // inorder(root);
    // System.out.println();
    // System.out.println(minimumofBST(root));
    // System.out.println(maximumofBST(root));

    // BinaryTreeNode<Integer> root = takeInput(true,true, 0);
    // inorder(root);

    // BinaryTreeNode<Integer> root =takeInput(true, false, 0);
    // IsBSTReturn res = isBST2(root);
    // System.out.println(res.isBST+" "+res.max+" "+res.min);

    // BinaryTreeNode<Integer> root = takeInput(true, false, 0);
    // boolean res = isBST3(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    // System.out.println(res);
    // inorder(root);

    // BinaryTreeNode<Integer> root =takeInputBST(true, false, 0);
    // RelaceWithSum(root, 0);
    // inorder(root);


    // int arr[] ={1,2,3,4,5,6,7,8};
    // BinaryTreeNode<Integer> root =buildBST(arr, 0, 7);
    // ArrayList<Integer> path = PathToBinaryTreeNode<Integer>(root,7);
    // System.out.println(path);


    }
}