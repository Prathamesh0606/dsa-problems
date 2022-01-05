package trees;

public class MaxPathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(maxPathSum(root));
    }

    public static int maxPathSum(TreeNode root) {
        int[] ans = new int[1];

        ans[0] = Integer.MIN_VALUE;
        int d = maxPath(root, ans);

        return ans[0];
    }

    static int maxPath(TreeNode root, int[] ans) {
        if(root == null) {
            return 0;
        }

        int left = Math.max(0, maxPath(root.left, ans));
        int right = Math.max(0, maxPath(root.right, ans));

        ans[0] = Math.max(ans[0], root.val + left + right);

        return root.val + Math.max(left, right);
    }
}
