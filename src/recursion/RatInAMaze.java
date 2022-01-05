package recursion;

import java.util.ArrayList;

public class RatInAMaze {

    public static void main(String[] args) {
        int m[][] = {{1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}};
        int N = 4;
        System.out.println(findPath(m, N));
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        int[][] visited = new int[n][n];
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = 0;
            }
        }
        if (m[0][0] == 1) solve(0, 0, m, visited, n, ans, "");
        return ans;
    }


    static void solve(int i, int j, int[][] m, int[][] visited, int n, ArrayList<String> ans, String s) {

        if (i == n - 1 && j == n - 1) {
            ans.add(s);
            return;
        }

        //down
        if (i + 1 < n && visited[i + 1][j] == 0 && m[i + 1][j] == 1) {
            visited[i][j] = 1;
            solve(i + 1, j, m, visited, n, ans, s + 'D');
            visited[i][j] = 0;
        }

        //left
        if (j - 1 >= 0 && visited[i][j - 1] == 0 && m[i][j - 1] == 1) {
            visited[i][j] = 1;
            solve(i, j - 1, m, visited, n, ans, s + 'L');
            visited[i][j] = 0;
        }

        //right
        if (j + 1 < n && visited[i][j + 1] == 0 && m[i][j + 1] == 1) {
            visited[i][j] = 1;
            solve(i, j + 1, m, visited, n, ans, s + 'R');
            visited[i][j] = 0;
        }

        //up
        if (i - 1 >= 0 && visited[i - 1][j] == 0 && m[i - 1][j] == 1) {
            visited[i][j] = 1;
            solve(i - 1, j, m, visited, n, ans, s + 'U');
            visited[i][j] = 0;
        }

    }
}
