package queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};

        int[] ans = maxSlidingWindow(nums, 3);

        for(int num:ans)
            System.out.println(num);
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        Deque<Integer> dq = new ArrayDeque<>();
        int ri = 0;
        int[] res = new int[n-k+1];

        for(int i=0; i<n; i++) {
            if(!dq.isEmpty() && dq.peek() == i-k) dq.poll();

            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.offer(i);

            if(i>=k-1) {
                res[ri++] = nums[dq.peek()];
            }
        }

        return res;
    }
}
