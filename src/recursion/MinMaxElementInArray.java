package recursion;

public class MinMaxElementInArray {
    public static void main(String[] args) {
        int[] arr = {-61,2,3,5,2,56,23,-1};
        System.out.println(maxEle(arr, arr[0], 0));
    }

    static int minEle(int[] arr, int minSofar, int i) {
        if(i==arr.length) return minSofar;

        if(arr[i]<minSofar) minSofar = arr[i];

        return minEle(arr, minSofar, i+1);

    }

    static int maxEle(int[] arr, int maxSoFar, int i) {
        if (i == arr.length) return maxSoFar;
        return maxEle(arr, Math.max(arr[i], maxSoFar), i+1);
    }
}
