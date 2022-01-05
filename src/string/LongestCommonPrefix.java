package string;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] s = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(s));
    }
    public static String longestCommonPrefix(String[] strs) {
        String ans = strs[0];
        for(int i=1; i<strs.length; i++) {
            while(!strs[i].startsWith(ans))
                ans = ans.substring(0, ans.length()-1);
        }

        return ans;
    }
}

