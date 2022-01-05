package string;

public class StringToInteger {

    public static void main(String[] args) {
        String s = "4193 with words";
        System.out.println(myAtoi(s));
    }
    public static int myAtoi(String s) {
        int i = 1;
        long sum = 0;
        boolean exe = false;
        for(char c:s.toCharArray()) {
            if(c == ' ') continue;
            else if(c == '-') i = -1;
            else if(c == '+') i = 1;
            else if(c - '0'>=0 && c - '0'<=9) {
                int digit = c - '0';
                sum*=10;
                sum+=digit;
                exe = true;

            }

            else if(c == '.') return (int)sum;

            else {
                if(exe) continue;

                else return 0;
            }
        }

        return sum >= Integer.MAX_VALUE ? (i==-1? Integer.MIN_VALUE:Integer.MAX_VALUE): i * (int)sum;
    }
}
