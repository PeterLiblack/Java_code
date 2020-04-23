import java.util.Arrays;

/**
 * @Author Li_ZW
 * @Date: 2020/04/21
 * @Time: 14:35
 * @Description
 * 顺序表的接口实现
 */
public class SeqList {
    public int[] elem; //数组
    public int usedSize; //有效的数据个数
    public static final int intCapacity = 10; //初始容量
    public SeqList() {
        this.elem = new int[intCapacity];
        this.usedSize = 0;
    }

    // 打印顺序表
    public void display() {
        for (int i = 0; i < this.usedSize ; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }

    private boolean isFull() {
        return this.usedSize == this.elem.length;
    }
    private void checkPos(int pos) {
        if (pos < 0 || pos > this.usedSize) {
            throw new RuntimeException("pos位置不合法！");
        }
    }
    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        checkPos(pos);
        if (isFull()) {
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
        }
        //挪数据
        for (int i = this.usedSize - 1; i >= pos; i--) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
    }

    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }

    // 查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    private boolean isEmpty() {
        return this.usedSize == 0;
    }
    // 获取 pos 位置的元素
    public int getPos(int pos) {
        //顺序表是否为空
        if (isEmpty()) {
            throw new RuntimeException("顺序表为空！");//手动抛出异常
        }
        //pos合法性
        if (pos < 0 || pos >= this.usedSize) {
            throw new RuntimeException("pos位置不合法！");
        }
        return this.elem[pos];
    }

    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {
        if (pos < 0 || pos >= this.usedSize) {
            throw new RuntimeException("pos位置不合法！");
        }
        this.elem[pos] = value;
    }

    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        int index = search(toRemove);
        if (index == -1) {
            System.out.println("没有需要删除的数字！");
            return;
        }
        for (int i = index; i < this.usedSize-1; i++) {
            this.elem[i] = this.elem[i+1];
        }
        this.usedSize--;
    }

    // 获取顺序表长度
    public int size() {
        return this.usedSize;
    }

    // 清空顺序表
    public void clear() {
        this.usedSize = 0;
    }

}
