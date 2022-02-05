package dp;


//Ninja has a 'GRID' of size 'R' X 'C'. Each cell of the grid contains some chocolates. Ninja has two friends Alice and Bob,
//        and he wants to collect as many chocolates as possible with the help of his friends.Initially, Alice is in the
//        top-left position i.e. (0, 0), and Bob is in the top-right place i.e. (0, ‘C’ - 1) in the grid. Each of them can
//        move from their current cell to the cells just below them. When anyone passes from any cell, he will pick all
//        chocolates in it, and then the number of chocolates in that cell will become zero. If both stay in the same cell,
//        only one of them will pick the chocolates in it.If Alice or Bob is at (i, j) then they can move to (i + 1, j),
//        (i + 1, j - 1) or (i + 1, j + 1). They will always stay inside the ‘GRID’.
//        Your task is to find the maximum number of chocolates Ninja can collect with the help of his friends by following
//        the above rules.

import java.util.Arrays;

public class NinjaAndHisFriends {

    //space optimized dp
    public static int maximumChocolatesSO(int r, int c, int[][] grid) {
        // Write your code here.
        int[][][] dp = new int[r][c][c];
        int[][] front = new int[c][c];
        int[][] curr = new int[c][c];

        for(int j1 = 0; j1 < c; j1++) {
            for(int j2 = 0; j2 < c; j2++) {
                if(j1 == j2) front[j1][j2] = grid[r-1][j1];
                else front[j1][j2] = grid[r-1][j1] + grid[r-1][j2];
            }
        }

        for(int i = r-2; i>=0; i--) {
            curr = new int[c][c];
            for(int j1 = 0; j1 < c; j1++) {
                for(int j2 = 0; j2 < c; j2++) {
                    int mx = (int)-1e8;
                    for(int dj1 = -1; dj1 <= 1; dj1++) {
                        for(int dj2 = -1; dj2 <= 1; dj2++) {
                            int val = 0;
                            if(j1 == j2)
                                val = grid[i][j2];
                            else val = grid[i][j1] + grid[i][j2];
                            if(dj1+j1>= 0 && dj1+j1 < c && dj2+j2 >= 0 && dj2+j2 < c)
                                val += front[dj1+j1][dj2+j2];
                            else val += (int) -1e8;
                            mx = Math.max(mx, val);
                        }
                    }
                    curr[j1][j2] = mx;
                }
            }
            front = curr;
        }
        return front[0][c-1];
    }

    //tabulated dp
    public static int maximumChocolatesTab(int r, int c, int[][] grid) {
        // Write your code here.
        int[][][] dp = new int[r][c][c];

        for(int j1 = 0; j1 < c; j1++) {
            for(int j2 = 0; j2 < c; j2++) {
                if(j1 == j2) dp[r-1][j1][j2] = grid[r-1][j1];
                else dp[r-1][j1][j2] = grid[r-1][j1] + grid[r-1][j2];
            }
        }

        for(int i = r-2; i>=0; i--) {
            for(int j1 = 0; j1 < c; j1++) {
                for(int j2 = 0; j2 < c; j2++) {
                    int mx = (int)-1e8;
                    for(int dj1 = -1; dj1 <= 1; dj1++) {
                        for(int dj2 = -1; dj2 <= 1; dj2++) {
                            int val = 0;
                            if(j1 == j2)
                                val = grid[i][j2];
                            else val = grid[i][j1] + grid[i][j2];
                            if(dj1+j1>= 0 && dj1+j1 < c && dj2+j2 >= 0 && dj2+j2 < c)
                                val += dp[i+1][dj1+j1][dj2+j2];
                            else val += (int) -1e8;
                            mx = Math.max(mx, val);
                        }
                    }
                    dp[i][j1][j2] = mx;
                }
            }
        }
        return dp[0][0][c-1];
    }


    //memoized dp
    public static int maximumChocolatesMemo(int r, int c, int[][] grid) {
        // Write your code here.
        int[][][] dp = new int[r][c][c];

        for(int i[][]: dp) {
            for(int[] j:i) {
                Arrays.fill(j, -1);
            }
        }
        return solve(0, 0, c-1, r, c, grid, dp);
    }

    static int solve(int i, int j1, int j2, int r, int c, int[][] grid, int[][][] dp) {
        if(j1 < 0 || j2 < 0 || j1 >= c || j2 >= c ) {
            return (int) -1e8;
        }
        if(i == r-1) {
            if(j1 == j2) return grid[i][j2];

            else return grid[i][j1] + grid[i][j2];
        }

        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];

        int mx = (int)-1e8;
        for(int dj1 = -1; dj1 <= 1; dj1++) {
            for(int dj2 = -1; dj2 <= 1; dj2++) {
                int val = 0;
                if(j1 == j2)
                    val = grid[i][j2];
                else val = grid[i][j1] + grid[i][j2];
                val += solve(i+1, dj1+j1, dj2+j2, r, c, grid, dp);

                mx = Math.max(mx, val);
            }
        }
        return dp[i][j1][j2] = mx;
    }

    //recursive
    public static int maximumChocolates(int r, int c, int[][] grid) {
        // Write your code here.
        int[][][] dp = new int[r][c][c];
        return solve(0, 0, c-1, r, c, grid);
    }

    static int solve(int i, int j1, int j2, int r, int c, int[][] grid) {
        if(j1 < 0 || j2 < 0 || j1 >= c || j2 >= c ) {
            return (int) -1e8;
        }
        if(i == r-1) {
            if(j1 == j2) return grid[i][j2];

            else return grid[i][j1] + grid[i][j2];
        }

        int mx = (int)-1e8;
        for(int dj1 = -1; dj1 <= 1; dj1++) {
            for(int dj2 = -1; dj2 <= 1; dj2++) {
                int val = 0;
                if(j1 == j2)
                    val = grid[i][j2];
                else val = grid[i][j1] + grid[i][j2];
                val += solve(i+1, dj1+j1, dj2+j2, r, c, grid);

                mx = Math.max(mx, val);
            }
        }
        return mx;
    }
}
