package dp;

public class LongestIncreasingSubSequence {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};

        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = 1;

        for(int i=1; i<n; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j]+1;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=0; i<dp.length; i++) {
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
