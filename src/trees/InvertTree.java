package trees;

public class InvertTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        //root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        inorderTraverse(root);
        System.out.println(invertTree(root));
        inorderTraverse(root);
    }
    public static TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if(root.left!=null) invertTree(root.left);
        if(root.right!= null) invertTree(root.right);

        return root;
    }

    static void inorderTraverse(TreeNode root) {
        if(root == null) return;

        inorderTraverse(root.left);
        System.out.println(root.val);
        inorderTraverse(root.right);
    }
}
