package binarysearch;

public class NthRoot {
    public static void main(String[] args) {
        int n = 3;
        int m = 27;

        System.out.println(nthRoot(n, m));
    }

    static double multiply(double num, int n) {
        double ans = 1.0;

        for(int i=1; i<=n; i++) {
            ans*=num;
        }
        return ans;
    }

    static double nthRoot(int n, int m) {
        double low = 1;
        double hi = m;
        double eps = 1e-6;

        while((hi-low)>eps) {
            double mid = low + (hi-low)/2.0;

            if(multiply(mid, n) < m) low = mid;
            else if(multiply(mid, n) > m) hi = mid;
           else return mid;
        }

        return low;
    }

}
