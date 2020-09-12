//给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）

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
     * @param root TreeNode类 
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.add(root);
        TreeNode cur = root;
        TreeNode last = root;
        TreeNode nLast = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur.left != null) {
                queue.add(cur.left);
                nLast = cur.left;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nLast = cur.right;
            }
            list.add(cur.val);
            if (cur == last) {
                lists.add(list);
                list = new ArrayList<>();
                last = nLast;
            }
        }
        return lists;
    }
}



//给定二叉树的最大深度
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
     * @param root TreeNode类 
     * @return int整型
     */

public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        if(root.left==null){
            return 1+maxDepth(root.right);
        }
        if(root.right==null){
            return 1+maxDepth(root.left);
        }
        else{
           int n = maxDepth(root.left)+1;
           int m = maxDepth(root.right)+1;
           return m>n?m:n;
        }
    }
}