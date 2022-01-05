package recursion;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib(7));
    }

    static long fib(int n) {
        if(n==0) return 1;
        if(n==1) return 1;

        return fib(n-1)+fib(n-2);
    }
}
