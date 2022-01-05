package recursion;

public class FirstUpperCaseLetter {
    public static void main(String[] args) {
        String  s = "xcSZZZZ";
        System.out.println(firstLetter(s, 0));
    }

    static int firstLetter(String s, int i) {
        if(i==s.length()) return -1;

        if(s.charAt(i)-'A'>=0 && s.charAt(i)-'A'<26) return i;

        return firstLetter(s, i+1);
    }
}
