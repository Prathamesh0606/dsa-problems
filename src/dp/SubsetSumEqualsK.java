package dp;

import java.util.Arrays;

public class SubsetSumEqualsK {

    //tabulated
    public static boolean subsetSumToKTab(int n, int k, int[] arr){
        // Write your code here.
        boolean[][] dp = new boolean[n][k+1];
        for(int i=0; i<n; i++) {
            dp[i][0] = true;
        }
        for(int i=1; i<n; i++) {
            for(int j=1; j<=k; j++) {
                boolean take = false;
                if( arr[i]<=j)
                    take =  dp[i-1][j-arr[i]];
                boolean not_take = dp[i-1][j];
                dp[i][j] = (take | not_take);
            }
        }
        return dp[n-1][k];
    }

    public static boolean subsetSumToK(int n, int k, int[] arr){
        // Write your code here.
        boolean[][] dp = new boolean[n][k+1];

        for(int i=0; i<n; i++) {
            dp[i][0] = true;
        }

        for(int i=1; i<n; i++) {
            for(int j=1; j<=k; j++) {
                boolean take = false;
                if( arr[i]<=k)
                    take =  dp[i-1][ k-arr[i]];
                boolean not_take = dp[i-1][k];
                boolean b = (take | not_take);
                dp[i][j] = b;
            }
        }

        return dp[n-1][k];
    }


    //memoized
    static boolean existsDP(int i, int k, int n, int[] arr, int[][] dp) {
        if(k == 0) return true;
        if(i == 0) return arr[0] == k;
        if(dp[i][k] != -1) return dp[i][k] == 1;

        boolean take = false;
        if( arr[i]<=k)
            take =  existsDP(i-1, k-arr[i], n, arr, dp);
        boolean not_take = existsDP(i-1, k, n, arr, dp);
        boolean b = (take | not_take);

        if(b) dp[i][k] = 1;
        else dp[i][k] = 0;
        return b;
    }

    //recursive
    static boolean exists(int i, int k, int n, int[] arr) {
        if(k == 0) return true;
        if(i == 0) return arr[0] == k;

        boolean take = false;
        if( arr[i]<=k)
            take =  exists(i-1, k-arr[i], n, arr);
        boolean not_take = exists(i-1, k, n, arr);
        boolean b = (take | not_take);
        return b;
    }
}
