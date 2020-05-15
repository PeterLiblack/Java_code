import javax.imageio.ImageTranscoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Li_ZW
 * @Date: 2020/05/15
 * @Time: 20:32
 * @Description
 * 二叉树
 *
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        //System.out.println(root.val + " ");
        list.add(root.val);

        List<Integer> left = preorderTraversal(root.left);
        list.addAll(left);

        List<Integer> right = preorderTraversal(root.right);
        list.addAll(right);

        return list;
    }
}
public class BinaryTree2 {

}
