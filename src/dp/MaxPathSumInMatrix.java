package dp;

import java.util.Arrays;

public class MaxPathSumInMatrix {
    public static void main(String[] args) {
        int m = 4, n = 4;
        int[][] grid = {{1, 2, 10, 4},{100, 3, 2 ,1},{1, 1, 20, 2},{1, 2, 2, 1}};
        System.out.println(getMaxPathSum(grid));
    }

    //space optimized dp
    public static int getMaxPathSumSO(int[][] matrix) {
        // Write your code here
        int m = matrix.length;
        int n = matrix[0].length;

        int mx = Integer.MIN_VALUE;
        int[][] dp = new int[m][n];
        int[] prev = new int[n];
        int[] curr = new int[n];
        for(int j=0;j<n; j++) {
            prev[j] = matrix[0][j];
        }
        for(int i=1; i<m; i++) {
            curr = new int[n];
            for(int j=0; j<n; j++) {
                int u = matrix[i][j] + prev[j];
                int ld = matrix[i][j];
                if(j-1 >= 0) ld += prev[j-1];
                else ld+=(int) -1e8;
                int rd = matrix[i][j];
                if(j+1 < n) rd += prev[j+1];
                else rd+= (int) -1e8;
                curr[j] = Math.max(mx, Math.max(u, Math.max(ld, rd)));

            }
            prev = curr;
        }

        for(int i=0; i<n; i++) {
            mx = Math.max(mx, prev[i]);
        }
        return mx;
    }

    //recursive
    public static int getMaxPathSum(int[][] matrix) {
        // Write your code here
        int m = matrix.length;
        int n = matrix[0].length;

        int mx = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            mx = Math.max(mx, path(matrix, m-1, i));
        }
        return mx;
    }

    static int path(int[][] arr, int i, int j) {
        if(j < 0 || j >= arr[0].length) return (int) -1e8;
        if(i == 0) return arr[i][j];


        int u = arr[i][j] + path(arr, i-1, j);
        int ld = arr[i][j] + path(arr, i-1, j-1);
        int rd = arr[i][j] + path(arr, i-1, j+1);

        return Math.max(u, Math.max(ld, rd));
    }

    //memoized dp
    public static int getMaxPathSumDP(int[][] matrix) {
        // Write your code here
        int m = matrix.length;
        int n = matrix[0].length;

        int mx = Integer.MIN_VALUE;
        int[][] dp = new int[m][n];
        for(int [] i: dp)
            Arrays.fill(i, -1);
        for(int i=0; i<n; i++) {
            mx = Math.max(mx, path(matrix, m-1, i, dp));
        }
        return mx;
    }

    static int path(int[][] arr, int i, int j, int[][] dp) {
        if(j < 0 || j >= arr[0].length) return (int) -1e8;
        if(i == 0) return arr[i][j];

        if(dp[i][j]!=-1) return dp[i][j];
        int u = arr[i][j] + path(arr, i-1, j, dp);
        int ld = arr[i][j] + path(arr, i-1, j-1, dp);
        int rd = arr[i][j] + path(arr, i-1, j+1, dp);

        return dp[i][j] = Math.max(u, Math.max(ld, rd));
    }

    //tabulated dp
    public static int getMaxPathSumTab(int[][] matrix) {
        // Write your code here
        int m = matrix.length;
        int n = matrix[0].length;

        int mx = Integer.MIN_VALUE;
        int[][] dp = new int[m][n];

        for(int j=0;j<n; j++) {
            dp[0][j] = matrix[0][j];
        }
        for(int i=1; i<m; i++) {
            for(int j=0; j<n; j++) {

                int u = matrix[i][j] + dp[i-1][j];
                int ld = matrix[i][j];
                if(j-1 >= 0) ld += dp[i-1][j-1];
                else ld+=(int) -1e8;
                int rd = matrix[i][j];
                if(j+1 < n) rd += dp[i-1][j+1];
                else rd+= (int) -1e8;
                dp[i][j] = Math.max(mx, Math.max(u, Math.max(ld, rd)));

            }
        }

        for(int i=0; i<n; i++) {
            mx = Math.max(mx, dp[m-1][i]);
        }
        return mx;
    }

}
