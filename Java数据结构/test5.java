//二叉树练习3

//二叉树最大宽度
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int maxW = 0;
    
    public int widthOfBinaryTree(TreeNode root) {
        widthOfBinaryTreeChild(root, 1, 1, new ArrayList<>());
        return maxW;
    }
    
    private void widthOfBinaryTreeChild(TreeNode r, int level, int index, List<Integer> left) {
        if(r == null) return;
        if(level > left.size()) left.add(index);
        maxW = Math.max(maxW, index - left.get(level-1) + 1);
        widthOfBinaryTreeChild(r.left, level+1, index*2, left);
        widthOfBinaryTreeChild(r.right, level+1, index*2+1, left);
    }
}

//二叉树的完全性检验
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        TreeNode cur;
        q.addLast(root);
        while ((cur = q.removeFirst()) != null) {
            q.addLast(cur.left);
            q.addLast(cur.right);
        }
        while (!q.isEmpty()) {
            if (q.removeLast() != null) {
                return false;
            }
        }
        return true;
    }
}

//递增顺序查找树
class Solution {
    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        TreeNode head = new TreeNode(-1);
        TreeNode node = head;
        increasingBSTChild(list, root);
        for(int i=0; i<list.size(); i++) {
            node.right = list.get(i);
            node = node.right;
        }
        return head.right;
    }

    private void increasingBSTChild(List list, TreeNode node){
        if(node == null) return;
        increasingBSTChild(list, node.left);
        node.left = null;
        list.add(node);
        increasingBSTChild(list, node.right);
        node.right = null;
    }
}

//合并二叉树
class Solution {
    /*public TreeNode mergeTreesChild(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        // 先合并根节点
        t1.val += t2.val;
        // 再递归合并左右子树
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }*/

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        // 先合并根节点
        TreeNode root = new TreeNode((t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val));
        // 再递归合并左右子树
        root.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        root.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        return root;
    }
}

//把二叉搜索树转换为累加树
class Solution {
    /*int num = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            //遍历右子树
            convertBST(root.right);
            //遍历顶点
            root.val = root.val + num;
            num = root.val;
            //遍历左子树
            convertBST(root.left);
            return root;
        }
        return null;
    }*/

    //非递归写法
    public int preNum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null)
            return root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        //stack.add(root);
        TreeNode node = root;
        while(node != null || !stack.isEmpty()){
            while(node != null){
                stack.add(node);
                node = node.right;
            }
            node = stack.pop();
            node.val += preNum;
            preNum = node.val;
            if(node.left != null)
                node = node.left;
            else
                node = null;
        }
        return root;
    }
}

//二叉树的右视图
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == size - 1) {  //将当前层的最后一个节点放入结果列表
                    res.add(node.val);
                }
            }
        }
        return res;
    }
}

//验证二叉树
class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] cnt = new int[n];
        for(int i=0; i<n; i++) {
            if(leftChild[i] >= 0) {
                cnt[leftChild[i]] += 1;
            }
            if(rightChild[i] >= 0) {
                cnt[rightChild[i]] += 1;
            }
        }
        if(cnt[0] != 0) {
            return false;
        }
        for(int i=1; i<n; i++) {
            if(cnt[i] != 1) {
                return false;
            }
        }
        return true;
    }
}

//输出二叉树
class Solution {
    public List<List<String>> printTree(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(1);
        }
        int depth = getDepth(root);
        int width = (int)(Math.pow(2, depth) - 1);
        width = width > 0 ? width : 1;
        String[][] result = new String[depth][width];
        List<List<String>> res = new LinkedList<>();
        fill(result, 0, 0, width - 1, root);
        for (int i = 0; i < result.length; i++) {
            LinkedList<String> linkedList = new LinkedList<>();
            for (int j = 0; j < result[i].length; j++) {
                if (result[i][j] == null) {
                    linkedList.add("");
                } else {
                    linkedList.add(result[i][j]);
                }
            }
            res.add(linkedList);
        }
        return res;
    }

    public void fill(String[][] ints, int depth, int start, int end, TreeNode node) {
        if (node == null) {
            return;
        }
        int mid = (start + end) / 2;
        ints[depth][mid] = String.valueOf(node.val);
        fill(ints, depth + 1, start, mid - 1, node.left);
        fill(ints, depth + 1, mid + 1, end, node.right);
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left) + 1;
        int right = getDepth(root.right) + 1;
        return right > left ? right : left;
    }
}