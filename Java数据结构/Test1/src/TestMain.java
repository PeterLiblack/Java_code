import java.util.*;

/**
 * @Author Li_ZW
 * @Date: 2020/05/11
 * @Time: 10:31
 * @Description
 * 集合框架及背后的数据结构
 *
 * 包装类
 */

public class TestMain {

    public static void main(String[] args) {
        Integer a = 127;
        Integer b = 127;

        Integer c = 128;
        Integer d = 128;

        System.out.println(a == b);
        System.out.println(c == d);
    }

    public static void main4(String[] args) {
        Integer a = 10; //自动装箱

        int b = a; //自动拆箱

        System.out.println(a);
        System.out.println(b);
    }

    public static void main3(String[] args) {
        int i = 10;
        //装箱操作，新建一个 Integer 类型对象，将 i 的值放入对象的某个属性中
        Integer ii = Integer.valueOf(i);
        Integer ij = new Integer(i);
        System.out.println(ii);
        System.out.println(ij);

        //拆箱操作，将 Integer 对象中的值取出，放到一个基本数据类型中
        int j = ii.intValue();
        double d = ii.doubleValue();
        System.out.println(d);
    }

    public static void main2(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("西游记","吴承恩");
        map.put("水浒传","施耐庵");
        map.put("三国演义","罗贯中");
        map.put("红楼梦","曹雪芹");
        System.out.println(map);

        String s = map.getOrDefault("西游记2","li");
        System.out.println(s);

        System.out.println(map.containsKey("西游记"));
        System.out.println(map.containsValue("吴承恩"));

        System.out.println("==============");

        Set<Map.Entry<String,String>> set = map.entrySet();
        for (Map.Entry<String,String> entry: set
             ) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }

    public static void main1(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("C");
        collection.add("Java");
        collection.add("学习");
        collection.add("工作");
        System.out.println(collection);

        System.out.println("==============");
        for (String s:collection
             ) {
            System.out.println(s);
        }
        /*collection.clear();
        System.out.println(collection);*/

        System.out.println(collection.isEmpty());
        collection.remove("Java");
        System.out.println(collection);
        System.out.println(collection.size());

        Object[] objects = collection.toArray();
        System.out.println(Arrays.toString(objects));
    }
}
