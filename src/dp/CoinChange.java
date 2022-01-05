package dp;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }
    public static int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int[][] dp = new int[m+1][amount +1];

        for(int i=0; i<=m; i++) {
            dp[i][0] = 0;
        }

        for(int j = 1; j<= amount; j++) {
            dp[0][j] = (int)1e5;
        }

        for(int i=1; i<=m; i++) {
            for(int j = 1; j<= amount; j++) {

                if(coins[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                }

                else {
                    dp[i][j] = Math.min(1+dp[i][j-coins[i-1]], dp[i-1][j]);
                }
            }
        }

        return dp[m][amount]>=(int)1e5 ?-1:dp[m][amount];
    }
}
