import java.util.Arrays;

/**
 * @Author Li_ZW
 * @Date: 2020/05/21
 * @Time: 21:27
 * @Description
 * 堆
 */
public class TestHeap {

    public int[] elem;
    public int usedSize;

    public TestHeap() {
        this.elem = new int[10];
    }

    /**
     *  时间复杂度：O(logn)
     * @param root 每棵子树的开始位置
     * @param len  结束位置
     */
    public void adjustDown(int root,int len) {
        int parent = root;
        int child = 2*parent+1;
        while (child < len) {
            //0、判断是否有左右孩子  有的话 找到最大值 C下标表示最大值下标
            if(child+1 < len && this.elem[child] < this.elem[child+1]) {
                child++;
            }
            //代码指向到这里，c表示最大值下标
            if(this.elem[child] > this.elem[parent]) {
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
        //i：每棵子树的根节点下标
        for (int i = (this.usedSize-1-1)/2; i >= 0 ; i--) {
            adjustDown(i,this.usedSize);
        }
    }

    /**
     * 插入数据：
     * @param val
     */
    public void push(int val) {
        //0、堆是否是满的--》扩容
        if(isFull()) {
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
        }
        //1、放到数组的最后一个位置
        this.elem[this.usedSize] = val;
        this.usedSize++;//11
        //2、进行调整
        adjustUp(this.usedSize-1);
    }
    public void adjustUp(int child) {
        int parent = (child-1)/2;
        while (child > 0) {
            if(this.elem[child] > this.elem[parent]) {
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
    public boolean isFull() {
        return this.usedSize == this.elem.length;
    }

    public void pop() {
        //0、是否是空的
        if(isEmpty()) {
            return;
        }
        //1、最后一个元素和堆顶元素交换
        int tmp = this.elem[0];
        this.elem[0] = this.elem[this.usedSize-1];
        this.elem[this.usedSize-1] = tmp;
        this.usedSize--;//10  9
        //2、调整0号下标这棵树
        adjustDown(0,this.usedSize);
    }

    public boolean isEmpty() {
        return this.usedSize == 0;
    }

    public int peek() {
        if(isEmpty()) {
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
        while (end > 0) {
            int tmp = this.elem[0];
            this.elem[0] = this.elem[end];
            this.elem[end] = tmp;
            adjustDown(0,end);
            end--;
        }//O(n*logn)
    }

    public void show() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }

}

