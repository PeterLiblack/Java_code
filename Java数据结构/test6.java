import java.util.Arrays;
import java.util.Random;

/**
 * 堆
 * 
 */
public class TestHeap {

	public int[] elem;
	public int usedSize;

	public TestHeap() {
		this.elem = new int[10]
	}

	/**
	 * 时间复杂度：O(logn)
	 * 
	 * @param root [每颗子树的开始位置]
	 * @param len  [结束位置]
	 */
	public void adjustDown(int root,int len) {
		int parent = root;
		int child = 2*parent+1;
		while(child < len) {
			//判断是否有左右孩子 
			//有的话 找到最大值 c下标表示最大值下标
			if (child+1 < len && this.elem[child] < this.elem[child+1]) {
				child++;
			}
			//走到这 c表示最大值下标
			if (this.elem[child] > this.elem[parent]) {
				//交换
				int tmp = this.elem[child];
				this.elem[child] = this.elem[parent];
				this.elem[parent] = tmp;
				parent = child;
				child = 2*parent+1;
			}else {
				break;
			}
		}
	}

	//O(n)
	public void createHeap(int[] array) {
		for (int i = 0; i < array.length; i++) {
			this.elem[i] = array[i];
			this.usedSize++;
		}
		//i:每棵树的根节点下标
		for (int i = (this.usedSize-1-1)/2; i >= 0; i--) {
			adjustDown(i,this.usedSize);
		}
	}

	/**
	 * 插入数据
	 * @param val [插入的值]
	 */
	public void push(int val) {
		//堆是否满——》扩容
		if (isFull()) {
			this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
		}
		//放到数组最后一个位置
		this.elem[this.usedSize] = val;
		this.usedSize++;
		//进行调整
		adjustUp(this.usedSize-1);
	}

	public void adjustUp(int child) {
		int parent = (child-1)/2;
		while(child > 0) {
			if (this.elem[child] > this.elem[parent]) {
				int tmp = this.elem[child];
				this.elem[child] = this.elem[parent];
				this.elem[parent] = tmp;
				child = parent;
				parent = (child-1)/2;
			}else {
				break;
			}
		}
	}

	//删除第一个元素 堆顶
	public boolean isFull() {
		return this.usedSize == this.elem.length;
	}

	public void pop() {
		//是否为空
		if (isEmpty()) {
			return;
		}
		//最后一个元素和堆顶元素交换
		int tmp = this.elem[0];
		this.elem[0] = this.elem[this.usedSize-1];
		this.elem[this.usedSize-1] = tmp;
		this.usedSize--;
		//调整0号下标这棵树
		adjustDown(0,this.usedSize);
	}

	public boolean isEmpty() {
		return this.usedSize == 0;
	}

	public int peek() {
		if (isEmpty()) {
			return -1;
		}
		return this.elem[0];
	}

	/**
	 * 时间复杂度：O(n*logn)
	 * 空间复杂度：O(1)
	 */
	public void heapSort() {
		int end = this.usedSize-1;
		while(end > 0) {
			int tmp = this.elem[0];
			this.elem[0] = this.elem[end];
			this.elem[end] = tmp;
			adjustDown(0,end);
			end--;
		}
	}

	public void show() {
		for (int i = 0; i < this.usedSize; i++) {
			System.out.print(this.elem[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		TestHeap testHeap = new TestHeap();
		int[] array = {27,15,19,18,28,34,65,49,25,37};
		//创建一个堆 大根堆
		testHeap.createHeap(array);
		testHeap.show();
		//插入一个元素
		testHeap.push(80);
		testHeap.show();
		//拿到堆顶元素
		testHeap.pop();
		testHeap.show();
		//排序
		testHeap.heapSort();
		testHeap.show()
	}
}

/**
 * 基于比较的几种排序
 */
public class TestSort {

	/**
	 * 直接插入排序
	 * 时间复杂度：
	 * 最坏情况：O(n^2)  最好情况：O(n)
	 * 越有序越快
	 * 空间复杂度：O(1)
	 * 稳定性：稳定的排序
	 * @param array [description]
	 */
	public static void insertSort(int[] array) {
		int tmp = 0;
		for (int i = 1; i < array.length; i++) {
			tmp = array[i];
			int j;
			for (j = i-1; j >= 0; j--) {
				if (array[j] > tmp) {
					array[j+1] = array[j];
				}else {
					break;
				}
			}
			array[j+1] = tmp;
		}
	}

	public static void main9(String[] args) {
		int[] array = new int[10_0000];
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
			//array[i] = random.nextInt(10_0000);//随机数
		}
		long start = System.currentTimeMillis();
		insertSort(array);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	public static void main8(String[] args) {
		int[] array = {12,5,9,34,6,8,33,56,89,0,7,4,22,55,77};
		System.out.println(Arrays.toString(array));
		insertSort(array);
		System.out.println(Arrays.toString(array));
	}

	/**
	 * 希尔排序
	 * 时间复杂度：O(n^2)
	 * 空间复杂度：O(1)
	 * 稳定性：不稳定排序
	 * @param array [description]
	 * @param gap   [description]
	 */
	public static void shell(int[] array,int gap) {
		int tmp = 0;
		for (int i = gap; i < array.length; i+=1) {
			tmp = array[i];
			int j;
			for (j = i-gap; j >= 0; j-=gap) {
				if (array[j] > tmp) {
					array[j+gap] = array[j];
				}else {
					break;
				}
			}
			array[j+gap] = tmp;
		}
	}

	public static void shellSort(int[] array) {
		int[] drr = {5,3,1};
		for (int i = 0; i < drr.length; i++) {
			shell(array,drr[i]);
		}
	}

	public static void main7(String[] args) {
		int[] array = new int[10_0000];
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
			//array[i] = random.nextInt(10_0000);//随机数
		}
		long start = System.currentTimeMillis();
		shellSort(array);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	public static void main6(String[] args) {
		int[] array = {12,5,9,34,6,8,33,56,89,0,7,4,22,55,77};
		System.out.println(Arrays.toString(array));
		shellSort(array);
		System.out.println(Arrays.toString(array));
	}


	/**
	 * 选择排序
	 * 时间复杂度：O(n^2)
	 * 空间复杂度：O(1)
	 * 稳定性：不稳定排序
	 * @param array [description]
	 */
	public static void selectSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i+1; j < array.length; j++) {
				if (array[j] < array[i]) {
					int tmp = array[j];
					array[j] = array[i];
					array[i] = tmp;
				}
			}
		}
	}

	public static void main5(String[] args) {
		int[] array = new int[10_0000];
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
			//array[i] = random.nextInt(10_0000);//随机数
		}
		long start = System.currentTimeMillis();
		selectSort(array);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	public static void main4(String[] args) {
		int[] array = {12,5,9,34,6,8,33,56,89,0,7,4,22,55,77};
		System.out.println(Arrays.toString(array));
		selectSort(array);
		System.out.println(Arrays.toString(array));
	}

	public static void adjustDown(int[] array,int root,int len) {
		int parent = root;
		int child = 2*parent+1;
		while(child < len) {
			//最起码有左孩子
			if (child+1 < len && array[child] < array[child+1]) {
				child++;
			}
			if (array[child] > array[parent]) {
				int tmp = array[child];
				array[child] = array[parent];
				array[parent] = tmp;
				parent = child;
				child = 2*parent+1;
			}else {
				break;
			}
		}
	}

	public static void createHeap(int[] array) {
		for (int i = (array.length-1-1)/2; i >= 0; i--) {
			adjustDown(array,i,array.length);
		}
	}


	/**
	 * 堆排序
	 * 时间复杂度：O(n*logn)
	 * 不管有序还是无须都是
	 * 空间复杂度：O(1)
	 * 稳定性：不稳定排序
	 * @param array [description]
	 */
	public static void heapSort(int[] array) {
		createHeap(array);
		int end = array.length-1;
		while(end > 0) {
			int tmp = array[0];
			array[0] = array[end];
			array[end] = tmp;
			adjustDown(array,0,end);
			end--;
		}
	}

	public static void main3(String[] args) {
		int[] array = new int[10_0000];
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
			//array[i] = random.nextInt(10_0000);//随机数
		}
		long start = System.currentTimeMillis();
		heapSort(array);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	public static void main2(String[] args) {
		int[] array = {12,5,9,34,6,8,33,56,89,0,7,4,22,55,77};
		System.out.println(Arrays.toString(array));
		heapSort(array);
		System.out.println(Arrays.toString(array));
	}

	/**
	 * 冒泡排序
	 * 时间复杂度：O(n^2)
	 * 空间复杂度：O(1)
	 * 稳定性：稳定的排序
	 * @param array [description]
	 */
	public static void bubbleSort(int[] array) {
		//i表示趟数
		for (int i = 0; i < array.length-1; i++) {
			for (int j = 0; j < array.length-1-i; j++) {
				if (array[j] > array[j+1]) {
					int tmp = array[j];
					array[j] = array[j+1];
					array[j+1] = tmp;
				}
			}
		}
	}

	public static void bubbleSort1(int[] array) {
		boolean flg = false;

		for (int i = 0; i < array.length-1; i++) {
			flg = false;
			for (int j = 0; j < array.length-1-i; j++) {
				if (array[j] > array[j+1]) {
					int tmp = array[j];
					array[j] = array[j+1];
					array[j+1] = tmp;
					flg = true;
				}
			}
			if (flg == false) {
				return;
			}
		}
	}

	public static void main1(String[] args) {
		int[] array = new int[10_0000];
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
			//array[i] = random.nextInt(10_0000);//随机数
		}
		long start = System.currentTimeMillis();
		bubbleSort(array);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	public static void main(String[] args) {
		int[] array = {12,5,9,34,6,8,33,56,89,0,7,4,22,55,77};
		System.out.println(Arrays.toString(array));
		bubbleSort(array);
		System.out.println(Arrays.toString(array));
	}
}


/**
 * 二叉树相关
 */

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