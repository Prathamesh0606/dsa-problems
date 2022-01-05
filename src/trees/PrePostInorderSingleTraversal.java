package trees;

import java.util.ArrayList;
import java.util.Stack;

class Pair {
    TreeNode node;
    int cnt;

    public Pair(TreeNode f, int s) {
        node = f;
        cnt = s;
    }
}

public class PrePostInorderSingleTraversal {
    private static ArrayList<Integer> inorder;
    private static ArrayList<Integer> preOrder;
    private static ArrayList<Integer> postOrder;

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        inorder = new ArrayList<>();
        preOrder = new ArrayList<>();
        postOrder = new ArrayList<>();

        traverse(root);

        System.out.println("The preorder Traversal is : ");
        for (int nodeVal: preOrder) {
            System.out.print(nodeVal + " ");
        }
        System.out.println();
        System.out.println("The inorder Traversal is : ");
        for (int nodeVal: inorder ) {
            System.out.print(nodeVal + " ");
        }
        System.out.println();
        System.out.println("The postorder Traversal is : ");
        for (int nodeVal: postOrder) {
            System.out.print(nodeVal + " ");
        }
        System.out.println();
    }

    static void traverse(TreeNode root) {
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));

        while(!st.isEmpty()) {
            Pair temp = st.pop();

            if(temp.cnt == 1) {
                preOrder.add(temp.node.val);
                temp.cnt++;
                st.push(temp);

                if(temp.node.left!=null) {
                    st.push(new Pair(temp.node.left, 1));
                }
            }

            else if(temp.cnt == 2) {
                inorder.add(temp.node.val);
                temp.cnt++;
                st.push(temp);

                if(temp.node.right!=null) {
                    st.push(new Pair(temp.node.right, 1));
                }
            }
            else {
                postOrder.add(temp.node.val);
            }
        }
    }
}
