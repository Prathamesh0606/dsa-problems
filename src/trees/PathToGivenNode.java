package trees;

import java.util.ArrayList;

public class PathToGivenNode {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        System.out.println(solve(root, 6));
    }
    public static ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> list = new ArrayList<>();
        if(find(A, list, B)) {
            int[] arr = new int[list.size()];
            for(int i=0; i<list.size(); i++) {
                arr[i] = list.get(i);
            }
            return list;
        } else {
            return new ArrayList<>();
        }
    }

    static boolean find(TreeNode root, ArrayList<Integer> arr, int target) {
        if(root == null) {
            return false;
        }
        arr.add(root.val);
        if(root.val == target) {
            return true;
        }
        if(find(root.left, arr, target) || find(root.right, arr, target)) {
            return true;
        }
        arr.remove(arr.size()-1);
        return false;
    }
}
