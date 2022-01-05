package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsumWithoutDuplicates {

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(subsetsWithDup(nums));
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        subsets(nums, new ArrayList<>(), ans, 0);

        return ans;
    }

   static void subsets(int[] arr, ArrayList<Integer> l,  List<List<Integer>> ans, int idx) {
        ans.add(new ArrayList<>(l));

        for(int i = idx; i < arr.length; i++) {
            if(i!=idx && arr[i]==arr[i-1]) continue;
            l.add(arr[i]);
            subsets(arr, l, ans, i+1);
            l.remove(l.size()-1);
        }
    }
}
