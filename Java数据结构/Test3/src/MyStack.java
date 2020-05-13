import java.util.Arrays;

/**
 * @Author Li_ZW
 * @Date: 2020/05/13
 * @Time: 18:35
 * @Description
 * 编写一个自己的栈方法
 */

public class MyStack {
    public int[] elem; //数组
    public int top; //表示当前可以存放数据元素的下标

    public MyStack() {
        this.elem = new int[10];
    }

    public void push(int data) {
        if (full()) {
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
        }

        this.elem[this.top++] = data;

    }

    public boolean empty() {
        return this.top == 0;
    }

    public boolean full() {
        return this.top == this.elem.length;

    }

    public int pop() {

        if (empty()) {
            throw new RuntimeException("栈空！");
        }
        int data = this.elem[this.top-1];
        this.top--;
        return data;
    }

    public int peek() {
        if (empty()) {
            throw new RuntimeException("栈空！");
        }
        return this.elem[this.top-1];
    }

    public int size() {

        return this.top;
    }
}
