package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumWODuplicates {

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);

        combSum(0, target, candidates, ans, new ArrayList<>());

        return ans;
    }

    static void combSum(int ind, int target, int[] arr, List<List<Integer>> ans, List<Integer> l) {

        if(target == 0) {
            ans.add(new ArrayList<>(l));
            return;
        }



        for(int i = ind; i < arr.length; i++) {
            if(ind!=i && arr[i] == arr[i-1]) continue;

            if(arr[i] <= target) {
                l.add(arr[i]);
                combSum(i+1, target - arr[i],arr,  ans, l);
                l.remove(l.size()-1);
            }
            else break;
        }

        // combSum(ind+1, target,arr, ans, l);
    }
}
