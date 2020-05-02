package com.demo7;

import java.util.Arrays;

/**
 * @Author Li_ZW
 * @Date: 2020/05/02
 * @Time: 14:38
 * @Description
 *
 * Cloneable
 */

class Money implements Cloneable {
    double money = 12.5;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Person implements Cloneable {
    public int age;
    Money money = new Money();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //return super.clone();

        //1，克隆person
        Person person = (Person)super.clone();

        //2，克隆当前的Money对象
        person.money = (Money)this.money.clone();

        return person;
    }
}

public class TestDemo2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person1 = new Person();
        Person person2 = (Person)person1.clone();

        System.out.println(person1.money.money);
        System.out.println(person2.money.money);

        System.out.println("========修改========");
        person2.money.money = 99.9;
        System.out.println(person1.money.money);
        System.out.println(person2.money.money);
    }

    public static void main2(String[] args) throws CloneNotSupportedException {
        Person person1 = new Person();
        Person person2 = (Person)person1.clone();

        System.out.println(person1.age);
        System.out.println(person2.age);

        System.out.println("========修改========");
        person2.age = 99;
        System.out.println(person1.age);
        System.out.println(person2.age);
    }

    public static void main1(String[] args) {
        int[] array = {1,2,3,4,5,6};
        int[] array2 = array.clone();
        array2[0] = 99;

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array2));
    }
}
