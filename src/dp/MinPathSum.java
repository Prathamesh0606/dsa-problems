package dp;

public class MinPathSum {

    public static void main(String[] args) {
       int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};

        System.out.println(minPathSum(grid));
    }
    public static int minPathSum(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];

        return solve(grid, dp);
    }

    static int solve(int[][] grid, int[][] dp) {
        dp[0][0] = grid[0][0];

        for(int i=1; i<grid.length; i++) {
            dp[i][0] = grid[i][0]+dp[i-1][0];
        }

        for(int j=1; j<grid[0].length; j++) {
            dp[0][j] = grid[0][j]+dp[0][j-1];
        }

        for(int i=1; i<grid.length; i++) {
            for(int j=1; j<grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+grid[i][j];
                //System.out.print(dp[i][j]+" ");
            }
            //System.out.println();
        }

        return dp[grid.length-1][grid[0].length-1];
    }
}
