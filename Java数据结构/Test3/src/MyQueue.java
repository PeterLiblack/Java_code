//import javax.xml.soap.Node;

/**
 * @Author Li_ZW
 * @Date: 2020/05/13
 * @Time: 19:41
 * @Description
 * 自定义队列
 */

class Node {
    public int data;
    public Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(int data) {
        this.data = data;
    }
}

public class MyQueue {
    public int usedSize;
    public Node front;
    public Node rear;

    public boolean offer(int val) {
        Node node = new Node(val);
        if (this.rear == null) {
            this.front = node;
            this.rear = node;
        }else {
            this.rear.next = node;
            this.rear = node;
        }
        this.usedSize++;
        return true;
    }

    //出队且删除队头元素
    public int poll() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！");
        }
        int data = this.front.data;
        this.front = this.front.next;
        return data;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！");
        }
        return this.front.data;
    }

    public boolean isEmpty() {
        return this.usedSize == 0;
    }

    public int size() {
        return this.usedSize;
    }

}
