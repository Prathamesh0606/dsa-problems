package binarysearch;

public class SearchInRotatedArray {

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums, 2));
    }
    public static int search(int[] nums, int target) {

        int low = 0, hi = nums.length-1;

        while(low <= hi) {
            int mid = (low + hi)>>1;

            if(nums[mid] == target) return mid;

            if(nums[low] <= nums[mid]) {
                if(nums[low] <=target && nums[mid]>=target) hi = mid-1;

                else low = mid+1;
            }

            else {
                if(nums[mid]<=target && nums[hi]>=target) low = mid+1;
                else hi = mid-1;
            }
        }

        return -1;

    }
}
