/**
 * @Author Li_ZW
 * @Date: 2020/05/27
 * @Time: 15:57
 * @Description
 * 泛型：
 * 1，<T>:T占位符 表示当前类是 泛型类
 * 2，放数据的时候，可以自动进行类型检查
 * 3，取数据的时候，可以自动进行类型转换
 * 4，泛型的编译
 *      泛型是在编译时期的一种机制——》擦除机制
 *      编译的时候，按照Object编译
 *      不是替换成Object
 * 5，泛型是有边界的
 *
 * 注意：
 * 1，不能new泛型类型的数组
 * 2，简单类型不能作为泛型类型的参数
 * 3，泛型类型的参数，不参与类型的组成
 */

class Person {

}

class MyStack<T> {
    public T[] elem;
    public int top;

    public MyStack() {
        this.elem = (T[])new Object[10];
    }

    public void push(T val) {
        this.elem[this.top] = val;
        this.top++;
    }

    public T peek() {
        return this.elem[this.top-1];
    }
}

public class TestDemo2 {

    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person);
        MyStack<Integer> myStack = new MyStack<>();
        System.out.println(myStack);
        MyStack<String> myStack1 = new MyStack<>();
        System.out.println(myStack1);
    }

    public static void main2(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(10);
        myStack.push(20);

        int ret = myStack.peek();
        System.out.println(ret);

        MyStack<String> myStack1 = new MyStack<>();
        myStack1.push("abcd");
        myStack1.push("efgh");

        String ret1 = myStack1.peek();
        System.out.println(ret1);
    }

    public static void main1(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(10);
        myStack.push("hello");

        String ret = (String)myStack.peek();
        System.out.println(ret);
    }
}
