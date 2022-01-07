package trees;

public class CountCompleteTreeNodes {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        //root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        System.out.println(countNodes(root));
    }
    public static int countNodes(TreeNode root) {
        if(root == null) return 0;
        int lh = leftHeight(root);
        int rh = rightHeight(root);
        if(lh == rh) return (2<<(lh))-1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    static int leftHeight(TreeNode root) {
        int count = 0;
        while(root.left!=null) {
            count++;
            root = root.left;
        }
        return count;
    }

    static int rightHeight(TreeNode root) {
        int count = 0;
        while(root.right!=null) {
            count++;
            root = root.right;
        }
        return count;
    }
}
