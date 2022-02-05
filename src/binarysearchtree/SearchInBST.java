package binarysearchtree;

import trees.TreeNode;

public class SearchInBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);

        System.out.println(searchBST(root, 1));

    }
    public static TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return root;

        if(root.val == val) return root;

        if(root.val < val) return searchBST(root.right, val);

        if(root.val > val ) return searchBST(root.left, val);

        return null;
    }
}
