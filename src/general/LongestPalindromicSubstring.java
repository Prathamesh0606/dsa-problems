package general;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestSubString("aaabbsbaabbaabb"));
    }
    static String longestSubString(String str) {
        int s = 0, e = 0;
        for(int i=0; i<str.length(); i++) {
            int len1 = expandFromMid(str, i, i);
            int len2 = expandFromMid(str, i, i+1);

            int len = Math.max(len1, len2);

            if(len> (e-s+1)) {
                s = i-(len-1)/2;
                e = i+len/2;
            }
        }

        return str.substring(s, e+1);
    }
    static int expandFromMid(String s, int left, int right) {
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right-left-1;
    }
}
