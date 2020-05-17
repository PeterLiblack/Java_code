//二叉树基础练习
//
//二叉树的前序遍历
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(Integer.valueOf(node.val));
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }
}

//二叉树中序遍历
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()) {
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    cur = stack.pop();
                    list.add(cur.val);
                    cur = cur.right;
                }
            }
            return list;
    }
}

//二叉树的后序遍历
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        TreeNode p = root,r = null;
        List<Integer>ans = new ArrayList();
        Deque<TreeNode>s = new ArrayDeque();
        while(!s.isEmpty() || p != null) {
            if(p != null) {
                s.push(p);
                p = p.left;
            }else {
                p = s.peek();
                if(p.right == null || p.right == r) {
                    ans.add(p.val);
                    r = p;
                    s.pop();
                    p = null;
                }else {
                    p = p.right; 
                }                 
            }           
        }   
        return ans;
    }
}

//检查两颗树是否相同
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        return (p.val == q.val) && isSameTree(q.left,p.left) && isSameTree(q.right,p.right);
    }
}

//另一颗树的子树
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        } 
        return subFrom(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    public boolean subFrom(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return subFrom(s.left, t.left) && subFrom(s.right, t.right);
    }
}

// 二叉树最大深度
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }  
        
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        return leftHeight > rightHeight ? leftHeight+1 : rightHeight+1;
    }
}

// 判断一颗二叉树是否是平衡二叉树
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }

        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        return Math.abs(leftHeight-rightHeight) < 2 &&
        isBalanced(root.left) && isBalanced(root.right);
    }

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }  
        
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        return leftHeight > rightHeight ? leftHeight+1 : rightHeight+1;
    }
}

//对称二叉树
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isSymmetricChild(root.left,root.right);
    }

    boolean isSymmetricChild(TreeNode leftTree,TreeNode rightTree) {
        if((leftTree != null && rightTree == null) || (leftTree == null && rightTree != null)) {
            return false;
        }
        
        if(leftTree == null && rightTree == null) {
            return true;
        }

        if(leftTree.val == rightTree.val) {
            return isSymmetricChild(leftTree.left,rightTree.right) &&
            isSymmetricChild(leftTree.right,rightTree.left);
        }
        return false;
    }
}
