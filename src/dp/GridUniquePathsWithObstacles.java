package dp;

import java.util.Arrays;

public class GridUniquePathsWithObstacles {

    public static void main(String[] args) {

    }
    //backtracking solution, gives TLE
//    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        int m = obstacleGrid.length;
//        int n = obstacleGrid[0].length;
//        int[][] dp = new int[m][n];
//        Arrays.fill(dp, -1);
//        dp[0][0] = 1;
//
//        if(obstacleGrid[0][0]==0)
//        return paths(obstacleGrid, dp, 0, 0, m, n);
//        return 0;
//    }
//
//    static int paths(int[][] grid, int[][] visited, int i, int j, int r, int c) {
//        if(i == r-1 && j == c-1 && grid[i][j]==0) {
//            return 1;
//        }
//
//        int d = 0;
//        int rr = 0;
//
//        if(grid[i][j] == 0) {
//            if(i+1<r && visited[i+1][j] == 0 && grid[i+1][j] == 0) {
//                visited[i][j] = 1;
//                d = paths(grid, visited, i+1, j, r, c);
//                visited[i][j] = 0;
//            }
//
//
//            if(j+1<c && visited[i][j+1] == 0 && grid[i][j+1] == 0) {
//                visited[i][j] = 1;
//                rr = paths(grid, visited, i, j+1, r, c);
//                visited[i][j] = 0;
//            }
//        }
//
//        return rr+d;
//    }

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
}
