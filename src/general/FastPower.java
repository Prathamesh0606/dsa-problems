package general;

public class FastPower {
    public static void main(String[] args) {
        System.out.println(myPow(4,10));
    }

    public static double myPow(double x, int n) {
        double ans = 1.0;
        long nn = n;

        if(nn<0) nn = -1 * nn;

        while(nn>0) {
            if(nn%2==0) {
                nn/=2;
                x=x*x;
            } else {
                nn=nn-1;
                ans = ans*x;
            }
        }

        if(n<0) return (double) 1/(double)ans;
        else return ans;
    }
}
