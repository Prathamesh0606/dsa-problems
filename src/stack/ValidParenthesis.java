package stack;

import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {
        String s = "[{]";
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        if(s.length()<2) return false;


        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(' ) st.push(s.charAt(i));

            if(st.isEmpty()) return false;

            else if(s.charAt(i) == '}') {
                if(st.peek() == '{') st.pop();
                else return false;
            }

            else if(s.charAt(i) == ']') {
                if(st.peek() == '[') st.pop();
                else return false;
            }

            else if(s.charAt(i) == ')') {
                if(st.peek() == '(') st.pop();
                else return false;
            }

        }


        return st.isEmpty();
    }
}
