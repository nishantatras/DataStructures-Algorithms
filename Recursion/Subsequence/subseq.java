import java.util.ArrayList;
public class subseq{

    public static void main(String[] args) {
        // ArrayList<String> arr1=new ArrayList<String>();
        // StringSubsets("","abc", arr1);
        // System.out.println(arr1);

        // int x[]={1,2,3};
        // ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        // SubsetsItr(x,res);
        // System.out.println(res);
        // String ans=removeAString("", "abcbaa");
        // System.out.println(ans);

        // String ans=removeB("abcbcbdbebcbe");
        // System.out.println(ans);

        // String res=removeThe("hellotheworld");
        // System.out.println(res);
        
        // subseq("", "abc");
        // ArrayList<String> res=subseqRet("","abc");
        // System.out.println(res);

        // aciiseq("","abc");
        ArrayList<String> ascii=asciiRet("","abc");
        System.out.println(ascii);
     }
 
    public static void sub(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        sub(p + ch, up.substring(1));
        sub(p, up.substring(1));
    }

    public static void aciiseq(String p, String up) {  if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        aciiseq(p + ch, up.substring(1));
        aciiseq(p, up.substring(1));
        aciiseq(p+ (ch+0), up.substring(1));
    }
    
    public static ArrayList<String> asciiRet(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);
        ArrayList<String> one = asciiRet(p + ch, up.substring(1));
        ArrayList<String> two = asciiRet(p, up.substring(1));
        ArrayList<String> three = asciiRet(p+(ch+0), up.substring(1));

        one.addAll(two);
        one.addAll(three);
        return one;
    }

    public static ArrayList<String> subseqRet(String p, String up) {
        if (up.isEmpty()) {
        ArrayList<String> list=new ArrayList<>();
        list.add(p);
        return list;
        }

       char ch = up.charAt(0);
        ArrayList<String> left=subseqRet(p + ch, up. substring(1));
        ArrayList<String> right =subseqRet(p, up.substring(1));

        left.addAll(right);
        return left;
    }

    public static void StringSubsets(String p, String up, ArrayList<String> arr) {
        if (up.isEmpty()) {
            arr.add(p);
            return;
        }
        char ch = up.charAt(0);
        StringSubsets(p + ch, up.substring(1), arr);
        StringSubsets(p, up.substring(1), arr);
    }

    // public static void Subsets(ArrayList<Integer> p, ArrayList<Integer> up,
    // ArrayList<ArrayList<Integer>> arr) {
    // if (up.isEmpty()) {
    // arr.add(p);
    // return;
    // }
    // int c= up.get(0);
    // Subsets(p.add(c), up.subList(1,up.size()), arr);
    // Subsets(p, up.subList(1,up.size()), arr);
    // }

 
    public static void removeA(String p, String up) {
        if (up.length() == 0) {
            System.out.println(p);
            return;
        }
        if (up.charAt(0) == 'a') {
            removeA(p, up.substring(1));
        } else {
            removeA(p + up.charAt(0), up.substring(1));
        }
    }

    //Error
    // public static void removeThe(String p, String up) {
    //     if (up.length() == 0) {
    //         System.out.println(p);
    //         return;
    //     }
    //     if (up.startsWith("the")) {
    //         removeThe(p, up.substring(3));
    //     } else {
    //         removeA(p + up.charAt(0), up.substring(1));
    //     }
    // }

    public static String removeThe(String up) {
        if (up.length() == 0) {
            return "";
        }
        if (up.startsWith("the")) {
            return removeThe(up.substring(3));
        } else {
            return up.charAt(0)+removeThe(up.substring(1));
        }
    }

    public static String removeAString(String p, String up) {
        if (up.length() == 0) {
            // System.out.println(p);
            return p;
        }
        if (up.charAt(0) == 'a') {
            return removeAString(p, up.substring(1));
        } else {
            return removeAString(p + up.charAt(0), up.substring(1));
        }
    }

    public static String removeB(String st) {
        if (st.length() == 0) {
            return "";
        }

        if (st.charAt(0) == 'b') {
            return removeB(st.substring(1));
        } else {
            return st.charAt(0) + removeB(st.substring(1));
        }
    }
}