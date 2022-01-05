package dp;

//Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
//        You have the following three operations permitted on a word:
//        Insert a character
//        Delete a character
//        Replace a character
public class EditDistance {

    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";

        System.out.println(minDistance(word1, word2));
    }

    public static int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m+1][n+1];

        // for(int i=0; i<= m; i++) {
        //     dp[i][0] = dp[0][i] = i;
        // }

        for(int i=0; i<=m; i++) {
            for(int j = 0; j <= n; j++) {

                if(i==0) {
                    dp[i][j] = j;
                }

                else if(j==0) {
                    dp[i][j] = i;
                }
                else {
                    if(word1.charAt(i-1) == word2.charAt(j-1)) {
                        dp[i][j] = dp[i-1][j-1];
                    }
                    else {
                        dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1]                                                 [j]))+1;
                    }
                }
            }
        }

        return dp[m][n];
    }
}
