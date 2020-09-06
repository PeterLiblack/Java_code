//分别按照二叉树先序，中序和后序打印所有的节点。
import java.util.*;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 * }
 */

public class Solution {
    /**
     * 
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    List<Integer> pre = new ArrayList<>();
    List<Integer> in = new ArrayList<>();
    List<Integer> post = new ArrayList<>();
    
    public int[][] threeOrders (TreeNode root) {
        // write code here
        if (root == null) return new int[][] {{}};
        List<List<Integer>> ans = new ArrayList<>();
        preOrder(root);
        inOrder(root);
        postOrder(root);
        ans.add(pre);
        ans.add(in);
        ans.add(post);
        int[][] res = new int[ans.size()][ans.get(0).size()];
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(0).size(); j++) {
                res[i][j] = ans.get(i).get(j);
            }
        }
        return res;
    }
    
    private void preOrder(TreeNode root) {
        if (root == null) return;
        pre.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    
    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        in.add(root.val);
        inOrder(root.right);
    }
    
    private void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        post.add(root.val);
    }
}