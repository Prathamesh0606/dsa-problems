package recursion;

import java.util.ArrayList;

public class SubsetSumEqualsK {

    public static void main(String[] args) {
        int[] arr = {1,2,1};
        int k = 2;
        ArrayList<ArrayList<Integer>>ans  = new ArrayList<>();
        //countSubSeqSumK(arr, 0, ans, new ArrayList<>(), k, 0);
        System.out.println(countSubSeqSumK(arr, 0, new ArrayList<>(), k, 0));
    }

    //to print all subsequences
    private static void subSumK(int[] arr, int i, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> ds, int k, int sum) {

        if(i==arr.length) {
            if (sum == k) {
                ans.add(new ArrayList<>(ds));

            }
            return;
        }

        ds.add(arr[i]);
        sum+=arr[i];
        subSumK(arr, i+1, ans, ds, k, sum);
        ds.remove(ds.size()-1);
        sum-=arr[i];
        subSumK(arr, i+1, ans, ds, k, sum);

    }

    //to print only one subsequence
    private static boolean subSumKOne(int[] arr, int i, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> ds, int k, int sum) {
        if(i==arr.length) {
            if (sum == k) {
                ans.add(new ArrayList<>(ds));
                return true;
            }
            else return false;
        }

        ds.add(arr[i]);
        sum+=arr[i];
        if(subSumKOne(arr, i+1, ans, ds, k, sum)) return true;
        ds.remove(ds.size()-1);
        sum-=arr[i];
        if(subSumKOne(arr, i+1, ans, ds, k, sum)) return true;

        return false;
    }

    //to count all subsequences
    static int countSubSeqSumK(int[] arr, int i, ArrayList<Integer> ds,
                               int k, int sum) {
        if(sum>k) return 0;
        if(i==arr.length) {
            if (sum == k) {
                return 1;
            }
            else return 0;
        }

        ds.add(arr[i]);
        sum+=arr[i];
        int l  = countSubSeqSumK(arr, i+1, ds, k, sum);
        ds.remove(ds.size()-1);
        sum-=arr[i];
        int r = countSubSeqSumK(arr, i+1, ds, k, sum);

        return l+r;
    }
}
