package binarysearch;

import java.util.Arrays;

public class AggressiveCows {

    public static void main(String[] args) {
        int[] arr = {1,2,8,4,9};
        int cows = 3;

        System.out.println(cows(arr, cows));
    }

    static int cows(int[] arr, int cows) {
        Arrays.sort(arr);
        int low = arr[0];
        int hi = arr[arr.length-1]-arr[0];

        while(low <= hi) {
            int mid = (low + hi)>>1;

            if(canPlace(arr, cows, mid)) {
                low = mid+1;
            } else {
                hi = mid-1;
            }
        }

        return hi;
    }

    static boolean canPlace(int[] arr, int count, int dist) {
        int coord = arr[0], cow = 1;

        for(int i=1; i<arr.length; i++) {
            if(arr[i]-coord>=dist) {
                cow++;
                coord = arr[i];
            }

            if(cow>=count) return true;
        }
         return false;
    }

}
