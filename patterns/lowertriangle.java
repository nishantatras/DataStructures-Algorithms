import java.util.*;
public class lowertriangle {
    public static void main(String[] args) {
    Scanner s= new Scanner(System.in);
    System.out.println("Enter the number of rows");
    int r = s.nextInt();
    System.out.println("Enter the number of columns");
    int c = s.nextInt();
    // pattern_1(r, c);
    // pattern_2(r, c);
    // pattern_3(r, c);
    // pattern_4(r, c);
    pattern_5(r, c);
    s.close();
    }

    public static void pattern_1(int r , int c){
    int i=1;
    while(i <= r){
        int j=1; 
            while(j <= i){
                System.out.print(j+" ");
                j++;
            }
        System.out.println();
        i++;
        // 1 
        // 1 2 
        // 1 2 3 
        // 1 2 3 4 
    }
    }
    public static void pattern_2(int r , int c){
    int i=1;
    while(i <= r){
        int j=1; 
            while(j <= i){
                System.out.print(i+" ");
                j++;
            }
        System.out.println();
        i++;
    }
    // 1 
    // 2 2 
    // 3 3 3 
    // 4 4 4 4 
    }

     public static void pattern_3(int r , int c){
    int i=1;
    while(i <= r){
        int j=1; 
            while(j <= i){
                System.out.print((i+j-1)+" ");
                j++;
            }
        System.out.println();
        i++;
    }
    // 1 
    // 2 3 
    // 3 4 5 
    // 4 5 6 7 
    }

     public static void pattern_4(int r , int c){
    int i=1,val=1;
    while(i <= r){
        int j=1; 
            while(j <= i){
                System.out.print(val+" ");
                j++;
                val++;
            }
        System.out.println();
        i++;
    }
    // 1 
    // 2 3 
    // 4 5 6 
    // 7 8 9 10 
    }

    public static void pattern_5(int r , int c){
    int i=1;
    while(i <= r){
        int j=1; 
            while(j <= i){
                System.out.print(i-j+1+" ");
                j++;
            }
        System.out.println();
        i++;
    }
    // 1 
    // 2 1 
    // 3 2 1 
    // 4 3 2 1 
    }
}
