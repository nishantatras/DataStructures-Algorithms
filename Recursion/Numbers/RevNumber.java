package Numbers;
public class RevNumber{
    static int sum=0;
    public static void revnum(int n){
    if(n==0){
    return;
    }  
     int rev=n%10;
     sum=sum*10+rev;
     revnum(n/10);
    }

    public static int revnums(int n){
    int d=(int)Math.log10(n)+1;
    return helper(n, d);
    }

    public static int helper(int n,int d){
    if(n%10==n){
    return n;
    }
    int rem=n%10;
    return rem*(int)(Math.pow(10,d-1))+helper(n/10, d-1);
    }
    //n-   13213 1321 132 13 1 0
    //n%10- 3     1    2   3 1 
    public static void main(String[] args) {
    int x=13213;
    // revnum(x);
    // System.out.println(sum);
    System.out.println(revnums(x));
    }
}