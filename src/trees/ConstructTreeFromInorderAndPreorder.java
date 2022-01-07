package trees;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromInorderAndPreorder {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7}, inorder = {9,3,15,20,7};
        TreeNode treeNode = buildTree(preorder, inorder);
        inorderTraverse(treeNode);
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<preorder.length; i++) {
            map.put(inorder[i], i);
        }
        int n = preorder.length;
        return build(preorder, 0, n-1, inorder,0 , n-1, map);
    }

    public static TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map) {
        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int inRoot = map.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = build(preorder, preStart+1, preStart + numsLeft,
                inorder, inStart, inRoot - 1, map);

        root.right = build(preorder, preStart + numsLeft+1, preEnd,
                inorder, inRoot+1, inEnd, map);
        return root;
    }

    static void inorderTraverse(TreeNode root) {
        if(root == null) return;

        inorderTraverse(root.left);
        System.out.println(root.val);
        inorderTraverse(root.right);
    }
}
