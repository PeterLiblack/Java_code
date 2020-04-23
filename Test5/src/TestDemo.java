/**
 * @Author Li_ZW
 * @Date: 2020/04/21
 * @Time: 14:29
 * @Description
 * 顺序表和链表
 * 1.线性表
 * 线性表（linear list）是n个具有相同特性的数据元素的有限序列。
 * 2.顺序表
 * 顺序表是用一段物理地址连续的存储单元依次存储数据元素的线性结构，一般情况下采用数组存储。
 * 3.链表
 * 链表是一种物理存储结构上非连续存储结构，数据元素的逻辑顺序是通过链表中的引用链接次序实现的 。
 * 4.顺序表和链表的区别和联系
 */

public class TestDemo {
    public static void main(String[] args) {
        LinkedList myLinkedList1 = new LinkedList();

        //myLinkedList1.addFirst(12);
        for (int i = 0; i < 10; i++) {
            myLinkedList1.addFirst(10);
            myLinkedList1.addFirst(20);
            myLinkedList1.addFirst(30);
        }
        myLinkedList1.display();
        System.out.println(myLinkedList1.size());
    }

    public static void main1(String[] args) {
        SeqList mySeqList1 = new SeqList();
        /*mySeqList1.add(0,12);
        mySeqList1.add(1,23);
        mySeqList1.add(2,34);
        mySeqList1.add(3,45);
        mySeqList1.display();*/

        //打印顺序表
        for (int i = 0; i < 10; i++) {
            mySeqList1.add(i, i);
        }
        mySeqList1.display();

        //增加
        mySeqList1.add(10,10);
        mySeqList1.display();

        //删除
        mySeqList1.remove(4);
        mySeqList1.display();

        //清除
        /*mySeqList1.clear();
        mySeqList1.display();*/

        //获取
        System.out.println(mySeqList1.getPos(4));
        mySeqList1.display();

        System.out.println("==============");

        //查找
        System.out.println(mySeqList1.search(51));

        //判断
        System.out.println(mySeqList1.contains(15));
    }

}