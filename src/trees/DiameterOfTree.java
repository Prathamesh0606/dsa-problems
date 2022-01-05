package trees;

public class DiameterOfTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(diameterOfBinaryTree(root));
    }
    public static int diameterOfBinaryTree(TreeNode root) {
        int[] maxH = new int[1];
        int d = diameter(root, maxH);
        return maxH[0];
    }

    static int diameter(TreeNode root, int[] maxH) {
        if(root == null) {
            return 0;
        }

        int lh = diameter(root.left, maxH);
        int rh = diameter(root.right, maxH);

        maxH[0] = Math.max(maxH[0], lh+rh);

        return 1 + Math.max(lh, rh);
    }
}

