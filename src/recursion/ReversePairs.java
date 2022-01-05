package recursion;

import java.util.ArrayList;

public class ReversePairs {
//    Given an integer array nums, return the number of reverse pairs in the array.
//    A reverse pair is a pair (i, j) where 0 <= i < j < nums.length and nums[i] > 2 * nums[j].

    public static void main(String[] args) {
        System.out.println(reversePairs(new int[]{1, 3, 2, 3, 1}));
    }


    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }

    static int mergeSort(int[] nums, int left, int right) {
        if(left>=right) return 0;

        int mid = (left+right)/2;
        int cnt=mergeSort(nums, left, mid);
        cnt+=mergeSort(nums, mid+1, right);
        cnt+= merge(nums, left, mid, right);
        return cnt;

    }

    static int merge(int[] nums, int low, int mid, int hi) {
        int cnt = 0;
        int j = mid+1;
        for(int i=low; i<=mid; i++) {
            while(j<=hi && nums[i]>(2 * (long) nums[j])) j++;
            cnt+= (j-(mid+1));
        }
        int left = low, right = mid+1;
        ArrayList<Integer> temp = new ArrayList<>();
        while(left<=mid && right<=hi) {
            if(nums[left]<=nums[right]) {
                temp.add(nums[left++]);

            } else {
                temp.add(nums[right++]);

            }
        }

        while(left<=mid) temp.add(nums[left++]);

        while(right<=hi) temp.add(nums[right++]);

        for(int i=low; i<=hi; i++) {
            nums[i] = temp.get(i-low);
        }
        return cnt;
    }



}
