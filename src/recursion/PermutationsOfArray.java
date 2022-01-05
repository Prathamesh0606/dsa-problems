package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsOfArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        //System.out.println(permute(nums));
        String str = "abc";

        System.out.println(permuteStr(str));

    }


    //permutations of array
    public static List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        permute(ans,new ArrayList<>(),nums);
        return ans;
    }

    public static void permute(ArrayList<List<Integer>> ans,ArrayList<Integer> l,int[] nums) {
        if(l.size()==nums.length) {
            ans.add(new ArrayList<>(l));
            return;
        }

        for(int i=0;i<nums.length;i++) {
            if(l.contains(nums[i])) continue;

            l.add(nums[i]);
            permute(ans,l,nums);
            l.remove(l.size()-1);
        }
    }


    //permutations of string
    public static List<String> permuteStr(String nums) {
        boolean[] vis = new boolean[nums.length()];
        ArrayList<String> ans = new ArrayList<>();
        permuteString(ans,"",nums, vis);
        return ans;
    }

    public static void permuteString(ArrayList<String> ans,String l,String nums, boolean[] vis) {
        if(l.length()==nums.length()) {
            ans.add(l);
            return;
        }

        for(int i=0;i<nums.length();i++) {
            //if(l.contains(nums.charAt(i))) continue;
            if(!vis[i]) {
                vis[i] = true;
                l = l+nums.charAt(i);
                permuteString(ans, l, nums, vis);
                l = new StringBuilder(l).deleteCharAt(l.length()-1).toString();
                vis[i] = false;
            }
//            l.add(nums[i]);
//            permute(ans,l,nums);
//            l.remove(l.size()-1);
        }
    }
}
