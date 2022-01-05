package greedy;

import java.util.Arrays;

public class MinPlatforms {
    public static void main(String[] args) {
        int n = 6;
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};

        System.out.println(findPlatform(arr, dep, n));
    }

    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 1, j = 0;
        int ans = 1;
        int cnt = 1;
        while(i < n && j < n) {
            if(arr[i] <= dep[j]) {
                i++;
                cnt+=1;
            }

            else if(arr[i] > dep[j]) {
                j++;
                cnt-=1;
            }

            if(cnt > ans) ans = cnt;
        }

        return ans;
    }
}
