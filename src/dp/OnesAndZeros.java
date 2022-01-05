package dp;

public class OnesAndZeros {

    public static void main(String[] args) {
        String[] strs = {"10","0001","111001","1","0"};
        int m = 5, n = 3;

        System.out.println(findMaxForm(strs, m, n));
    }
    public static int findMaxForm(String[] strs, int m, int n) {

        int[][] dp = new int[m+1][n+1];
        for(String str:strs) {
            int[] cnt = cnt0and1(str);

            for(int zero=m; zero>=cnt[0]; zero--) {
                for(int one = n; one >= cnt[1]; one--) {
                    dp[zero][one] = Math.max(dp[zero - cnt[0]][one - cnt[1]]+1, dp[zero][one]);
                }
            }
        }

        return dp[m][n];
    }

    static int[] cnt0and1(String str) {
        int[] cnt = new int[2];
        for (char c:str.toCharArray()) {
            cnt[c-'0']++;
        }
        return cnt;
    }
}
