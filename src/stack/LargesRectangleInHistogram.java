package stack;

import java.util.Stack;

public class LargesRectangleInHistogram {

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }
    public static int largestRectangleArea(int[] heights) {
        int[] leftSmall = new int[heights.length];
        int[] rightSmall = new int[heights.length];
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<heights.length; i++) {
            while(!s.isEmpty()  && heights[s.peek()]>=heights[i])
                s.pop();

            if(s.isEmpty()) leftSmall[i] = 0;
            else leftSmall[i] = s.peek()+1;

            s.push(i);
        }

        s = new Stack<>();

        for(int i=heights.length-1; i>=0; i--) {
            while(!s.isEmpty()  && heights[s.peek()]>=heights[i])
                s.pop();

            if(s.isEmpty()) rightSmall[i] = heights.length-1;
            else rightSmall[i] = s.peek()-1;

            s.push(i);
        }

        int max = 0;
        for(int i=0; i<heights.length; i++) {
            max = Math.max(max, heights[i]*(rightSmall[i]-leftSmall[i]+1));
        }

        return max;
    }
}
