/**
 * @Author Li_ZW
 * @Date: 2020/05/28
 * @Time: 22:10
 * @Description
 */
public class BSTree {
    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public Node root = null;

    public boolean insert(int val) {
        Node node = new Node(val);
        if (root == null) {
            root = node;
            return true;
        }

        Node cur = root;
        Node parent = null;

        while (cur != null) {
            if (cur.val == val) {
                return false;
            }else if (cur.val < val){
                parent = cur;
                cur = cur.right;
            }else {
                parent = cur;
                cur = cur.left;
            }
        }

        if (parent.val > val) {
            parent.left = node;
        }else {
            parent.right = node;
        }
        return true;
    }

    public Node search(int val) {
        Node cur = root;
        while (cur != null) {
            if (cur.val == val) {
                return cur;
            }else if (cur.val < val) {
                cur = cur.right;
            }else {
                cur = cur.left;
            }
        }
        return null;
    }

    public void preOrder(Node root) {
        if(root == null) return;
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public void inOrder(Node root) {
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

    public boolean remove(int key) {
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if(cur.val == key) {
                removeNode(parent,cur);
                return true;
            }else if(key < cur.val) {
                parent = cur;
                cur = cur.left;
            }else {
                parent = cur;
                cur = cur.right;
            }
        }
        return false;
    }

    public void removeNode(Node parent,Node cur) {
        if(cur.left == null) {
            if(cur == root) {
                root = cur.right;
            }else if(cur == parent.left) {
                parent.left = cur.right;
            }else {
                parent.right = cur.right;
            }
        }else if(cur.right == null) {
            if(cur == root) {
                root = cur.left;
            }else if(cur == parent.left) {
                parent.left = cur.left;
            }else {
                parent.right = cur.left;
            }
        }else {
            Node targetParent = cur;
            Node target = cur.right;
            while (target.left != null) {
                targetParent = target;
                target = target.left;
            }
            cur.val = target.val;

            if(target == targetParent.left) {
                targetParent.left = target.right;
            }else {
                targetParent.right = target.right;
            }
        }
    }
}
