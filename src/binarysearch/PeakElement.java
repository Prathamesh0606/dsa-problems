package binarysearch;

public class PeakElement {

    public static void main(String[] args) {
       int[] arr =  {1,2,1,3,5,6,4};
        System.out.println(findPeakElement(arr));
    }
    public static int findPeakElement(int[] nums) {
        int lo = 0, hi = nums.length-1;
        while(lo < hi) {
            int mid = lo + (hi - lo)/2;

            if(mid < nums.length-1 && nums[mid] < nums[mid+1]) {
                lo = mid+1;
            } else {
                hi = mid;
            }
        }

        return lo;
    }
}
