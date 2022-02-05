package dp;

//Mr. X is a professional robber planning to rob houses along a street. Each house has a certain amount of money hidden.
//        All houses along this street are arranged in a circle. That means the first house is the neighbor of the last one.
//        Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two
//        adjacent houses were broken into on the same night. You are given an array/list of non-negative integers 'ARR'
//        representing the amount of money of each house. Your task is to return the maximum amount of money Mr. X can rob
//        tonight without alerting the police.

import java.util.ArrayList;

public class HouseRobber {

    //space optimized Time O(n), space O(1)
    public static long houseRobber(int[] valueInHouse) {
        // Write your code here.
        int n = valueInHouse.length;
        ArrayList<Integer> temp1 = new ArrayList<>();
        ArrayList<Integer> temp2 = new ArrayList<>();
        if(n == 1) return valueInHouse[0];
        for(int i=0; i<n; i++) {
            if(i != 0) {
                temp2.add(valueInHouse[i]);
            }
            if(i != n-1) {
                temp1.add(valueInHouse[i]);
            }

        }
        long ans1 = adjSumTabSO( temp1);
        long ans2 = adjSumTabSO( temp2);
        return Math.max(ans1, ans2);

    }
    static long adjSumTabSO( ArrayList<Integer> nums) {
        int n = nums.size();
        int[] dp = new int[n];
        long im1 = nums.get(0);
        long im2 = 0;
        long curi = 0;

        for(int i=1; i<n; i++) {
            long pick = nums.get(i) + ((i>1)?im2:0);
            long notPick = im1;

            curi = Math.max(pick, notPick);
            im2 = im1;
            im1 = curi;

        }
        return im1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 1};
        System.out.println(houseRobber(arr));
    }
}
