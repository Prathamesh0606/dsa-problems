package dp;

import java.util.*;

public class WordBreak {

    public static void main(String[] args) {
        String[] B = { "i", "like", "sam",
                "sung", "samsung", "mobile",
                "ice","cream", "icecream",
                "man", "go", "mango" };

        List<String> d = new ArrayList<>(Arrays.asList(B));
        String A = "ilike";


        System.out.println(wordBreak(A, 0, d));
    }

    static boolean wordBreak(String s, int pos, List<String> set) {
        if(pos == s.length()) {
            return true;
        }

        String t = "";
        for(int i= pos; i<s.length(); i++) {
            if(set.contains(s.substring(pos, i-pos+1)) && wordBreak(s, i+1, set)) return true;
            else set.add(s.substring(pos, i-pos+1));
        }

        return false;
    }


}


