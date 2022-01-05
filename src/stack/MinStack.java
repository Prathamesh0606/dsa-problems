package stack;

import java.util.Stack;

public class MinStack {

    Stack<Long> st = new Stack <Long> ();
    Long mini;

    public MinStack() {
        mini = Long.MAX_VALUE;
    }

    public void push(int val) {
        Long v = Long.valueOf(val);
        if(st.isEmpty()) {
            mini = v;
            st.push(v);
        } else {
            if(v < mini) {
                st.push(2*v - mini);
                mini = v;

            } else {
                st.push(v);
            }
        }
    }

    public void pop() {
        if (st.isEmpty()) return;
        Long a = st.pop();
        if(a < mini) {
            mini = 2*mini - a;
        }

    }

    public int top() {

        Long i = st.peek();

        if(i < mini) return mini.intValue();

        return i.intValue();

    }

    public int getMin() {
        return mini.intValue();

    }
}
