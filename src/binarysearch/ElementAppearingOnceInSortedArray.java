package binarysearch;

public class ElementAppearingOnceInSortedArray {

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4,8,8};

        System.out.println(singleNonDuplicate(nums));
    }
    public static int singleNonDuplicate(int[] nums) {
        int low = 0, hi = nums.length - 2;
        while (low <= hi) {
            int mid = (low + hi) >> 1;
            if (nums[mid] == nums[mid ^ 1]) {
                low = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return nums[low];
    }
}
