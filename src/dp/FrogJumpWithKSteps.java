package dp;

import java.util.Arrays;

public class FrogJumpWithKSteps {

    public static void main(String[] args) {
        int[] arr = {40, 10, 20, 70, 80, 10, 20, 70, 80, 60};
        int k = 4;
        System.out.println(frogJumpK(arr.length-1, k, arr));
    }
    public static int frogJumpK(int n, int k, int heights[]) {

        // Write your code here..
        int[] dp = new int[n ];
        Arrays.fill(dp, -1);
        //dp[0] = 0;
        return jumpK(n-1 ,k, heights, dp);
    }

    static int jumpK(int n, int k, int[] arr, int[] dp) {
        if (n == 0) return 0;

        if (dp[n] != -1) return dp[n];

        int right = Integer.MAX_VALUE;

        for(int i=1; i<=k; i++) {
            if(n-i>=0) {
                int left = Math.abs(arr[n] - arr[n - i]) + jumpK(n - i,k, arr, dp);
                right = Math.min(right, left);
            }
        }

        return dp[n] = right;
    }
}
