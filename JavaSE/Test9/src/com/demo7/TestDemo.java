package com.demo7;

import java.util.Arrays;

/**
 * @Author Li_ZW
 * @Date: 2020/05/02
 * @Time: 14:23
 * @Description
 * 接口的使用实例：
 * 一般情况下，自定义类型进行比较需要是 可比较的
 * Comparable Comparator 有区别
 */

class Student implements  Comparable<Student> {
    public String name;
    public int age;
    public int score;

    public Student(String name,int age,int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        if (this.score > o.score) {
            return 1;
        }else if (this.score == o.score) {
            return 0;
        }else {
            return -1;
        }
    }
}

public class TestDemo {
    public static void main(String[] args) {
        Student student1 = new Student("li",18,79);
        Student student2 = new Student("wang",28,89);
        Student student3 = new Student("chen",38,99);

        if (student1.compareTo(student2) < 0) {
            System.out.println("student1的年龄 < student2");
        }

        Student[] students = new Student[3];
        students[0] = student1;
        students[1] = student2;
        students[2] = student3;
        Arrays.sort(students);

        System.out.println(Arrays.toString(students));

    }

    public static void main1(String[] args) {
        int[] array = {12,4,84,43,56};
        Arrays.sort(array);

        System.out.println(Arrays.toString(array));
    }
}
