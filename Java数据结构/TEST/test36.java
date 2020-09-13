//子数组的最大累加和

public class Solution {
    /**
     * max sum of the subarray
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxsumofSubarray (int[] arr) {
        // write code here
        int curr = 0; //记录当前的和
        int maxVal = arr[0];
        
        for(int i=0;i<arr.length;i++){
            curr += arr[i];
            maxVal = maxVal > curr ? maxVal : curr;
            
        }
        return maxVal;
    }
}




//二叉树的最大路径和
import java.util.*;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 * }
 */

public class Solution {
    int maxValue;
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;     
    }
    private int maxPathDown(TreeNode node){
        if(node==null)
            return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}