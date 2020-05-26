import java.util.Arrays;

/**
 * @Author Li_ZW
 * @Date: 2020/05/26
 * @Time: 14:23
 * @Description
 * Comparable:
 * 缺点 每次业务不同 需要修改类本身
 *
 * 自定义类型 实现比较
 */

class Student implements Comparable<Student> {
    public int age;
    public int score;
    public String name;

    public Student(int age, int score, String name) {
        this.age = age;
        this.score = score;
        this.name = name;
    }

    @Override
    public int compareTo(Student o) {
        //return this.age - o.age;
        return o.age - this.age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", score=" + score +
                ", name='" + name + '\'' +
                '}';
    }
}

public class TestDemo2 {
    public static void main(String[] args) {
        Student student1 = new Student(26,80,"张三");
        Student student2 = new Student(16,90,"李四");
        Student student3 = new Student(36,70,"王五");
        Student[] students = new Student[3];
        students[0] = student1;
        students[1] = student2;
        students[2] = student3;

        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }

    /*public static void main(String[] args) {
        Student student1 = new Student(26,80,"张三");
        Student student2 = new Student(16,90,"李四");
        if (student1.compareTo(student2) > 0) {
            System.out.println("student1 > student2");
        }
    }*/
}
