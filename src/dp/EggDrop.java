package dp;

import java.util.Arrays;

public class EggDrop {
    private static int[][] dp;
    public static void main(String[] args) {
        int f = 4, e = 2;
        dp = new int[e+1][f+1];
        for(int[] i:dp)
         Arrays.fill(i, -1);

        System.out.println(solve(f, e));
        System.out.println(solveDP(e, f));
    }

    static int solveDP(int e, int f) {
        if(f==0 || f==1) return f;

        if(e==1) return f;

        if(dp[e][f]!=-1) return dp[e][f];

        int mi = Integer.MAX_VALUE;
        for(int k=1; k<=f; k++) {
            int ans1 = dp[e-1][k-1]!=-1?dp[e-1][k-1]:solveDP(e-1, k-1);

            int ans2 = dp[e][f-k]!=-1?dp[e][f-k]:solveDP(e, f-k);
            int temp = 1+Math.max(ans1, ans2);

            mi = Math.min(mi, temp);
            //return mi;
            //System.out.println(min);
        }

        return dp[e][f] = mi;
    }


    //recursive inefficient
    static int solve(int f, int e) {
        if(f==0 || f==1) return f;

        if(e==1) return f;
        int mi = Integer.MAX_VALUE;
        for(int k=1; k<=f; k++) {
            int temp = 1+Math.max(solve(k-1, e-1), solve(f-k, e));

            mi = Math.min(mi, temp);
            //return mi;
            //System.out.println(min);
        }

        return mi;
    }
}
