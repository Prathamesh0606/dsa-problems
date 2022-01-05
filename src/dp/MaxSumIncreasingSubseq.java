package dp;

public class MaxSumIncreasingSubseq {

    public static void main(String[] args) {
        int N = 5;
        int arr[] = {1, 101, 2, 3, 100};

        System.out.println(maxSumIS(arr, arr.length));
    }
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
