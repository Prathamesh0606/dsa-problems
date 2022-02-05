package general;
//
//The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order) from
//        unsorted part and putting it at the beginning. The algorithm maintains two subarrays in a given array.
//        1) The subarray which is already sorted.
//        2) Remaining subarray which is unsorted.
//        In every iteration of selection sort, the minimum element (considering ascending order) from the unsorted subarray
//        is picked and moved to the sorted subarray.

//Time O(n2)
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {22, 63, 11 ,12, 25, 26};
        selectionSort(arr);
        for (int i:
             arr) {
            System.out.println(i);
        }
    }

    static void selectionSort(int[] arr) {
        int n = arr.length;

        for(int i=0; i<n-1; i++) {
            int min_ind = i;
            for(int j=i+1; j<n; j++) {
                if(arr[j] < arr[min_ind]) {
                    min_ind = j;
                }
            }

            int temp = arr[min_ind];
            arr[min_ind] = arr[i];
            arr[i] = temp;
        }
    }
}
