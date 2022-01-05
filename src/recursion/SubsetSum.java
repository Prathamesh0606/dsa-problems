package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//Given a list arr of N integers, print sums of all subsets in it.
public class SubsetSum {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{2, 3};
        List<Integer> ar = new ArrayList<>();
        ar = Arrays.asList(arr);
        System.out.println(subsetSums(ar, ar.size()));
    }
    static List<Integer> subsetSums(List<Integer> arr, int N){
        // code here
        List<Integer> l = new ArrayList<>();
        sum(arr, 0, 0, l );

        return l;
    }

    private static void sum(List<Integer> arr, int i, int s,  List<Integer> ans) {
        if(i == arr.size()) {
            ans.add(s);
            s = 0;
            return;
        }

        sum(arr, i+1, s+arr.get(i), ans);
        sum(arr, i+1, s, ans);
    }
}
