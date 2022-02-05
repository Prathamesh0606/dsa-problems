package binarysearchtree;

import trees.TreeNode;

public class ConstructBSTFromPreorder {

    public TreeNode bstFromPreorder(int[] preorder) {
        return bst(preorder,  new int[1], Integer.MAX_VALUE);
    }

    public TreeNode bst(int[] pre, int[] i, int ub) {
        if(i[0] == pre.length || pre[i[0]] > ub) return null;

        TreeNode root = new TreeNode(pre[i[0]++]);
        root.left = bst(pre, i, root.val);
        root.right = bst(pre, i, ub);

        return root;
    }
}
