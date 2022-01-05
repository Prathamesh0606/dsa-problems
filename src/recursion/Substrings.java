package recursion;

import java.util.ArrayList;

public class Substrings {

    public static void main(String[] args) {
        String s = "Tadoba Reserve";
        ArrayList<String> ans = new ArrayList<>();
//        for (int i = 0; i < ans.size(); i++) {
//            if(i<ans.size()-2)
//            System.out.println(ans.get(i)+",");
//            else System.out.println(ans.get(i));
//        }
        subss(ans, s, "");
        System.out.println(ans.size());
    }

    static ArrayList<String> subs( String s, String soFar, int i) {
        ArrayList<String> ans = new ArrayList<>();
        if(i==s.length()) {
            ans.add(soFar);
            return ans;
        }
        ans.addAll(subs(s, soFar+s.charAt(i), i+1));
        ans.addAll(subs(s, soFar, i+1));
        return ans;
    }

    static void subss( ArrayList<String> ans, String s, String soFar) {
        if(s.length()==0) {
            if(!ans.contains(soFar) && !soFar.equals(" ")) {
                ans.add(soFar);
                System.out.println(soFar);
            }
            return;
        }
        char ch = s.charAt(0);
        subss(ans, s.substring(1), soFar+ch);
        subss( ans, s.substring(1), soFar);
    }
}
