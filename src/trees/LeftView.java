package trees;

import java.util.ArrayList;

public class LeftView {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        System.out.println(leftView(root));
    }
    static ArrayList<Integer> leftView(TreeNode root)
    {
        // Your code here
        ArrayList<Integer> ans = new ArrayList<>();

        traverse(root, 0, ans);
        return ans;
    }

    static void traverse(TreeNode root, int level, ArrayList<Integer> ans) {
        if(root == null) {
            return;
        }

        if(level == ans.size()) ans.add(root.val);

        traverse(root.left, level+1, ans);
        traverse(root.right, level+1, ans);
    }
}
