package recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;

        System.out.println(combinationSum(candidates, target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        combSum2(0, target, candidates, ans, new ArrayList<>());

        return ans;
    }

    static void combSum(int ind, int target, int[] arr, List<List<Integer>> ans, List<Integer> l) {
        if(ind == arr.length) {
            if(target == 0) {
                ans.add(new ArrayList<>(l));
            }
            return;
        }

        if(arr[ind] <= target) {
            l.add(arr[ind]);
            combSum(ind, target - arr[ind],arr,  ans, l);
            l.remove(l.size()-1);
        }

        combSum(ind+1, target,arr, ans, l);
    }

    static void combSum2(int ind, int target, int[] arr, List<List<Integer>> ans, List<Integer> l) {
        if(ind == arr.length) {
            if(target == 0) {
                ans.add(new ArrayList<>(l));
            }
            return;
        }

        for(int i=ind; i<arr.length; i++) {
            if(i!=ind && arr[i]==arr[i-1]) continue;
            if(arr[i] <= target) {
                l.add(arr[i]);
                combSum2(i, target - arr[i],arr,  ans, l);
                l.remove(l.size()-1);
            }
            combSum2(i+1, target,arr,  ans, l);

        }
        //combSum2(ind+1, target,arr,  ans, l);
//        if(arr[ind] <= target) {
//            l.add(arr[ind]);
//            combSum(ind, target - arr[ind],arr,  ans, l);
//            l.remove(l.size()-1);
//        }

        //combSum(ind+1, target,arr, ans, l);
    }
}
