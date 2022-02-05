package dp;

import java.util.Arrays;

public class CountWaysToClimbStairs {
    public static int countDistinctWayToClimbStair(long nStairs) {
        // Write your code here.
        int n = (int)nStairs;
        int[] dp = new int[n+1];

        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        return stairs(n, dp);

    }

    static int stairs(int idx , int[] dp) {
        if(idx == 0 || idx == 1) {
            return 1;
        }
        if(dp[idx]!=-1) return dp[idx];

        return dp[idx] = stairs(idx-1, dp)+stairs(idx-2, dp);
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(countDistinctWayToClimbStair(n));
    }
}
