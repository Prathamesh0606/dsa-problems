package trees;

public class SameTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right = new TreeNode(3);
        root1.right.left = new TreeNode(6);
//        root1.right.right = new TreeNode(7);
        System.out.println(isSameTree(root, root1));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null) {
            return p==q;
        }

        return (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }
}
