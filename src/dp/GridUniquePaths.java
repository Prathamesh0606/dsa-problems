package dp;

import java.util.ArrayList;
import java.util.Arrays;

public class GridUniquePaths {

    public static void main(String[] args) {
        int m = 3, n = 3;
        System.out.println(uniquePaths(m, n));
    }
    public static int uniquePaths(int m, int n) {
        // Write your code here.
        int[][] dp = new int[m][n];
        for(int[] i:dp)
            Arrays.fill(i, -1);

        return pathsTabOP(m, n);
    }

    //recursive
    static int paths(int i, int j) {
        if(i == 0 && j == 0) return 1;

        if(i < 0 || j < 0) return 0;

        return paths(i-1, j) + paths(i, j-1);
    }

    //memoized
    static int paths(int i, int j, int[][] dp) {
        if(i == 0 && j == 0) return dp[i][j] = 1;

        if(i < 0 || j < 0) return dp[i][j] = 0;

        if(dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = paths(i-1, j) + paths(i, j-1);
    }

    //tabulation
    static int pathsTab(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i == 0 && j == 0) dp[i][j] = 1;
                else {
                    int up = 0, left = 0;
                    if (i > 0) up = dp[i - 1][j];
                    if (j > 0) left = dp[i][j - 1];

                    dp[i][j] = up + left;
                }
            }
        }

        return dp[m-1][n-1];
    }

    //space optimized tabulation space(O(n))
    static int pathsTabOP(int m, int n) {
        int[] dp = new int[m];
        int[] temp = new int[n];
        dp[0] = 1;
        for(int i=0; i<m; i++) {
            temp = new int[n];
            for(int j=0; j<n; j++) {
                int up = 0, left = 0;
                if(i == 0 && j == 0) temp[j] = 1;
                else {
                   if(i>0) up =  dp[j];
                   if(j>0) left = temp[j-1];

                   temp[j] = up + left;
                }

            }
            dp = temp;
        }

        return temp[n-1];
    }
}
