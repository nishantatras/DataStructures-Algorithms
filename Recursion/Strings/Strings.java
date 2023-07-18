package Strings;

public class Strings {
    public static void main(String[] args) {
    String st="abcdfbasbabdabadsdba";
    // char r='a';
    // System.out.println(skip(st, r));
    skip("", st);
    }


    static void skip(String p,String up){
    // if(s.length()==0){
    // return "";
    // }
    // if(s.charAt(0)!=remove){
    // return ""+skip(s.substring(1),remove)+s.charAt(0);    
    // }
    // return ""+skip(s.substring(1),remove);
    if(up.isEmpty()){
    System.out.println(p);
    return ;
    }

    char ch=up.charAt(0);
    if(ch=='a'){
    skip(p, up.substring(1));
    }
    skip(p+ch, up.substring(1));
    }
}