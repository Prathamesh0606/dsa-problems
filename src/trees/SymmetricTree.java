package trees;

public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        System.out.println(isSymmetric(root));
    }
    public static boolean isSymmetric(TreeNode root) {
        return traverse(root.left, root.right);
    }

    static boolean traverse(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null) {
            return root1 == root2;
        }

        if(root1.val == root2.val) {
            return traverse(root1.left, root2.right) && traverse(root1.right, root2.left);
        }

        return false;
    }
}
