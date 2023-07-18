import java.util.*;
public class charpatterns {
    public static void main(String[] args) {
    Scanner s= new Scanner(System.in);
    System.out.println("Enter the number of rows");
    int r = s.nextInt();
    System.out.println("Enter the number of columns");
    int c = s.nextInt();
    pattern_1(r, c);
    // pattern_2(r, c);
    // pattern_3(r, c);
    // pattern_4(r, c);
    s.close();
    }

    public static void pattern_1(int r , int c){
        int i=1;
        while(i <= r){
            int j=1;
            while(j <= c){
            System.out.print((char)('A'+j-1)+" ");
            j++;
            }
        System.out.println();
        i++;
        }
        // A B C D 
        // A B C D 
        // A B C D 
        // A B C D 
    } 

     public static void pattern_2(int r , int c){
        int i=1;
        while(i <= r){
            int j=1;
            while(j <= c){
            System.out.print((char)('A'+i-1)+" ");
            j++;
            }
        System.out.println();
        i++;
        }
        // A A A A 
        // B B B B 
        // C C C C 
        // D D D D 
    }
}
