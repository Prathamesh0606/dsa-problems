package dp;

import java.util.Arrays;

public class DecodeWays {

    //recursive
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        return solve(0, n, s);
    }

    int solve(int i, int n, String s) {
        if(i == n ) {
            return 1;
        }

        int cnt = 0;
        int d = s.charAt(i) - '0';
        int dd = 0;

//        if(dp[i] != -1) return dp[i];
        if(d > 0) cnt += solve(i+1, n, s);
        if(i+1 < n) dd = (s.charAt(i)-'0') * 10 + s.charAt(i+1) - '0';
        if(dd>=10 && dd <= 26) cnt += solve(i+2, n, s);

        return cnt;
    }

    //memoized
    public int numDecodingsDP(String s) {
        int n = s.length();
        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        return solve(0, n, s, dp);
    }

    int solve(int i, int n, String s, int[] dp) {
        if(i == n ) {
            return 1;
        }

        int cnt = 0;
        int d = s.charAt(i) - '0';
        int dd = 0;

        if(dp[i] != -1) return dp[i];
        if(d > 0) cnt += solve(i+1, n, s, dp);
        if(i+1 < n) dd = (s.charAt(i)-'0') * 10 + s.charAt(i+1) - '0';
        if(dd>=10 && dd <= 26) cnt += solve(i+2, n, s, dp);

        return dp[i] = cnt;
    }
}
