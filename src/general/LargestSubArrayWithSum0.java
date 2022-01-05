package general;

import java.util.HashMap;

public class LargestSubArrayWithSum0 {
    public static void main(String[] args) {
       int A[] = {15,-2,2,-8,1,7,10,23};
        System.out.println(maxLen(A, A.length));
    }

    static int maxLen(int arr[], int n)
    {
        // Your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int max = 0;
        for(int i=0; i<n; i++) {
            sum+=arr[i];
            if(sum==0) max = i+1;
            else {
                if(map.containsKey(sum)) {
                    int nn = i-map.get(sum);

                    max = Math.max(max, nn);
                } else {
                    map.put(sum, i);
                }
            }
        }

        return max;
    }
}
