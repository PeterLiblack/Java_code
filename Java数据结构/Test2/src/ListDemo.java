import java.util.*;

/**
 * @Author Li_ZW
 * @Date: 2020/05/12
 * @Time: 14:28
 * @Description
 * List的使用
 */

class Student {
    public String name;
    public String classes;
    public double score;

    public Student(String name, String classes, double score) {
        this.name = name;
        this.classes = classes;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                ", score=" + score +
                '}';
    }
}

public class ListDemo {

    public static void main(String[] args) {
        List<String> courses = new ArrayList<>();
        courses.add("C 语言");
        courses.add("Java SE");
        courses.add("Java Web");
        courses.add("Java EE");

        // 和数组一样，允许添加重复元素
        courses.add("C 语言");

        // 按照添加顺序打印
        System.out.println(courses);

        // 类似数组下标的方式访问
        System.out.println(courses.get(0));

        System.out.println(courses);
        courses.set(0, "计算机基础");
        System.out.println(courses);

        // 截取部分 [1, 3)
        List<String> subCourses = courses.subList(1, 3);
        System.out.println(subCourses);

        // 重新构造
        List<String> courses2 = new ArrayList<>(courses);
        System.out.println(courses2);

        List<String> courses3 = new LinkedList<>(courses);
        System.out.println(courses3);

        // 引用的转换
        ArrayList<String> courses4 = (ArrayList<String>)courses2;
        System.out.println(courses4);

        LinkedList<String> courses5 = (LinkedList<String>)courses3;
        System.out.println(courses5);

    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        if (numRows == 0) {
            return ret;
        }

        List<Integer> oneRow = new ArrayList<>();
        ret.add(oneRow);
        ret.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            List<Integer> curRow = new ArrayList<>();
            curRow.add(1);

            List<Integer> prevRow = ret.get(i-1);
            for (int j = 1; j < i; j++) {
                int x = prevRow.get(j);
                int y = prevRow.get(j-1);
                curRow.add(x+y);
            }
            curRow.add(1);
            ret.add(curRow);
        }
        return ret;
    }


    public static void main4(String[] args) {
        String str1 = "Welcome to China";
        String str2 = "com";
        System.out.println(str1);
        List<Character> ret = func(str1,str2);
        for (char ch:ret) {
            System.out.print(ch);
        }
        System.out.println();
    }

    private static List<Character> func(String str1, String str2) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if (!str2.contains(ch+"")) {
                list.add(ch);
            }
        }
        return list;
    }

    public static void main3(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(5);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }

    public static void main2(String[] args) {
        Student student1 = new Student("张三","一班",53.5);
        Student student2 = new Student("李四","二班",68.5);

        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        System.out.println(list);
    }

    public static void main1(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add(1,"abc");
        System.out.println(list);

        List<String> list1 = new ArrayList<>();
        list.add("java");
        list.add("SE");
        list.addAll(list1);
        System.out.println(list);

        String ret = list.remove(0);
        System.out.println(ret);
        list.remove("SE");
        System.out.println(list);


        System.out.println("========get========");
        ret = list.get(0);
        System.out.println(ret);

        System.out.println("========set========");
        list.set(0,"EE");
        System.out.println(list);

        System.out.println(list.contains("EE"));
        System.out.println(list.indexOf("EE"));
        list.add("EE");
        System.out.println(list.lastIndexOf("EE"));

        System.out.println("======subList======");
        List<String> retList = list.subList(0,2);
        System.out.println(retList);
        retList.set(0,"C");
        System.out.println(retList);
        System.out.println(list);

        list.clear();
        System.out.println(list);
    }
}
