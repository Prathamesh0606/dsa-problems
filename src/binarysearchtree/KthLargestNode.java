package binarysearchtree;

import trees.TreeNode;

public class KthLargestNode {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);

        System.out.println(kthLargest(root, 2));
    }
    public static int kthLargest(TreeNode root, int K) {
        //Your code here
        int[] k = new int[1];
        k[0] = K;
        int cnt = helper(root, k).val;

        return cnt;

    }

    int c = 0;

    static TreeNode helper(TreeNode root, int k[]) {
        if (root == null) return null;

        TreeNode right = helper(root.right, k);
        if (right != null) {

            return right;
        }
        k[0]--;

        if (k[0] == 0) {
            return root;
        }

        return helper(root.left, k);

    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);

        TreeNode curr = root;

        while(true) {
            if(curr.val <= val) {
                if(curr.right!=null) curr = curr.right;

                else {
                    curr.right = new TreeNode(val);
                    break;
                }
            } else {
                if(curr.left != null) curr = curr.left;
                else {
                    curr.left = new TreeNode(val);
                    break;
                }
            }
        }

        return root;
    }
}
