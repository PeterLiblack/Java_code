/**
 * @Author Li_ZW
 * @Date: 2020/04/26
 * @Time: 19:00
 * @Description
 * 双向链表
 */
public class TestDemo {
    public static void main(String[] args) {
        MyLinklist myLinklist = new MyLinklist();
        myLinklist.addFirst(1);
        myLinklist.addFirst(2);
        myLinklist.addFirst(3);
        myLinklist.addFirst(4);
        myLinklist.addFirst(4);
        myLinklist.addFirst(4);
        myLinklist.addFirst(4);
        myLinklist.addFirst(4);

        myLinklist.display();
        myLinklist.addIndex(0,99);
        myLinklist.display();
        myLinklist.addIndex(5,199);
        myLinklist.display();
        myLinklist.addIndex(2,999);
        myLinklist.display();
        myLinklist.removeAllKey(4);
        myLinklist.display();

        myLinklist.clear();
        myLinklist.display();

        /*myLinklist.addLast(1);
        myLinklist.addLast(2);
        myLinklist.addLast(3);
        myLinklist.addLast(4);
        myLinklist.display();

        System.out.println(myLinklist.contains(4));
        System.out.println(myLinklist.size());*/

    }
}
