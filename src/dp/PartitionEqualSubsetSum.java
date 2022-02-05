package dp;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

    //tabular
    public boolean canPartitionTab(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i:nums)
            sum += i;

        if(sum%2 != 0) return false;

        boolean[][] dp = new boolean[n][sum/2+1];
        for(int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if(nums[0] <= sum/2) dp[0][nums[0]] = true;

        for(int i=1; i < n; i++) {
            for(int j = 1; j <= sum/2; j++) {
                boolean dontPick = dp[i-1][j];
                boolean pick = false;
                if(j >= nums[i]) pick = dp[i-1][j - nums[i]];

                dp[i][j] = dontPick | pick;
            }
        }

        return dp[n-1][sum/2];
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i : nums)
            sum += i;

        if (sum % 2 != 0) return false;

        int[][] dp = new int[n][sum / 2 + 1];
        for (int[] i : dp)
            Arrays.fill(i, -1);

        return subsumMem(n - 1, sum / 2, nums, dp);
    }

    //memoized
    boolean subsumMem(int i, int target, int[] arr, int[][] dp) {
        if (target == 0) return true;

        if (i == 0) return arr[i] == target;

        if (dp[i][target] != -1) return dp[i][target] == 1;

        boolean dontPick = subsumMem(i - 1, target, arr, dp);
        boolean pick = false;
        if (target >= arr[i]) {
            pick = subsumMem(i - 1, target - arr[i], arr, dp);
        }

        boolean b = pick | dontPick;
        if (b) dp[i][target] = 1;
        else dp[i][target] = 0;

        return b;
    }

    //recursive
    boolean subsum(int i, int target, int[] arr) {
        if (target == 0) return true;

        if (i == 0) return arr[i] == target;

        boolean dontPick = subsum(i - 1, target, arr);
        boolean pick = false;
        if (target >= arr[i]) {
            pick = subsum(i - 1, target - arr[i], arr);
        }
        boolean b = pick | dontPick;
        return b;
    }
}
