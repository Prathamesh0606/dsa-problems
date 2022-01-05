package binarysearch;

public class MatrixMedian {

    public static void main(String[] args) {
        int[][] A = {{1, 3, 5},
                {2, 6, 9},
                {3, 6, 9}};
        System.out.println(findMedian(A));
    }

    public static int findMedian(int[][] A) {
        int size = A.length * A[0].length;

        int low = 0;
        int hi = (int) 1e9;

        while (low <= hi) {
            int mid = (low + hi) >> 1;

            int cnt = 0;
            for (int[] ints : A) {
                cnt += countLessThanEqualTo(ints, mid);
            }

            if (cnt <= size >> 1) low = mid + 1;

            else hi = mid - 1;
        }

        return low;

    }

    public static int countLessThanEqualTo(int[] arr, int mid) {
        int l = 0;
        int h = arr.length - 1;

        while (l <= h) {
            int m = (l + h) >> 1;
            if (arr[m] <= mid) l = m + 1;
            else h = m - 1;
        }

        return l;
    }
}
