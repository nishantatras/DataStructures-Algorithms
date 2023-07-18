import java.util.*;
public class traingle {
    public static void main(String[] args) {
    Scanner s= new Scanner(System.in);
    System.out.println("Enter the number of rows");
    int r = s.nextInt();
    System.out.println("Enter the number of columns");
    int c = s.nextInt();
    // llt(r, c);
    // lrt(r, c);
    // ult(r, c);
    // urt(r, c);
    // pyramid(r,c);
    // Revpyramid(r, c);
    s.close();
    }

     public static void Revpyramid(int r,int c){
        int i=1; 
        while(i<=r){
           int k=1; 
           while(k<=i-1){
            System.out.print(" ");
            k++;
           }
           int j=2*(r-i)+1;
           while(j>=1){
            System.out.print("*");
            j--;
           }
           System.out.println();
           i++;
        }
    } 

    public static void pyramid(int r,int c){
     int i = 1; 
     while(i <= r){
        int k = r-i;
        while(k >= 1){
        System.out.print(" ");
        k--;
     }
        int j = 1;
        while(j <= 2*i-1){
        System.out.print("*");
        j++;
     }
     System.out.println();
     i++;
    } 
    } 

    public static void llt(int r,int c){
     int i = 1; 
     while(i <= r){
        int j = 1;
        while(j <= i){
        System.out.print("* ");
        j++;
     }
     System.out.println();
     i++;
    } 
    }  

    public static void lrt(int r,int c){
     int i = 1; 
     while(i <= r){
        int k = r-i;
        while(k >= 1){
        System.out.print(" ");
        k--;
     }
        int j = 1;
        while(j <= i){
        System.out.print("*");
        j++;
     }
     System.out.println();
     i++;
    } 
    } 

     public static void ult(int r,int c){
     int i = 1; 
     while(i <= r){
        // int j = 1;
        // while(j <= r-i+1){
        // System.out.print("*");
        // j++;
        int j = r;
        while(j >= i){
        System.out.print("*");
        j--;
     }
     System.out.println();
     i++;
    } 
    } 

    public static void urt(int r,int c){
     int i = 1; 
     while(i <= r){
        int k = 1;
        while(k <= i-1){
        System.out.print(" ");
        k++;
     }
        int j = r-i+1;
        while(j >= 1){
        System.out.print("*");
        j--;
     }
     System.out.println();
     i++;
    } 
    }    
}
