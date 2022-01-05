package recursion;

import java.util.Arrays;

public class CountInversions {
    public static void main(String[] args) {
        //int[] arr = { 1, 20, 6, 4, 5 };
        int[] arr = { 5,3,2,4,1 };
        System.out.println(mergeSort(arr, new int[arr.length], 0, arr.length-1));
    }

    static int mergeSort(int[] arr, int[] temp, int left, int right) {
        int cnt = 0, mid;
        if (right>left) {
            mid = (left+right)/2;
            cnt+=mergeSort(arr, temp, left, mid);
            cnt+=mergeSort(arr, temp, mid+1, right);
            cnt+= mergeAndCount(arr, temp, left, mid, right);
        }
        return cnt;
    }

    private static int mergeAndCount(int[] arr, int[] temp, int left, int mid, int right) {
        int i, j, k;
        i = left;
        j = mid+1;
        k = left;
        int inv = 0;
        while(i<=mid && j<=right) {
            if(arr[i]<=arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                inv+=mid-i+1;
            }
        }

        while(i<=mid) temp[k++] = arr[i++];
        while(j<=right) temp[k++] = arr[j++];
        for (int l = left; l <=right; l++) {
            arr[l] =temp[l];
        }
        return inv;
    }
//private static int mergeAndCount(int[] arr, int l,
//                                 int m, int r)
//{
//
//    // Left subarray
//    int[] left = Arrays.copyOfRange(arr, l, m + 1);
//
//    // Right subarray
//    int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);
//
//    int i = 0, j = 0, k = l, swaps = 0;
//
//    while (i < left.length && j < right.length) {
//        if (left[i] <= right[j])
//            arr[k++] = left[i++];
//        else {
//            arr[k++] = right[j++];
//            swaps += (m + 1) - (l + i);
//        }
//    }
//    while (i < left.length)
//        arr[k++] = left[i++];
//    while (j < right.length)
//        arr[k++] = right[j++];
//    return swaps;
//}
//
//    // Merge sort function
//    private static int mergeSortAndCount(int[] arr, int l,
//                                         int r)
//    {
//
//        // Keeps track of the inversion count at a
//        // particular node of the recursion tree
//        int count = 0;
//
//        if (l < r) {
//            int m = (l + r) / 2;
//
//            // Total inversion count = left subarray count
//            // + right subarray count + merge count
//
//            // Left subarray count
//            count += mergeSortAndCount(arr, l, m);
//
//            // Right subarray count
//            count += mergeSortAndCount(arr, m + 1, r);
//
//            // Merge count
//            count += mergeAndCount(arr, l, m, r);
//        }
//
//        return count;
//    }
//
//    // Driver code
//    public static void main(String[] args)
//    {
//        int[] arr = { 1, 20, 6, 4, 5 };
//
//        System.out.println(
//                mergeSortAndCount(arr, 0, arr.length - 1));
//    }
}
