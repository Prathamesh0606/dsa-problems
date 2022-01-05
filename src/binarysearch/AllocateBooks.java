package binarysearch;

public class AllocateBooks {

    public static void main(String[] args) {
        int[] arr = {12, 34, 67, 90};
        int B = 2;
        System.out.println(books(arr, B));
    }
    public static int books(int[] A, int B) {
        if(B>A.length) return -1;
        int sum = 0;
        int low = A[0];
        //Arrays.sort(A);
        for(int i=0; i<A.length; i++) {
            sum+=A[i];
            low = Math.min(low, A[i]);
        }
        int hi = sum;
        while(low<=hi) {
            int mid = (low + hi)>>1;

            if(isPossible(A, mid, B)) {
                hi = mid-1;

            }
            else {
                low = mid+1;
            }
        }

        return low;
    }

    static boolean isPossible(int[] A, int pages, int students) {
        int cnt = 0;
        int sumAllocated = 0;
        for (int i = 0; i < A.length; i++) {
            if (sumAllocated + A[i] > pages) {
                cnt++;
                sumAllocated = A[i];
                if (sumAllocated > pages) return false;
            } else {
                sumAllocated += A[i];
            }
        }
        if (cnt < students) return true;
        return false;
    }
}
