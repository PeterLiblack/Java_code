import java.util.Comparator;

/**
 * @Author Li_ZW
 * @Date: 2020/05/26
 * @Time: 15:23
 * @Description
 * 年龄比较
 */
public class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o2.age - o1.age;
    }
}
