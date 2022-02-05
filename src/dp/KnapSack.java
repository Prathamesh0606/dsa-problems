package dp;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.max;

public class KnapSack {

    public static void main(String[] args) {
        int n = 3;
        int w = 4;

//        int[] values = {5, 4, 8, 6};
//        int[] weights = {1, 2, 4 ,5};

        int[] values = { 1,2,3 };
        int[] weights = { 4,5,1};
        int[][] dp = new int[w+1][n];
        for (int i[]:dp)
            Arrays.fill(i, -1);
        System.out.println(knapSack(weights, values, w, n-1, dp));
    }

    //working memoized approach
    static int knapSack(int[] weights, int[] values, int maxWeight, int idx, int[][] dp) {
        if (maxWeight < 0) {
            return Integer.MIN_VALUE;
        }

        if(0 > idx || maxWeight == 0) {
            return 0;
        }

        if(dp[maxWeight][idx]!=-1) return dp[maxWeight][idx];

        int with = Integer.MIN_VALUE;
        if(weights[idx] <= maxWeight) {
            with = values[idx]+knapSack(weights, values, maxWeight - weights[idx], idx-1, dp);
        }

        int without = knapSack(weights, values, maxWeight, idx-1, dp);

       // System.out.println("idx : " +idx + " weight: "+maxWeight +" with: "+with + " without: "+without);
        return dp[maxWeight][idx] = Math.max(without, with);
    }

    //recursive inefficient
    static int knapSack(int[] weights, int[] values, int maxWeight, int idx, int currVal) {
        if(values.length == idx || maxWeight == 0) {
            return currVal;
        }


        int with = Integer.MIN_VALUE;
        if(weights[idx] <= maxWeight) {
            with = knapSack(weights, values, maxWeight - weights[idx], idx+1, currVal+values[idx]);
        }

        int without = knapSack(weights, values, maxWeight, idx+1, currVal);

        System.out.println("idx : " +idx + " weight: "+maxWeight +" with: "+with + " without: "+without);
        return max(without, with);
    }




}
