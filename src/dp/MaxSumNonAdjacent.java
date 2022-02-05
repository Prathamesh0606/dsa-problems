package dp;

//Given an array of ‘N’  positive integers, we need to return the maximum sum of the subsequence such that no two elements
//  of the subsequence are adjacent elements in the array.

import java.util.ArrayList;
import java.util.Arrays;

public class MaxSumNonAdjacent {
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        // Write your code here.
        int n = nums.size();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return adjSumTabSO(n, nums);
    }

    //memoized approach
    static int adjSum(int n, ArrayList<Integer> nums, int[] dp) {
        if(n == 0) return dp[n] = nums.get(n);

        if(n < 0) return 0;

        if(dp[n]!=-1) return dp[n];

        int pick = nums.get(n) + adjSum(n-2, nums, dp);
        int notPick = adjSum(n - 1, nums, dp);
        return dp[n] = Math.max(pick, notPick);
    }

    //tabular
    static int adjSumTab(int n, ArrayList<Integer> nums) {
        int[] dp = new int[n];
        dp[0] = nums.get(0);

        for(int i=1; i<n; i++) {

            int pick = nums.get(i) + ((i>1)?dp[i-2]:0);
            int notPick = dp[i-1];

            dp[i] = Math.max(pick, notPick);
        }
        return dp[n-1];
    }

    //space optimized Time O(n), space O(1)
    static int adjSumTabSO(int n, ArrayList<Integer> nums) {
        int[] dp = new int[n];
        int im1 = nums.get(0);
        int im2 = 0;
        int curi = 0;
        for(int i=1; i<n; i++) {
            int pick = nums.get(i) + ((i>1)?im2:0);
            int notPick = im1;

            curi = Math.max(pick, notPick);
            im2 = im1;
            im1 = curi;

        }
        return im1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(1);
        nums.add(4);
        nums.add(9);


        System.out.println(maximumNonAdjacentSum(nums));
    }
}
