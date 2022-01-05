package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PreviousSmallerElement {

    public static void main(String[] args) {
        int[] arr = {4,5,2,10,8};
        int[] ans = prevSmaller(arr);

        for (int a: ans
             ) {
            System.out.println(a);
        }
    }
    public static int[] prevSmaller(int[] A) {
        int[] result = new int[A.length];
        Stack<Integer> stack=new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=A.length-1; i>=0; i--){
            while(!stack.isEmpty() && A[i] < A[stack.peek()])
                //map.put(stack.pop(), A[i]);
                map.put(stack.pop(), A[i]);
            //stack.push(A[i]);
            stack.push(i);
        }

        // int i=0;
        // for(int num : A)
        //     result[i++] = map.getOrDefault(num, -1);

        for(int i=0; i<A.length; i++) {
            result[i] = map.getOrDefault(i, -1);
        }
        return result;
    }
}
