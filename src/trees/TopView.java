package trees;

import java.util.*;

 class PairT {
    TreeNode node;
    int hd;

    PairT(TreeNode node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

public class TopView {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        System.out.println(topView(root));

    }
    static ArrayList<Integer> topView(TreeNode root)
    {
        // add your code
        Queue<PairT> q = new LinkedList<>();

        ArrayList<Integer> ans = new ArrayList<>();

        Map<Integer, Integer> map = new TreeMap<>();

        if(root == null) return ans;
        q.add(new PairT(root, 0));

        while(!q.isEmpty()) {
            PairT t = q.remove();
            TreeNode temp = t.node;
            int hd = t.hd;

            if(map.get(hd) == null) {
                map.put(hd, temp.val);
            }

            if(temp.left != null) {
                q.add(new PairT(temp.left, hd - 1));
            }

            if(temp.right != null) {
                q.add(new PairT(temp.right, hd + 1));
            }
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }
}
