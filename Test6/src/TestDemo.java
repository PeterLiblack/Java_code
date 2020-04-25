/**
 * @Author Li_ZW
 * @Date: 2020/04/25
 * @Time: 08:40
 * @Description
 * 单链表基础
 *
 */


public class TestDemo {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(1);
        myLinkedList.addLast(2);
        myLinkedList.addLast(3);
        myLinkedList.addLast(4);
        myLinkedList.addLast(5);
        myLinkedList.addLast(6);
        myLinkedList.disPlay();

        /*System.out.println(myLinkedList.middleNode().date);

        Node ret = myLinkedList.reverseList();
        myLinkedList.display(ret);
        System.out.println("删除开始：");
        myLinkedList.removeAllKey(81);
        myLinkedList.disPlay();
        boolean flg = myLinkedList.contain(78);
        System.out.println(flg);

        System.out.println(myLinkedList.contain(78));*/

        System.out.println(myLinkedList.size());
    }
}
