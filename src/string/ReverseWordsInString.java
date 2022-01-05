package string;

public class ReverseWordsInString {

    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }
    public static String reverseWords(String s) {
        char[] a = s.toCharArray();
        int n = a.length;

        reverse(a, 0, n-1);

        reverseWords(a, n);

        return removespaces(a, n);

    }

    public static void reverseWords(char[] a, int n) {
        int i=0, j=0;

        while(i < n) {
            while(i < j || i < n && a[i] == ' ') i++;
            while(j < i || j < n && a[j] !=' ') j++;

            reverse(a, i, j-1);
        }
    }

    public static String removespaces(char[] a, int n) {

        int i=0, j=0;

        while(j < n) {
            while(j < n && a[j] == ' ') j++;
            while(j < n && a[j] != ' ') a[i++] = a[j++];
            while(j < n && a[j] == ' ') j++;

            if(j < n) a[i++] = ' ';
        }

        return new String(a).substring(0, i);
    }

    public static void reverse(char[] a, int i, int j) {
        while(i < j) {
            char temp = a[i];
            a[i++] = a[j];
            a[j--] = temp;
        }
    }
}

