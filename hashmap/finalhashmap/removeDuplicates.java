package finalhashmap;
import java.util.ArrayList;
import java.util.HashMap;

public class removeDuplicates {
    public static void main(String[] args) {
        int arr[] ={1,3,2,2,3,1,6,2,5};
        ArrayList<Integer> op = removeduplicates(arr);
        System.out.println(op);
    }

    public static ArrayList<Integer> removeduplicates(int[] arr){
     ArrayList<Integer> res = new ArrayList<>();
     HashMap<Integer,Boolean> map = new HashMap<>();

     for(int i = 0; i < arr.length ; i++){
        if(map.containsKey(arr[i])){
           continue;
        }
        else{
            map.put(arr[i],true);
            res.add(arr[i]);
        }
     }
      return res;
    }
}
