package dp;

public class MxProdSubarray {

    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(maxProduct(nums));
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
