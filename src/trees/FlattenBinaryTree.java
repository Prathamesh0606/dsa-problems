package trees;

public class FlattenBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        //root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        flatten(root);
        inorderTraverse(root);
    }
    static TreeNode temp = null;
    public static void flatten(TreeNode root) {
        if(root == null) return;

        flatten(root.right);
        flatten(root.left);

        root.right = temp;
        root.left = null;
        temp = root;
    }

    static void inorderTraverse(TreeNode root) {
        if(root == null) return;

        inorderTraverse(root.left);
        System.out.println(root.val);
        inorderTraverse(root.right);
    }
}
