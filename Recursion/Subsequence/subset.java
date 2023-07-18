import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class subset {
    public static void main(String[] args) {
    // int[] arr={1,2,2};
    // List<List<Integer>> ans=SubsetsItrd(arr);
    // System.out.println(ans);

    
    // List<List<Integer>> subset = new ArrayList<>();
    // // Input ArrayList
    // ArrayList<Integer> input = new ArrayList<>();
    // input.add(1);
    // input.add(2);
    // input.add(3);

    // findSubsets(subset, input, new ArrayList<>(), 0);
    // System.out.println(subset);

}
//??????????????????????Recursively finding subsets
    // public static void findSubsets(List<List<Integer>> subset, ArrayList<Integer> nums, ArrayList<Integer> output,
    //         int index) {
    //     // Base Condition
    //     if (index == nums.size()) {
    //         subset.add(output);
    //         return;
    //     }

    //     // Not Including Value which is at Index
    //     findSubsets(subset, nums, new ArrayList<>(output), index + 1);

    //     // Including Value which is at Index
    //     output.add(nums.get(index));
    //     findSubsets(subset, nums, new ArrayList<>(output), index + 1);
    // }
    
    public static List<List<Integer>> SubsetsItr(int[] arr) {
    List<List<Integer>> outer= new  ArrayList<>();
    outer.add(new ArrayList<>());

        for (int num : arr) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                //internal is copy of prev outer
                List<Integer> internal = new ArrayList<Integer>(outer.get(i));
                //adding elm at i to each elm of copy of outer
                internal.add(num);
                //outer is updated with new elms of internal
                outer.add(internal);
            }
        }
        return outer;
    }

    public static List<List<Integer>> SubsetsItrd(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int s=0,e=0;
        for (int i=0; i<arr.length; i++) {
            s=0;
            if( i>0 && arr[i]==arr[i-1]){
            s=e+1;
            }
            e=outer.size()-1;
            int n = outer.size();
            for (int j = s; j < n; j++) {
                // internal is copy of prev outer
                List<Integer> internal = new ArrayList<Integer>(outer.get(j));
                // adding elm at i to each elm of copy of outer
                internal.add(arr[i]);
                // outer is updated with new elms of internal
                outer.add(internal);
            }
        }
        return outer;
    }

  
    
    // public static List<List<Integer>> subsetRet(List<Integer> p,List<Integer> up) {
    //     if (up.isEmpty()){
    //         ArrayList<String> list = new ArrayList<>();
    //         list.add(p);
    //         return list;
    //     }

    //     List<List<Integer>> l = subsetRet(p.add(up.remove(0)), up);
    //     List<List<Integer>> r = subsetRet(p, up.remove(0));
    //     l.add(r);
    //     return arr;
    // }
}
