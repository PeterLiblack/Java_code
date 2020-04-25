/**
 * @Author Li_ZW
 * @Date: 2020/04/25
 * @Time: 8:46
 * @Description
 * 单链表功能实现
 */
class Node{
    public int date;
    public Node next;
    public Node(int date) {
        this.date = date;
        this.next = null;
    }
}

public class MyLinkedList {
    public Node head; //保存单链表的头结点的引用
    //头插法
    public void addFirst(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            //第一次插入节点
            this.head = node;
            return;
        }
        node.next = this.head;
        this.head = node;
    }

    //尾插法
    public void addLast(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
            return;
        }
        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    //任意位置插入，第一个数据节点为0号下标
    public void addIndex(int index,int data) {
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == this.size()) {
            addLast(data);
            return;
        }
        Node node = new Node(data);
        //先找到index位置的前一个节点的地址
        Node cur = searchIndex(index);
        //进行插入
        node.next = cur.next;
        cur.next = node;
    }
    private Node searchIndex(int index) {
        //1,对index进行合法性检查
        if (index < 0 || index >this.size()) {
            throw new RuntimeException("index位置不合法！");
        }
        Node cur = this.head; //index-1
        while (index - 1 != 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contain(int key) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.date == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //得到单链表长度
    public int size() {
        int count = 0;
        Node cur = this.head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
    private Node searchPrev(int key) {
        Node prev = this.head;
        while (prev.next != null) {
            if (prev.next.date != key) {
                return prev;
            } else {
                prev = prev.next;
            }
        }
        return null;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        if (this.head == null) {
            return;
        }
        //删除的是不是头结点
        if (this.head.date == key) {
            this.head = this.head.next;
            return;
        }
        //找到删除节点的前驱
        Node prev = searchPrev(key);
        if (prev == null) {
            System.out.println("根本没有这个节点！");
            return;
        }
        //开始删除
        Node del = prev.next;
        prev.next = del.next;
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        Node prev = this.head;
        Node cur = this.head.next;//代表要删除的节点
        while (cur != null) {
            if (cur.date == key) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        if (this.head.date == key) {
            this.head = this.head.next;
        }
    }

    //打印单链表
    public void disPlay() {
        Node cur = this.head;
        while (cur != null) {
            System.out.println(cur.date + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //释放内存
    public void clear() {
        this.head = null;
    }

 /*   public Node reverseList() {
        Node cur = this.head;
        Node prev = null;
        Node newHead = null;
        while (cur != null) {
            Node curNext = cur.next;
            if (curNext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }

    public void display(Node newHead) {
        Node cur = newHead;
        while (cur != null) {
            System.out.println(cur.date + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public Node middleNode() {
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }*/
}
