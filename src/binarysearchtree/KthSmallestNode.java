package binarysearchtree;

import trees.TreeNode;

public class KthSmallestNode {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);

        System.out.println(kthSmallest(root, 2));
    }
    public static int kthSmallest(TreeNode root, int k) {
        int[] N = new int[1];
        N[0] = k;

        return kthsmallest(root, N).val;
    }

    static TreeNode kthsmallest(TreeNode root,int k[]) {

        if(root==null)
            return null;

        TreeNode left=kthsmallest(root.left,k);
        if(left!=null)
            return left;

        k[0]--;

        if(k[0]==0)
            return root;

        return kthsmallest(root.right,k);
    }
}
