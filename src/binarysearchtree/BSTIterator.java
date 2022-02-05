package binarysearchtree;

import trees.TreeNode;

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> st = new Stack<>();
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }

    public int next() {
        TreeNode node = st.pop();
        pushAll(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();

    }

    public void pushAll(TreeNode root) {
        while(root != null) {
            st.push(root);
            root = root.left;
        }
    }
}
