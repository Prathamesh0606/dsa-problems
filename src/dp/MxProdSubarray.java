package dp;

public class MxProdSubarray {

    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(maxProduct(nums));
    }

    static int maxProductSubArray(int arr[]) {
        int prod1 = arr[0],prod2 = arr[0],result = arr[0];

        for(int i=1;i<arr.length;i++) {
            int temp = Math.max(arr[i],Math.max(prod1*arr[i],prod2*arr[i]));
            prod2 = Math.min(arr[i],Math.min(prod1*arr[i],prod2*arr[i]));
            prod1 = temp;

            result = Math.max(result,prod1);
        }

        return result;
    }

    public static int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int prod = 1;

        for(int i=0; i<nums.length; i++) {
            prod*=nums[i];

            ans = Math.max(prod, ans);
            if(prod == 0) prod = 1;
        }
        prod = 1;
        for(int i=nums.length-1; i>=0; i--) {
            prod*=nums[i];

            ans = Math.max(prod, ans);
            if(prod == 0) prod = 1;
        }

        return ans;
    }
}
