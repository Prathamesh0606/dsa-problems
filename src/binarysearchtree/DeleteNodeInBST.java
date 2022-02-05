package binarysearchtree;

import trees.TreeNode;

public class DeleteNodeInBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root = insertIntoBST(root, 3);
        root = insertIntoBST(root, 6);
        root = insertIntoBST(root, 2);
        root = insertIntoBST(root, 4);
        root = insertIntoBST(root, 7);
        root = deleteNode(root, 3);

    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val == key) {
            return helper(root);
        }

        TreeNode curr = root;

        while (root != null) {
            if (root.val > key) {
                if (root.left != null && root.left.val == key) {
                    root.left = helper(root.left);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                if (root.right != null && root.right.val == key) {
                    root.right = helper(root.right);
                    break;
                } else {
                    root = root.right;
                }
            }
        }

        return curr;
    }

    static TreeNode helper(TreeNode root) {
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;

        TreeNode rightNode = root.right;
        TreeNode lastRight = lastRight(root.left);

        lastRight.right = rightNode;

        return root.left;
    }

    static TreeNode lastRight(TreeNode root) {
        if (root.right == null) {
            return root;
        }
        return lastRight(root.right);
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        TreeNode curr = root;

        while (true) {
            if (curr.val <= val) {
                if (curr.right != null) curr = curr.right;

                else {
                    curr.right = new TreeNode(val);
                    break;
                }
            } else {
                if (curr.left != null) curr = curr.left;
                else {
                    curr.left = new TreeNode(val);
                    break;
                }
            }
        }

        return root;
    }
}
