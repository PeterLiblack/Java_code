/**
 * @Author Li_ZW
 * @Date: 2020/04/25
 * @Time: 10:26
 * @Description
 * 单链表练习
 */
public class TestDemo {
    public static void main(String[] args) {

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(1);
        myLinkedList.addLast(21);
        myLinkedList.addLast(34);
        myLinkedList.addLast(45);
        myLinkedList.addLast(57);
        myLinkedList.addLast(68);
        myLinkedList.disPlay();

        MyLinkedList myLinkedList2 = new MyLinkedList();
        myLinkedList2.addLast(10);
        myLinkedList2.addLast(23);
        myLinkedList2.addLast(33);
        myLinkedList2.addLast(42);
        myLinkedList2.addLast(55);
        myLinkedList2.addLast(60);
        myLinkedList2.disPlay();

        Node ret = MyLinkedList.mergeTwoLists(myLinkedList.head,myLinkedList2.head);
        myLinkedList2.display(ret);

        /*MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(13);
        myLinkedList.addLast(21);
        myLinkedList.addLast(3);
        myLinkedList.addLast(41);
        myLinkedList.addLast(15);
        myLinkedList.addLast(63);
        myLinkedList.disPlay();

        Node ret = myLinkedList.partition(17);
        myLinkedList.display(ret);

        System.out.println(myLinkedList.findKthToTail(6).data);

        Node ret2 = myLinkedList.reverseList();
        myLinkedList.display(ret2);

        System.out.println("删除开始:");
        myLinkedList.removeAllVal(81);
        myLinkedList.disPlay();

        boolean flg = myLinkedList.contains(78);
        System.out.println(flg);

        System.out.println(myLinkedList.contains(78));*/
    }
}
