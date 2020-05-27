import java.util.ArrayList;

/**
 * @Author Li_ZW
 * @Date: 2020/05/27
 * @Time: 16:26
 * @Description
 * 写一个通用的方法
 * 打印集合当中的所有元素
 *
 * 通配符：也是一种泛型
 * 通配符一般用于读取 add(?)
 * 泛型一般用于写入  add(T)
 *
 * 通配符 既有上界 也有下界
 *       extends  super
 */

class GenericList {
    public static <T> void printList(ArrayList<T> list) {
        for (T val : list) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void printList2(ArrayList<?> list) {
        for (Object val : list) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}

public class TestDemo4 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        GenericList.printList2(list);
    }
}
