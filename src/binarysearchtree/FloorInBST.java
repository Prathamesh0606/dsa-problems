package binarysearchtree;

import trees.TreeNode;

public class FloorInBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);

        System.out.println(floor(root, 3));
    }
    public static int floor(TreeNode root, int key) {
        int f = -1;

        while(root!=null) {
            if(root.val == key) {
                f = root.val;
                return f;
            }

            if(root.val <= key) {
                f = root.val;
                root = root.right;
            }
            else {
                root = root.left;
            }
        }

        return f;
    }
}
