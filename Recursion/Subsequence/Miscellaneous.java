
import java.util.ArrayList;
import java.util.List;

public  class Miscellaneous {
 public static void main(String[] args) {
    // pad("", "12");
    // List<String> res=padret("","123");
    // System.out.println(res);
    // System.out.println(padcount("", "123"));
    // dice("",4);

    // List<String> res=diceret("",10);
    // System.out.println(res); 

    // diceFace("", 8, 8);

    List<String> res=diceFaceret("",4,5);
    System.out.println(res);
 }   

 static void dice(String p,int target){
 if(target==0){
 System.out.println(p);
 return;
 }

 for(int i=1; i<=6 && i<=target; i++){
 dice(p+i, target-i);
 } 
 }

 static void diceFace(String p, int target,int face) {
     if (target == 0) {
         System.out.println(p);
         return;
     }

     for (int i = 1; i <= face && i <= target; i++) {
         dice(p + i, target - i);
     }
 }

 static List<String> diceFaceret(String p, int target,int face) {
     if (target == 0) {
         List<String> list = new ArrayList<>();
         list.add(p);
         return list;
     }
     List<String> res = new ArrayList<String>();
     for (int i = 1; i <= face && i <= target; i++) {
         res.addAll(diceFaceret(p + i, target - i,face));
     }
     return res;
 }

 static List<String> diceret(String p, int target) {
     if (target == 0) {
         List<String> list = new ArrayList<>();
         list.add(p);
         return list;
     }
     List<String> res = new ArrayList<String>();
     for (int i = 1; i <= 6 && i <= target; i++) {
         res.addAll(diceret(p + i, target - i));
     }
     return res;
 }

 static void pad(String p,String up){
 if(up.isEmpty()){
    System.out.println(p);
    return;
 }
 int d= up.charAt(0)-'0';
 for(int i=(d-1)*3; i<d*3; i++){
   char ch=(char)('a'+i);
   pad(p+ch, up.substring(1));
 }
 }

 static List<String> padret(String p, String up) {
     if (up.isEmpty()) {
         List<String> list=new ArrayList<>();
         list.add(p);
         return list;
     }

     List<String> res = new ArrayList<>();
     int d = up.charAt(0) - '0';
     for (int i = (d - 1) * 3; i < d * 3; i++) {
         char ch = (char) ('a' + i);
        res.addAll(padret(p + ch, up.substring(1)));
     }
     return res;
 }

 public static int padcount(String p, String up) {
     if (up.isEmpty()) {
         return 1;
     }
     int count = 0;
     int d = up.charAt(0) - '0';
     for (int i = (d - 1) * 3; i < d * 3; i++) {
         char ch = (char) ('a' + i);
         count=count+padcount(p + ch, up.substring(1));
     }
     return count;
 }
}
