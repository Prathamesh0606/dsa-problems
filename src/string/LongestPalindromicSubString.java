package string;

public class LongestPalindromicSubString {

    public static void main(String[] args) {
        String s = "bababa";
        System.out.println(longestPalindrome(s));
    }
    public static String longestPalindrome(String s) {
        if(s==null || s.length()<1) return "";

        int start = 0;
        int end = 0;
        for(int i=0;i<s.length();i++) {
            int len1 = expandFromMiddle(s,i,i);
            int len2 = expandFromMiddle(s,i,i+1);
            int len = Math.max(len1,len2);
            if(len>end-start) {
                start = i-((len-1)/2);
                end = i+len/2;
            }
        }

        return s.substring(start,end+1);

    }

    public static int expandFromMiddle(String s,int l,int r) {
        if(s==null || l>r) return 0;

        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)) {
            l--;
            r++;
        }
        return r-l-1;
    }
}
