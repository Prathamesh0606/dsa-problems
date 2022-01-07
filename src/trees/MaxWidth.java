package trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaxWidth {
    static Map<Integer, Integer> map = new HashMap<>();
    static int maxWidth;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        System.out.println(widthOfBinaryTreeLO(root));
    }
    //recursive solution using DFS
    public static int widthOfBinaryTree(TreeNode root) {
        getWidth(root, 0, 0);

        return maxWidth;

    }

    static void getWidth(TreeNode root, int depth, int position) {
        if(root == null) {
            return;
        }
        map.computeIfAbsent(depth, x->position);
        maxWidth = Math.max(maxWidth, position - map.get(depth)+1);

        getWidth(root.left, depth+1, position*2+1);
        getWidth(root.right, depth+1, position*2+2);
    }

   static class Pair {
        int num;
        TreeNode node;

        Pair(TreeNode node, int num) {
            this.node = node;
            this.num = num;
        }
    }
    //iterative solution using level order traversal (BFS) .. also faster
    public static int widthOfBinaryTreeLO(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        while(!q.isEmpty()) {

            int min = q.peek().num;
            int size = q.size();
            int first = 0, last = 0;
            for(int i=0; i<size; i++) {
                int curr = q.peek().num-min;
                TreeNode node = q.peek().node;
                q.poll();

                if(i == 0) first = curr;
                if(i == size-1) last = curr;
                if(node.left!=null) {
                    q.offer(new Pair(node.left, curr*2+1));
                }

                if(node.right!=null) {
                    q.offer(new Pair(node.right, curr*2+2));
                }

                ans = Math.max(ans, last-first+1);
            }
        }
        return ans;

    }
}
