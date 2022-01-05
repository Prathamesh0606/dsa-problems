package recursion;

public class RotatedBinSearch {
    public static void main(String[] args) {
        int[] arr = {5,6,7,1,2,3,4};
        System.out.println(search(arr, 0, arr.length-1, 9));
    }

    static int search(int[] arr, int s, int e, int target) {
        int mid = s+(e-s)/2;
        if(target == arr[mid]) return mid;

        if(s>=e) return -1;
        if(arr[s]<=arr[mid]) {
            if(target>=arr[s] && target<=arr[mid]) {
                e = mid-1;
            } else {
                s = mid+1;
            }
        }
        else if(target>=arr[mid] && target<=arr[e]) {
            s = mid+1;
        }
        else {
            e = mid-1;
        }
        return search(arr, s, e, target);


    }
}
