package recursion;

import java.util.HashMap;

public class PostorderTraversalFromPreAndIn {

    static int preIndex = 0;
    void printPost(int[] in, int[] pre, int inStrt,
                   int inEnd, HashMap<Integer, Integer> hm)
    {
        if (inStrt > inEnd)
            return;

        // Find index of next item in preorder traversal in
        // inorder.
        System.out.println(preIndex);
        int inIndex = hm.get(pre[preIndex++]);

        // traverse left tree
        printPost(in, pre, inStrt, inIndex - 1, hm);

        // traverse right tree
        printPost(in, pre, inIndex + 1, inEnd, hm);

        // print root node at the end of traversal
        System.out.print(in[inIndex] + " ");
    }

    void printPost1(int[] in, int[] pre, int inStrt,
                   int inEnd, int preIndex, HashMap<Integer, Integer> hm)
    {
        if (inStrt > inEnd || preIndex == in.length)
            return;

        // Find index of next item in preorder traversal in
        // inorder.
        int inIndex = hm.get(pre[preIndex++]);
        System.out.println(preIndex);
        //preIndex = preIndex+1;

        // traverse left tree
        printPost1(in, pre, inStrt, inIndex - 1, preIndex, hm);

        // traverse right tree
        printPost1(in, pre, inIndex + 1, inEnd, preIndex, hm);

        // print root node at the end of traversal
        //System.out.print(in[inIndex] + " ");
    }

    void printPostMain(int[] in, int[] pre)
    {
        int n = pre.length;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i=0; i<n; i++)
            hm.put(in[i], i);

        //printPost(in, pre, 0, n-1, hm);
        printPost1(in, pre, 0, n-1, 0, hm);
    }

    // Driver code
    public static void main(String[] ars)
    {
        int[] in = { 4, 2, 5, 1, 3, 6 };
        int[] pre = { 1, 2, 4, 5, 3, 6 };
        PostorderTraversalFromPreAndIn tree = new PostorderTraversalFromPreAndIn();
        tree.printPostMain(in, pre);

    }
}
