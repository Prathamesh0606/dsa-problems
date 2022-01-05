package binarysearch;

public class KthElementIn2SortedArrays {

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 6, 7, 9};
        int[] arr2 = {1, 4, 8, 10};

        System.out.println(kthElement(arr1, arr2, arr1.length, arr2.length, 5));
    }
    public static long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        if(n>m) return kthElement(arr2, arr1, m, n, k);

        int low = Math.max(0, k-m), hi = Math.min(k, n);

        while(low<=hi) {
            int cut1 = (low+hi)>>1;

            int cut2 = k-cut1;

            int l1 = cut1 == 0? Integer.MIN_VALUE:arr1[cut1-1];
            int l2 = cut2 == 0?Integer.MIN_VALUE:arr2[cut2-1];
            int r1 = cut1 == n? Integer.MAX_VALUE:arr1[cut1];
            int r2 = cut2 == m? Integer.MAX_VALUE:arr2[cut2];

            if(l1<=r2 && l2<=r1) {
                return Math.max(l1, l2);
            }

            if(l1>r2) {
                hi = cut1-1;
            }

            else {
                low = cut1+1;
            }

        }

        return 1;

    }
}
