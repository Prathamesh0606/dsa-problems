package trees;

import java.util.*;



public class BottomView {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        System.out.println(bottomView(root));
    }

    static class Pair {
        TreeNode node;
        int val;

        Pair(TreeNode node, int val) {
            this.node = node;
            this.val = val;
        }
    }

    public static ArrayList<Integer> bottomView(TreeNode root)
    {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();

        if(root == null) return ans;

        q.add(new Pair(root, 0));
        Map<Integer, Integer> map = new TreeMap<>();

        while(!q.isEmpty()) {
            Pair t = q.remove();

            TreeNode node = t.node;
            int val = t.val;

            map.put(val, node.val);

            if(node.left != null) {
                q.add(new Pair(node.left, val - 1));
            }

            if(node.right != null) {
                q.add(new Pair(node.right, val + 1));
            }
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;


    }
}
