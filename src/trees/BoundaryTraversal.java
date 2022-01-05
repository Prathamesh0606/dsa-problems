package trees;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoundaryTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(4);
        root.left.left.right.left = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.right.left.left = new TreeNode(10);
        root.right.right.left.right = new TreeNode(11);

        printBoundary(root);
    }

    static void printBoundary(TreeNode root) {
        List<Integer> leaves = new ArrayList<>();
        List<Integer> leftNodes = new ArrayList<>();
        List<Integer> rightNodes = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        ans.add(root.val);
        leftBoundary(root, leftNodes);
        rightBoundary(root, rightNodes);
        leaves(root, leaves);
        ans.addAll(leftNodes);
        ans.addAll(leaves);
        ans.addAll(rightNodes);

        System.out.println(ans);

    }
    static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    static void leftBoundary(TreeNode root, List<Integer> list) {
        TreeNode curr = root.left;

        while(curr != null) {
            if(!isLeaf(curr)) list.add(curr.val);

            if(curr.left!=null) curr = curr.left;
            else curr = curr.right;
        }
    }

    static void rightBoundary(TreeNode root, List<Integer> list) {
        TreeNode curr = root.right;

        while(curr != null) {
            if(!isLeaf(curr)) list.add(curr.val);

            if(curr.right!=null) curr = curr.right;
            else curr = curr.left;
        }

        Collections.reverse(list);
    }

    static void leaves(TreeNode root, List<Integer> list) {
        if(isLeaf(root)) {
            list.add(root.val);
            return;
        }

        if(root.left!=null) leaves(root.left, list);
        if(root.right!=null) leaves(root.right, list);
    }
}
