//二叉树进阶练习(一)
//二叉树的构建及遍历
import java.util.Scanner;

class TreeNord {
	char val;
	TreeNode left;
	TreeNode right;
	public TreeNode(char val) {
		this.val = val;
	} 
}

public class Main {
	public static int i = 0;
    public static TReeNode buildTree(String str) {
        TreeNode root = null;
        if (str.charAt(i) != '#') {
            root = new TreeNode(str.charAt(i));
            i++;
            root.left = buildTree(str);
            root.right = buildTree(str);
        }else {
            i++;
        }
        return root;
    }

    public static void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOderTraversal(root.left);
        System.out.print(root.val + " ");
        inOderTraversal(root.right);
    }

    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	String str = scan.buildTree(str);
    	inOrderTraversal(root);	
    }
}

//二叉树的分层遍历
public List<List<Integer>> levelOrder(Node root) {
	List<List<Integer>> ret = new LinkedList<>();
    if (root == null) {
        return;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
    	//1，求当前队列的大小 size
    	int size = queue.size();
    	List<Integer> list = new ArrayList<>();

    	//2，while（size>0） 控制当前每一层的数据个数
    	while(size > 0) {
    		Node cur = queue.poll();
    		if (cur != null) {
    			list.add(cur.val);
    			if (cur.left != null) {
    				queue.offer(cur.left);
    			}
    			if (cur.right != null) {
    				queue.offer(cur.right);
    			}
    		}
    		size--;
    	}
    	ret.add(list);
    }
    return ret;
}

	// 判断一棵树是不是完全二叉树
	boolean isCompleteTree(Node root) {
        if (root == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            }else {
                break;
            }
        }

        while (!queue.isEmpty()) {
            Node cur2 = queue.peek();
            if (cur2 != null) {
                return false;
            }else {
                queue.poll();
            }
        }
        return true;
    }

//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先
class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q) {
		if (root == null) {
			return null;
		}
		if (root == p || root == q) {
			return root;
		}

		TreeNode left = lowestCommonAncestor(root.left,p,q);
		TreeNode right = lowestCommonAncestor(root.right,p,q);

		if (left != null && right != null) {
			return root;
		}else if (left != null) {
			return left;
		}else {
			return right;
		}
	}
}


	
    //前序遍历 根 左 右  递归
    void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    //前序遍历  非递归
    void preOrderTraversalNor(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = root;

        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                System.out.print(cur.val + " ");
                cur = cur.left;
            }

            Node top = stack.pop();
            cur = top.right;
        }

    }

    //中序遍历 左 根 右  递归
    void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }

    //中序遍历  非递归
    void inOrderTraversalNor(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = root;

        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            Node top = stack.pop();
            System.out.print(top.val + " ");
            cur = top.right;
        }
    }

    //后序遍历 左 右 根  递归
    void postOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val + " ");
    }

    //后序遍历  非递归
    void postOrderTraversalNor(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        Node prev = null;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right == null || cur.right == prev) {
                System.out.print(cur.val + " ");
                stack.pop();
                prev = cur;
                cur = null;
            }else {
                cur = cur.right;
            }
        }
    }