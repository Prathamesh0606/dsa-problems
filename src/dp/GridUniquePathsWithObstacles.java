package dp;

import java.util.Arrays;

public class GridUniquePathsWithObstacles {

    public static void main(String[] args) {

    }
    //backtracking solution, gives TLE


    //dp solution
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int[] arr: dp)
            Arrays.fill(arr, -1);


        if(obstacleGrid[0][0]==0)
            return dpPaths(obstacleGrid, dp, 0, 0, m, n);
        return 0;
    }

    //memoized
    static int dpPaths(int[][] grid, int[][] dp, int i, int j, int r, int c) {
        if(i>=r || j >= c || grid[i][j] == 1) return 0;

        if(i == r-1 && j == c-1) {
            return dp[i][j] = 1;
        }
        if(dp[i][j] != -1) return dp[i][j];

        int rr = 0, d = 0;
        d = dpPaths(grid, dp,i+1, j, r, c);
        rr = dpPaths(grid, dp, i, j+1, r, c);
        return dp[i][j] = rr+d;

    }

    //tabulated dp
    static int dpPathsTab(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if (grid[i][j] == -1) dp[i][j] = 0;

                else if (i == 0 && j == 0) dp[i][j] = 1;

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
}
