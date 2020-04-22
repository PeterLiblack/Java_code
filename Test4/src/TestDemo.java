/**
 * @Author Li_ZW
 * @Date: 2020/04/20
 * @Time: 17:10
 * @Description
 * 类和对象
 * 掌握类的定义方式以及对象的实例化
 * 掌握类中的成员变量和成员方法的使用
 * 掌握对象的整个初始化过程
 */
public class TestDemo {
    //匿名对象
    public static void main(String[] args) {
        new Person7("caocao",19).show();//通过匿名对象调用方法
        //没有引用的对象称为匿名对象.
        //匿名对象只能在创建对象时使用.
        //如果一个对象只是用一次, 后面不需要用了, 可以考虑使用匿名对象.
    }

    //代码块
    public static void main5(String[] args) {
        Person6 p1 = new Person6();
        Person6 p2 = new Person6();

    }

    //构造函数
    public static void main4(String[] args) {
        Person5 p1 = new Person5();//调用不带参数的构造函数 如果程序没有提供会调用不带参数的构造函数
        p1.show();
        Person5 p2 = new Person5("zhangfei",80,"男");//调用带有3个参数的构造函数
        p2.show();
    }

    //封装
    public static void main3(String[] args) {
        Person2 person2 = new Person2();
        System.out.println("我叫" + person2.name + ", 今年" + person2.age + "岁");
        Person3 person3 = new Person3();
        person3.show();

        Person4 person4 = new Person4();
        person4.setName("李四");
        person4.setAge(18);
        String name = person4.getName();
        System.out.println(name);
        person4.show();
    }

    // static 关键字
    public static void main2(String[] args) {
        Test t1 = new Test();
        t1.a++;
        Test.count++;
        System.out.println(t1.a);
        System.out.println(Test.count);
        System.out.println("============");
        //count被static所修饰，所有类共享。
        Test t2 = new Test();
        t2.a++;
        Test.count++;
        System.out.println(t2.a);
        System.out.println(Test.count);

        Test.change(); //无需创建实例对象 就可以调用
        System.out.println(Test.count);
    }

    public static void main1(String[] args) {
        Person person = new Person();//通过new实例化对象
        person.eat();//成员方法调用需要通过对象的引用调用
        person.sleep();
        //产生对象     同一个类可以创建多个实例化对象
        Person person2 = new Person();
        Person person3 = new Person();
        //访问字段
        System.out.println(person.name);
        System.out.println(person.age);
        System.out.println(person.sex);
        // 获取字符串长度
        System.out.println(person.name.length());
        //方法 用于描述一个对象的行为
        person.show();
        //show 方法是和 person 实例相关联的.
        //如果创建了其他实例, 那么 show 的行为就会发生变化
        person2.name = "李四";
        person2.age = 20;
        person2.show();
    }
}

// 创建类
class Person {
    //成员属性 实例变量
    public int age = 18; //字段
    public String name = "张三";
    public String sex = "男";

    public void eat() {//成员方法
        System.out.println("吃饭!");
    }
    public void sleep() {
        System.out.println("睡觉!");
    }
    public void show() {
        System.out.println("我叫" + name + ", " + sex + ", 今年" + age + "岁");
    }
}

//static关键字
class Test{
    public int a;
    //修饰属性
    public static int count;
    //修饰方法
    public static void change() {
        count = 100;
        //a = 10; error 不可以访问非静态数据成员
    }
}

//直接使用 public封装
class Person2 {
    public String name = "张三";
    public int age = 20;
}

//使用 private 封装属性, 并提供 public 方法供类的调用者使用.
class Person3 {
    private String name = "张三";
    private int age = 20;

    public void show() {
        System.out.println("我叫" + name + ", 今年" + age + "岁");
    }
}

//getter和setter方法
class Person4 {
    private String name;//实例成员变量
    private int age;

    public void setName(String name){
        //name = name;//不能这样写
        this.name = name;//this引用，表示调用该方法的对象
    }
    public String getName(){
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void show(){
        System.out.println("name: "+name+" age: "+age);
    }
}

//构造函数
class Person5 {

    private String name;//实例成员变量
    private int age;
    private String sex;
    //默认构造函数 构造对象
    public Person5() {
        this.name = "caocao";
        this.age = 10;
        this.sex = "男";
    }
    //带有3个参数的构造函数
    public Person5(String name,int age,String sex) {
        //this关键字
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public void show(){
        System.out.println("name: "+name+" age: "+age+" sex: "+sex);
    }

}

//代码块
class Person6{
    private String name;//实例成员变量
    private int age;
    private String sex;
    private static int count = 0;//静态成员变量 由类共享数据 方法区

    public Person6(){
        System.out.println("I am Person init()!");
    }

        //实例代码块
        {
         this.name = "zhangsan";
         this.age = 18;
         this.sex = "man";
         System.out.println("I am instance init()!");
         }

        //静态代码块
        static {
        count = 10;//只能访问静态数据成员
        System.out.println("I am static init()!");
        }

    public void show(){
        System.out.println("name: "+name+" age: "+age+" sex: "+sex);
    }
}
//匿名对象
class Person7 {
    private String name;
    private int age;
    public Person7(String name,int age) {
        this.age = age;
        this.name = name;
    }
    public void show() {
        System.out.println("name:"+name+" " + "age:"+age);
    }
}