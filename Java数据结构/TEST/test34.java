//判断一棵二叉树是否为搜索二叉树和完全二叉树
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
     * @param root TreeNode类 the root
     * @return bool布尔型一维数组
     */
    public boolean[] judgeIt (TreeNode root) {
        // 两个情况分别判断：
        // 二叉搜索树：每个节点左边节点小于右边节点，左子树的最大值一定小于根节点，小于右子树的最大值；通过中序遍历，严格递增
        // 完全二叉树：层序遍历，除了最后的一层，每层都是满的
        if (null == root) return new boolean[]{false, false};
        List<Integer> list = new ArrayList<>();
        midSearch(root, list);
        boolean b1 = true;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i-1)) {
                b1 = false;
                break;
            }
        }
        boolean b2 = isCompleteTree(root);
        return new boolean[]{b1, b2};
    }
     
    void midSearch(TreeNode root, List<Integer> list) {
        // 中序遍历
        if (null == root) return;
        midSearch(root.left, list); 
        list.add(root.val);
        midSearch(root.right, list);
    }
     
    boolean isCompleteTree(TreeNode root) {
        // 判断一棵树是否为完全二叉树，层序遍历，一旦出现null，则队列中剩余的节点必须为叶子节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (null == cur.left) {
                // 遍历每个节点
                if (null != cur.right) return false;
                while (!queue.isEmpty()) {
                    TreeNode p = queue.poll();
                    if (null != p.left || null != p.right) return false;
                }
                return true;
            } else queue.add(cur.left);
            if (null == cur.right) {
                while (!queue.isEmpty()) {
                    TreeNode p = queue.poll();
                    if (null != p.left || null != p.right) return false;
                }
                return true;
            } else queue.add(cur.right);
        }
        return true;
    }
}