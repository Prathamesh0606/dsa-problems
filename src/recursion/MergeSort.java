package recursion;

public class MergeSort {

    public static void main(String[] args) {
        //System.out.println(g(5.0,4));
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        int n = arr.length;

        sort(arr, 0, n - 1);
        System.out.println("Sorted array: ");
        printArray(arr, n);
    }


    static void printArray(int[] arr, int size)
    {
        for(int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }
    static void sort(int[] arr, int l, int h) {
        if(l<h) {
            int mid = l+(h-l)/2;
            sort(arr, l, mid);
            sort(arr, mid+1, h);
            merge(arr, l, mid, h);
        }

    }


    static void merge(int[] arr, int low, int mid, int hi) {
        int n1 = mid-low+1;
        int n2 = hi-mid;

//        int i = low;
//        int j = mid+1;
        int k = 0;
        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++)
            left[i] = arr[low + i];

        for (int j = 0; j < n2; j++)
            right[j] = arr[mid + 1 + j];

        int i = 0, j = 0;
        k = low;

        while(i<n1 && j<n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            }

            else {
                arr[k++] = right[j++];
            }
        }

        while(i<n1) {
            arr[k++] = left[i++];
        }

        while(j<n2) {
            arr[k++] = right[j++];
        }

    }
    static int g(int a, int b) {
        return a+b;
    }
    static double g(double a, int v) {
        return a*v;
    }
}
