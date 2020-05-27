import java.util.*;

/**
 * @Author Li_ZW
 * @Date: 2020/05/27
 * @Time: 16:34
 * @Description
 * 大数据处理
 * map  set
 */

public class TestDemo5 {

    public int singleNumber(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (hashSet.contains(nums[i])) {
                hashSet.remove(nums[i]);
            }else {
                hashSet.add(nums[i]);
            }
        }
        Iterator<Integer> it = hashSet.iterator();
        return it.next();
    }

    /**
     * 统计10w个数据中 重复数字及出现的次数
     * @param args
     */
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10_0000; i++) {
            list.add(random.nextInt(6000));
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        //key --> 关键字重复的数字
        //value--> 重复的数字出现的次数
        for (Integer key : list) {
            if(map.get(key) == null) {
                map.put(key,1);
            }else {
                Integer val = map.get(key);
                map.put(key,val+1);
            }
        }

        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey()+"这个数字出现了"+entry.getValue()+"次！");
        }
    }

    /**
     * 去除10w个数据中重复的元素
     * @param args
     */
    public static void main4(String[] args) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10_0000; i++) {
            list.add(random.nextInt(6000));
        }
        HashSet<Integer> set = new HashSet<>();
        for (Integer val : list) {
            set.add(val);
        }
        System.out.println(set);
    }

    /**
     * 找出10W个数据中，第一个重复的元素
     * @param args
     */
    public static void main3(String[] args) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10_0000; i++) {
            list.add(random.nextInt(6000));
        }

        /*for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(6));
        }
        System.out.println(list);*/

        HashSet<Integer> set = new HashSet<>();
        for (Integer val : list) {
            if (set.contains(val)) {
                System.out.println("找到了第一个重复的元素" + val);
                return;
            }else {
                set.add(val);
            }
        }
    }

    public static void main2(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(10);
        set.add(20);
        set.add(5);
        System.out.println(set);

        Iterator<Integer> it = set.iterator();//迭代器
        while (it.hasNext()) {
            System.out.println(it.next());
            //打印it的下一个 并且向后走一步
        }
    }

    public static void main1(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("ab","cd");
        map.put("ef","gh");
        map.put("ij","kl");

        for (Map.Entry<String,String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
