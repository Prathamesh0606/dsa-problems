package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumIncreasingSubseq {

    public static void main(String[] args) {
        int N = 5;
        int arr[] = {1, 101, 2, 3, 100};
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(101);
        list.add(2);
        list.add(3);
        list.add(100);

        //ans = 106
        System.out.println(maxSumIS(arr, arr.length));
    }

    //memoized
//    public static int maxIncreasingDumbbellsSum(ArrayList<Integer> rack, int n) {
//        // Write your code here.
//        int[] dp = new int[rack.size()];
//
//        Arrays.fill(dp, -1);
////        dp[0] = rack.get(0);
//        int ans =  solve(rack, 0, Integer.MIN_VALUE,0, dp);
////        for (int i:
////             dp) {
////            System.out.println(dp);
////        }
//
//        return ans;
//    }
//
//    static int solve(ArrayList<Integer>rack, int i,int prev, int sum, int[] dp) {
//        if(i == rack.size()) {
//            return sum;
//        }
//
//        if(dp[i]!=-1 ) {
//            System.out.println(i + ": " + dp[i]);
//            return dp[i];
//        }
//        int incl = sum;
//        if(rack.get(i) > prev) {
//            incl = solve(rack, i+1, rack.get(i), sum + rack.get(i), dp);
//        }
//        int excl = solve(rack, i+1, prev, sum, dp);
//        return dp[i] = Math.max(incl, excl);
//    }
    //recursive
    static int solve(ArrayList<Integer> rack, int i, int prev, int sum) {
        if(i == rack.size()) {
            return sum;
        }

        int incl = sum;
        if(rack.get(i) > prev) {
            incl = solve(rack, i+1, rack.get(i), sum + rack.get(i));
        }
        int excl = solve(rack, i+1, prev, sum);
        return Math.max(incl, excl);
    }

    //tabulated dp
    public static int maxSumIS(int arr[], int n)
    {
        //code here.
        int[] dp = new int[n];

        for(int i=0; i<n; i++) dp[i] = arr[i];

        for(int i=1; i<n; i++) {
            for(int j=0; j<i; j++) {

                if(arr[i]>arr[j] && dp[i]<arr[i]+dp[j]) {
                    dp[i] = arr[i]+dp[j];
                }
            }
        }
        int max = 0;

        for(int i=0; i<n; i++) {
            if(max < dp[i])
                max = dp[i];
        }

        return max;
    }
}
