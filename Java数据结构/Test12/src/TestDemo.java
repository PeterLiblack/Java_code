/**
 * @Author Li_ZW
 * @Date: 2020/05/31
 * @Time: 20:26
 * @Description
 */

class Student {
    //私有属性
    private String name = "张三";
    //公有属性
    public int age = 18;
    //不带参数的构造方法
    public Student() {
        System.out.println("Student()");
    }

    private Student(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Student(String, name)");
    }

    private void eat() {
        System.out.println("eat");
    }

    public void sleep() {
        System.out.println("sleep");
    }

    private void function(String str) {
        System.out.println(str);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class TestDemo {
    public static void main(String[] args) {
        Class c1 = null;
        try {
            c1 = Class.forName("Student");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Class c2 = Student.class;
        Student s1 = new Student();
        Class c3 = s1.getClass();

        System.out.println(c1 == c2);
        System.out.println(c1 == c3);
        System.out.println(c2 == c3);
    }
}
