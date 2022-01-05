package general;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingChars {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int l = 0, r = 0;
        int n = s.length();
        int len = 0;
        while(r<n) {
            if(map.containsKey(s.charAt(r)))
                l = Math.max(map.get(s.charAt(r))+1, l);

            map.put(s.charAt(r), r);
            len = Math.max(len, r-l+1);
            r++;
        }

        return len;

    }
}
