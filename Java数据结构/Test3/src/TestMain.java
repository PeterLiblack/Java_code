import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author Li_ZW
 * @Date: 2020/05/13
 * @Time: 18:29
 * @Description
 * 栈和队列
 */
public class TestMain {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);

        System.out.println(myQueue.peek());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.peek());

    }

    public static void main3(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());

    }

    public static void main2(String[] args) {
        MyStack myStack = new MyStack();

        myStack.push(5);
        myStack.push(6);
        myStack.push(7);
        myStack.push(8);

        System.out.println(myStack.peek());
        myStack.pop();
        System.out.println(myStack.peek());
        System.out.println(myStack.size());
        System.out.println(myStack.empty());
    }

    public static void main1(String[] args) {
        //List<Integer> list = new Stack<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(1); // push 入栈
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(19);
        stack.push(20);
        System.out.println(stack.peek()); // peek 找到栈顶元素

        stack.pop();// pop 出栈并且删除栈顶元素
        System.out.println(stack.peek());

        System.out.println(stack.empty()); // empty 判断是否为空
        System.out.println(stack.search(5)); // search 查找
    }
}
