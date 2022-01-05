package general;

public class LongestMountain {

    public static void main(String[] args) {
        int[] arr = {2,1,4,7,3,2,5};

        System.out.println(longestMountain(arr));
    }
    public static int longestMountain(int[] arr) {
        int up = 0, down = 0;
        int ans = 0;

        for(int i=1; i<arr.length; i++) {
            if(down > 0 && arr[i-1] < arr[i] || arr[i-1] == arr[i]) {
                up = down = 0;
            }
            if(arr[i-1] < arr[i]) up++;

            if(arr[i-1] > arr[i]) down++;

            if(up > 0 && down > 0 && up + down + 1 > ans) {
                ans = up + down + 1;
            }
        }

        return ans;
    }
}
