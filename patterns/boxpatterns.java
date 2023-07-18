import java.util.*;

public class boxpatterns{
    public static void main(String[] args) {
    Scanner s= new Scanner(System.in);
    System.out.println("Enter the number of rows");
    int r = s.nextInt();
    System.out.println("Enter the number of columns");
    int c = s.nextInt();
    pattern_1(r, c);
    pattern_2(r, c);
    pattern_3(r, c);
    pattern_4(r, c);
    s.close();
    }

         public static void pattern_4(int r , int c){
        // for(int i = 1; i <= r; i++){
        //     for(int j = 1; j <= c; j++){
        //     System.out.print(i+j-1+" ");
        // }
        // System.out.println();
        // }
 
        int i=1;
        while(i <= r){
            int j=1; 
            while(j <= c){
            System.out.print((i+j-1)+" ");
            j++;
            }
        System.out.println();
        i++;
        }
        // 1 2 3 4 5 
        // 2 3 4 5 6 
        // 3 4 5 6 7 
        // 4 5 6 7 8 
        // 5 6 7 8 9
        }


     public static void pattern_3(int r , int c){
        // for(int i = 0; i < r; i++){
        //     for(int j = 0; j < c; j++){
        //     System.out.print(i*r+1+" ");
        // }
        // System.out.println();
        // }
 
        int i=0;
        while(i < r){
            int j=0; 
            while(j < c){
            System.out.print((r*i+j+1)+" ");
            j++;
            }
        System.out.println();
        i++;
        }
        // 1 2 3 4 5 
        // 6 7 8 9 10 
        // 11 12 13 14 15 
        // 16 17 18 19 20 
        // 21 22 23 24 25 
        }

      public static void pattern_2(int r , int c){
        // for(int i = 1; i <= r; i++){
        //     for(int j = 1; j <= c; j++){
        //     System.out.print(i+" ");
        // }
        // System.out.println();
        // }

        int i=1;
        while(i <= r){
            int j=1; 
            while(j <= c){
            System.out.print(i+" ");
            j++;
            }
        System.out.println();
        i++;
        }
  
        // 1 1 1 1 1 
        // 2 2 2 2 2 
        // 3 3 3 3 3 
        // 4 4 4 4 4 
        // 5 5 5 5 5 
        }
    
    public static void pattern_1(int r , int c){
        // for(int i = 1; i <= r; i++){
        //     for(int j = 1; j <= c; j++){
        //     System.out.print(j+" ");
        // }
        // System.out.println();
        // }

        int i=1;
        while(i <= r){
            int j=1; 
            while(j <= c){
            System.out.print(j+" ");
            j++;
            }
        System.out.println();
        i++;
        }
        // 1 2 3 4 5 
        // 1 2 3 4 5 
        // 1 2 3 4 5 
        // 1 2 3 4 5 
        // 1 2 3 4 5
    } 
}