package dp;

import java.util.Arrays;

public class FrogJump {


    //memoized dp
    public static int frogJump(int n, int heights[]) {

        // Write your code here..
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        return jump(n - 1, heights, dp);
    }

    static int jump(int n, int[] arr, int[] dp) {
        if (n == 0) return 0;

        if (dp[n] != -1) return dp[n];
        int left = Math.abs(arr[n] - arr[n - 1]) + jump(n - 1, arr, dp);

        int right = Integer.MAX_VALUE;
        if (n > 1) {
            right = Math.abs(arr[n] - arr[n - 2]) + jump(n - 2, arr, dp);
        }

        return dp[n] = Math.min(left, right);
    }

    //tabular dp
    public static int frogJumpTab(int n, int heights[]) {
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int ind = 1; ind < n; ind++) {
            int jumpTwo = Integer.MAX_VALUE;
            int jumpOne = dp[ind - 1] + Math.abs(heights[ind] - heights[ind - 1]);
            if (ind > 1)
                jumpTwo = dp[ind - 2] + Math.abs(heights[ind] - heights[ind - 2]);

            dp[ind] = Math.min(jumpOne, jumpTwo);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int height[]={30,10,60,10,60,50};
        int n=height.length;
        System.out.println(frogJumpTab(n, height));
    }
}
