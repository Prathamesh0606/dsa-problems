package recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();

        func(s, 0, new ArrayList<String>(), ans);
        return ans;
    }

    static void func(String s, int ind, List<String> list, List<List<String>> ans) {
        if(ind == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = ind; i<s.length(); i++) {
            if(isPalindrome(s.substring(ind, i+1))) {
                list.add(s.substring(ind, i+1));
                func(s, i+1, list, ans);
                list.remove(list.size()-1);
            }
        }

    }

   static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;

        while(i <= j) {
            if(s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            }

            else return false;
        }

        return true;


    }
}
