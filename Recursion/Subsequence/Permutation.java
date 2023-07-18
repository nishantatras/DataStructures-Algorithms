import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) {
        String up = "123";
        // ArrayList<String> arr = new ArrayList<String>();
        // Permutations("", up, arr);
        // System.out.println(arr);

        // int count = NumberofPermutations("", up);
        // System.out.println(count);
        ArrayList<String> res=Permutationslist("",up);
        System.out.println(res);
    }

    public static ArrayList<String> Permutationslist(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();

        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            ans.addAll(Permutationslist(f + ch + s, up.substring(1)));
        }
        return ans;
    }

    public static void Permutations(String p,String up,ArrayList<String> arr){
    if(up.isEmpty()){
    arr.add(p);
    return; 
    } 
     
    char ch=up.charAt(0);
    for(int i=0; i<=p.length(); i++){
    String f=p.substring(0, i);
    String s= p.substring(i,p.length());
    Permutations(f+ch+s, up.substring(1), arr);
    }
    }

    
    public static int NumberofPermutations(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }
        int count=0;
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            count=count+ NumberofPermutations(f + ch + s, up.substring(1));
        }
        return count;
    }
}

