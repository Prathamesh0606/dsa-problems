package binarysearchtree;

import trees.TreeNode;

public class InsertInBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root = insertIntoBST(root, 2);
        root = insertIntoBST(root, 3);
        root = insertIntoBST(root, 1);
        root = insertIntoBST(root, 6);
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
