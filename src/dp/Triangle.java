package dp;


//You are given a triangular array/list 'TRIANGLE'. Your task is to return the minimum path sum to reach from the top to the bottom row.
//        The triangle array will have N rows and the i-th row, where 0 <= i < N will have i + 1 elements.
//        You can move only to the adjacent number of row below each step. For example, if you are at index j in row i,
//        then you can move to i or i + 1 index in row j + 1 in each step.

public class Triangle {
    public static void main(String[] args) {

    }

//    public static int minimumPathSum(int[][] triangle, int n) {
//        // Write your code here.
//        return solve(triangle, n, 0, 0);
//    }

    //recursive
    static int solve(int[][] arr, int n, int i, int j) {
        if(i == n-1) return arr[i][j];

        int d = arr[i][j] + solve(arr, n, i+1, j);
        int diag = arr[i][j] + solve(arr, n, i+1, j+1);

        return Math.min(d, diag);
    }

    //tabulated
    public static int minimumPathSum(int[][] triangle, int n) {
        // Write your code here.
        int dp[][] = new int[n][n];

        for(int i=0; i<n; i++) {
            dp[n-1][i] = triangle[n-1][i];
        }

        for(int i=n-2; i>=0; i--) {
            for(int j=i; j>=0; j--) {
                int d = triangle[i][j] + dp[i+1][j];
                int diag = triangle[i][j] + dp[i+1][j+1];
                dp[i][j] = Math.min(d, diag);
            }
        }
        return dp[0][0];
//         return solve(triangle, n, 0, 0);
    }

    //space optimized tabulation with O(2n) space instead of O(n2)
    public static int minimumPathSumOP(int[][] triangle, int n) {
        // Write your code here.
        int dp[][] = new int[n][n];

        for(int i=0; i<n; i++) {
            dp[n-1][i] = triangle[n-1][i];
        }
        int[] front = new int[n-1];
        front = triangle[n-1];
        for(int i=n-2; i>=0; i--) {
            int[] curr = new int[i+1];
            for(int j=i; j>=0; j--) {
                int d = triangle[i][j] + front[j];
                int diag = triangle[i][j] + front[j+1];
                curr[j] = Math.min(d, diag);
            }

            front = curr;
        }
        return front[0];
    }
}
