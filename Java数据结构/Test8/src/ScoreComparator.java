import java.util.Comparator;

/**
 * @Author Li_ZW
 * @Date: 2020/05/26
 * @Time: 15:24
 * @Description
 * 分数比较
 */
public class ScoreComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.score - o2.score;
    }
}
