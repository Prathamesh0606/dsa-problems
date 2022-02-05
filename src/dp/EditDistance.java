package dp;

//Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
//        You have the following three operations permitted on a word:
//        Insert a character
//        Delete a character
//        Replace a character
public class EditDistance {

    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";

        System.out.println(edit(word1, word2, 0, 0));
    }

    //recursive
    static int edit(String s1, String s2, int i, int j) {
        if(i == s1.length()) return s2.length()-j;

        if(j == s2.length()) return s1.length()-i;

        if(s1.charAt(i) == s2.charAt(j)) {
            return edit(s1, s2, i+1, j+1);
        }

        int insert = 1 + edit(s1, s2, i, j+1);
        int delete = 1 + edit(s1, s2, i+1, j);
        int replace = 1 + edit(s1, s2, i+1, j+1);

        return Math.min(insert, Math.min(delete, replace));
    }

    //memoized recursive
    static int edit(String s1, String s2, int i, int j, int[][] dp) {
        if(i == s1.length()) return s2.length()-j;

        if(j == s2.length()) return s1.length()-i;

        if(dp[i][j]!=-1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = edit(s1, s2, i+1, j+1, dp);
        }

        int insert = 1 + edit(s1, s2, i, j+1, dp);
        int delete = 1 + edit(s1, s2, i+1, j, dp);
        int replace = 1 + edit(s1, s2, i+1, j+1, dp);

        return dp[i][j] = Math.min(insert, Math.min(delete, replace));
    }

    //tabulated dp
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
