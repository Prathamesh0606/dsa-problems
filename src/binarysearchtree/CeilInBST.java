package binarysearchtree;

import trees.TreeNode;

public class CeilInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);

        System.out.println(ceil(root, 0));
    }
    public static int ceil(TreeNode root, int key) {
        int f = -1;

        while(root!=null) {
            if(root.val == key) {
                f = root.val;
                return f;
            }

            if(root.val >= key) {
                f = root.val;
                root = root.left;
            }
            else {
                root = root.right;
            }
        }

        return f;
    }
}
