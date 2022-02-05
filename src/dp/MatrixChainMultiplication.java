package dp;

import java.util.Arrays;

public class MatrixChainMultiplication {

    //memoized dp
    public static int matrixMultiplication(int[] arr , int N) {
        // Write your code here
        int[][] dp = new int[N][N];
        for(int[] i:dp)
            Arrays.fill(i, -1);
        return mcm(1, N-1, arr, dp);
    }

    static int mcm(int i, int j, int[] arr, int[][] dp) {
        if(i == j) return 0;

        int min = Integer.MAX_VALUE;
        if(dp[i][j] != -1) return dp[i][j];
        for(int k=i; k<j; k++) {
            int cnt = mcm(i, k, arr, dp) + mcm(k+1,j, arr, dp) + arr[i-1] *arr[k] * arr[j];
            min = Math.min(min, cnt);
        }
        return dp[i][j] = min;
    }
}
