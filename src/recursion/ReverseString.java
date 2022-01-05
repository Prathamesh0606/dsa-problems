package recursion;

public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        //reverseString(s);
        //System.out.println(s);
        String str = "hello";
        System.out.println(reverseS(str, str.length()-1, new StringBuilder()));
    }
    public static void reverseString(char[] s) {
        reverse(s, 0, s.length-1);
    }

    static StringBuilder reverseS(String s, int i, StringBuilder ans) {
        if(i  == -1) return ans;
        else return reverseS(s, i-1, ans.append(s.charAt(i)));
    }
    static void  reverse(char[] s, int i, int j) {
        if(i>j) return;

        char t = s[i];
        s[i] = s[j];
        s[j] = t;

        reverse(s, i+1, j-1);
    }
}
