package trees;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromInorderAndPostorder {

    public static void main(String[] args) {
        int[] postorder = {9,15,7,20,3}, inorder = {9,3,15,20,7};
        TreeNode treeNode = buildTree(inorder, postorder);
        inorderTraverse(treeNode);
    }
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = postorder.length;
        for(int i=0; i<n; i++) {
            map.put(inorder[i], i);
        }

        return build(inorder, 0, n-1, postorder, 0, n-1, map);
    }

    static TreeNode build(int[] inorder,int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> map ) {

        if(inStart > inEnd || postStart > postEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = map.get(root.val);
        int nodesLeft = inRoot - inStart;

        root.left = build(inorder, inStart, inRoot - 1,
                postorder, postStart, postStart + nodesLeft -1, map);

        root.right = build(inorder, inRoot+1, inEnd,
                postorder, postStart + nodesLeft, postEnd-1, map);

        return root;

    }

    static void inorderTraverse(TreeNode root) {
        if(root == null) return;

        inorderTraverse(root.left);
        System.out.println(root.val);
        inorderTraverse(root.right);
    }
}
