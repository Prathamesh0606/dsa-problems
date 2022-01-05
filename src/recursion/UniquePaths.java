package recursion;

public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePathsOP(3,3));
    }

    //bruteforce recursive
    public static int uniquePaths(int m, int n) {

        if(m==1 || n==1) return 1;

        return uniquePaths(m-1, n)+uniquePaths(m, n-1);
    }

    //optimized
    public static int uniquePathsOP(int m, int n) {
        int N = m+n-2;
        int r = m-1;
        double ans = 1;
        for(int i=1; i<=r; i++) {
            ans = ans*(N-r+i)/i;
        }

        return (int)ans;
    }
}
