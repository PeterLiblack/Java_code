import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author Li_ZW
 * @Date: 2020/05/26
 * @Time: 15:21
 * @Description
 * 比较器
 */

class Person {
    public int age;
    public int score;
    public String name;

    public Person(int age, int score, String name) {
        this.age = age;
        this.score = score;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", score=" + score +
                ", name='" + name + '\'' +
                '}';
    }
}

public class TestDemo3 {
    public static void main(String[] args) {
        AgeComparator ageComparator = new AgeComparator();
        PriorityQueue<Person> priorityQueue = new PriorityQueue<>(ageComparator);
        priorityQueue.offer(new Person(16,89,"张三"));
        priorityQueue.offer(new Person(26,69,"李四"));
        System.out.println(priorityQueue);
    }

    public static void main2(String[] args) {
        Person person1 = new Person(16,89,"张三");
        Person person2 = new Person(26,66,"李四");
        Person person3 = new Person(6,96,"王五");
        Person[] people = new Person[3];
        people[0] = person1;
        people[1] = person2;
        people[2] = person3;

        AgeComparator ageComparator = new AgeComparator();
        ScoreComparator scoreComparator = new ScoreComparator();
        Arrays.sort(people,scoreComparator);
        System.out.println(Arrays.toString(people));
    }

    public static void main1(String[] args) {
        Person person1 = new Person(16,89,"张三");
        Person person2 = new Person(26,66,"李四");

        AgeComparator ageComparator = new AgeComparator();
        System.out.println(ageComparator.compare(person1, person2));

        ScoreComparator scoreComparator = new ScoreComparator();
        System.out.println(scoreComparator.compare(person1, person2));
    }
}
