//完整定义一份泛型类支持的搜索树
import java.unil.*;

public class BSTree<K extends Comparable<K>, V> {
	private static class Entry<K, V> {
		private K key;
		private V value;
		private Entry<K, V> left = null;
		private Entry<K, V> right = null;

		private Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public String toString() {
			return String.format("{%s=%s}", key, value);
		}
	}

	private Entry<K, V> root = null;

	public V get(K key) {
		Entry<K, V> cur = root;
		while (cur != null) {
			int r = key.compareTo(cur.key);
			if (r == 0) {
				return cur.value;
			}else if (r < 0) {
				cur = cur.left;
			}else {
				cur = cur.right;
			}
		}

		return null;
	}

	public V put(K key, V value) {
		if (root == null) {
			root = new Entry<>(key, value);
			return null;
		}

		Entry<K, V> parent = null;
		Entry<K, V> cur = root;
		while(cur != null) {
			int r = key.compareTo(cur.key);
			if (r == 0) {
				V oldValue = cur.value;
				cur.value = value;
			}else if (r < 0) {
				parent = cur;
				cur = cur.left;
			}else {
				parent = cur;
				cur = cur.right;
			}
		}

		Entry<K, V> entry = new Entry<>(key, value);
		if (key.compareTo(parent.key) < 0) {
			parent.left = entry;
		}else {
			parent.right = entry;
		}

		return null;
	}

	public V remove(K key) {
		Entry<K, V> parent = null;
		Entry<K, V> cur = root;
		while(cur != null) {
			int r = key.compareTo(cur.key);
			if (r == 0) {
				V oldValue = cur.value;
				removeEntry(parent,cur);
				return oldValue;
			}else if (r < 0) {
				parent = cur;
				cur = cur.left;
			}else {
				parent = cur;
				cur = cur.right;
			}
		}

		return null;
	}

	private void removeEntry(Entry<K, V> parent, Entry<K, V> cur) {
		if (cur.left == null) {
			if (cur == root) {
				root = cur.right;
			}else if (cur == parent.left) {
				parent.left = cur.right;
			}else {
				parent.right = cur.right;
			}
		}else if (cur.right == null) {
			if (cur == root) {
				root = cur.left;
			}else if (cur == parent.left) {
				parent.left = cur.left;
			}else {
				parent.right = cur.left;
			}
		}else {
			Entry<K, V> gParent = cur;
			Entry<K, V> goat = cur.left;
			while(goat.right != null) {
				gParent = goat;
				goat = goat.right;
			}
			cur.key = goat.key;
			cur.value = goat.value;
			if (goat == gParent.left) {
				gParent.left = goat.left;
			}else {
				gParent.right = goat.left;
			}
		}
	}

	public static interface Function<T> {
		void apply(T entry);
	}

	public static <K, V> void preOrderTraversal(Entry<K, V> node, Function<Entry<K, V>> func) {
		if (node != null) {
			func.apply(node);
			preOrderTraversal(node.left, func);
			preOrderTraversal(node.right, func);
		}
	}

	public static <K, V> void inOrderTraversal(Entry<K, V> node, Function<Entry<K, V>> func) {
		if (node != null) {
			inOrderTraversal(node.left, func);
			func.apply(node);
			inOrderTraversal(node.right, func);
		}
	}

	public void print() {
		System.out.println("前序遍历：");
		preOrderTraversal(root, (n) -> {
			System.out.print(n.key + " ");
		});
		System.out.println();
		System.out.println("中序遍历：");
		inOrderTraversal(root, (n) -> {
			System.out.print(n.key + " ");
		});
		System.out.println();
	}

	public static void main(String[] args) {
		BSTree<Integer, String> tree = new BSTree<>();
		int count = 0;
		Random random = new Random(20200529);
		for (int i = 0; i < 20; i++) {
			int key = random.nextInt(200);
			String value = String.format("value of %d", key);
			if (tree.put(key. value) == null) {
				count++;
			}
		}
		System.out.println("一共插入 " + count + " 个结点");
		tree.print();
	}
} 


//二叉搜索树
public class BinarySearchTree {
	public static class Node {
		int key;
		Node left;
		Node right;

		public Node(int key) {
			this.key = key;
		}
	}

	private Node root = null;

	/**
	 * 在搜索树中查找 key，如果找到，返回 key 所在的节点
	 * 否则返回null
	 * @param  key [description]
	 * @return     [description]
	 */
	public Node search(int key) {
		Node cur = root;
		while(cur != null) {
			if (key == cur.key) {
				return cur;
			}else if (key < cur.key) {
				cur = cur.left;
			}else {
				cur = cur.right;
			}
		}

		return null;
	}

	/**
	 * 插入
	 * @param  key [description]
	 * @return true  表示插入成功
	 *         false 表示插入失败   
	 */
	public boolean insert(int key) {
		if (root == null) {
			root = new Node(key);
			return true;
		}

		Node cur = root;
		Node parent = null;
		while(cur != null) {
			if (key == cur.key) {
				return false;
			}else if (key < cur.key) {
				parent = cur;
				cur = cur.left;
			}else {
				parent = cur;
				cur = cur.right;
			}
		}

		Node node = new Node(key);
		if (key < parent.key) {
			parent.left = node;
		}else {
			parent.right = node;
		}
		return true;
	}

	/**
	 * 删除
	 * @param  key [description]
	 * @return  true  表示删除成功
	 *          false 表示删除失败 
	 */
	public boolean remove(int key) {
		Node cur = root;
		Node parent = null;
		while(cur != null) {
			if (key == cur.key) {
				removeNode(parent,cur);
				return true;
			}else if (key < cur.key) {
				parent = cur;
				cur = cur.left;
			}else {
				parent = cur;
				cur = cur.right;
			}
		}

		return false;
	}

	private void removeNode(Node parent, Node cur) {
		if (cur.left == null) {
			if (cur == root) {
				root = cur.right;
			}else if (cur == parent.left) {
				parent.left = cur.right;
			}else {
				parent.right = cur.right;	
			}
		}else if (cur.right == null) {
			if (cur == root) {
				root = cur.left;
			}else if (cur == parent.left) {
				parent.left = cur.left;
			}else {
				parent.right = cur.left;
			}
		}else {
			Node goatParent = cur;
			Node goat = cur.right;
			while(goat.left != null) {
				goatParent = goat;
				goat = goat .left;
			}

			cur.key = goat.key;

			if (goat == goatParent.left) {
				goatParent.left = goat.right;
			}else {
				goatParent.right = goat.right;
			}
		}
	}

	public static void main(String[] args) {
		//1. 创建搜索树
		//2. 随机插入
		//3. 打印前序 + 中序遍历
		//4. 查找
		BinarySearchTree tree = new BinarySearchTree();
		int[] keys = {3,9,7,4,1,6,2,8,5};
		for (int key : keys) {
			System.out.println(tree.insert(key));
		}

		System.out.println("插入重复数据");
		System.out.println(tree.insert(7));

		System.out.println("前序遍历");
		preOrder(tree.root);

		System.out.println("中序遍历");
		inOrder(tree.root);

		System.out.println(tree.search(7).key);
		System.out.println(tree.search(8).key);
		System.out.println(tree.search(5).key);
	}

	private static void inOrder(Node node) {
		if (node != null) {
			inOrder(node.left);
			System.out.println(node.key);
			inOrder(node.right);
		}
	}

	private static void preOrder(Node node) {
		if (node != null) {
			System.out.println(node.key);
			preOrder(node.left);
			preOrder(node.right);
		}
	}
}