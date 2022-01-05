package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(zigzagLevelOrder(root));
    }
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();

        if(root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        boolean lToR = true;
        q.offer(root);

        while(!q.isEmpty()) {

            int size = q.size();
            List<Integer> arr = new ArrayList<>(size);

            for(int i=0; i<size; i++) {
                TreeNode temp = q.poll();

                if(lToR) {
                    arr.add(temp.val);
                }
                else {
                    arr.add(0, temp.val);
                }


                if(temp.left!=null) {
                    q.offer(temp.left);
                }
                if(temp.right!=null) {
                    q.offer(temp.right);
                }


            }
            lToR = !lToR;
            ans.add(arr);

        }

        return ans;
    }
}
