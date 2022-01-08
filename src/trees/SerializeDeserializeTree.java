package trees;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        //root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        String s = serialize(root);
        System.out.println(s);
        deserialize(s);
    }
    public static String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder str = new StringBuilder();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            TreeNode node = q.poll();

            if(node == null) {
                str.append("null ");
                continue;
            }

            str.append(node.val+" ");
            q.offer(node.left);
            q.offer(node.right);
        }

        return str.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data == "") return null;

        String[] values = data.split(" ");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.offer(root);

        for(int i=1; i<values.length; i++) {
            TreeNode parent = q.poll();

            if(!values[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.offer(left);
            }
            if(!values[++i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.offer(right);
            }
        }

        return root;
    }
}
