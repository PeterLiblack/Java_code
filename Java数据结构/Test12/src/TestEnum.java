import java.lang.reflect.Constructor;

/**
 * @Author Li_ZW
 * @Date: 2020/05/31
 * @Time: 20:46
 * @Description
 */

public enum  TestEnum {
    RED(1,"红色"),BLACK(2,"黑色"),GREEN(3,"绿色"),WHITE(4,"白色");

    public int ordinal;
    public String color;

    TestEnum(int ordinal,String color) {
        this.ordinal = ordinal;
        this.color = color;
    }

    public static TestEnum getEnumKey (int ordinal) {
        for (TestEnum t: TestEnum.values()) {
            if(t.ordinal == ordinal) {
                return t;
            }
        }
        return null;
    }

    public static void reflectPrivateConstructors() {
        try {
            Class<?> classStudent = Class.forName("TestEnum");
            Constructor<?>[]  declaredConstructorStudents = classStudent.getDeclaredConstructors();

            for (Constructor constructor : declaredConstructorStudents) {
                System.out.println(constructor);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void reflectPrivateConstructor() {
        try {
            Class<?> classStudent = Class.forName("TestEnum");
            //注意传入对应的参数,获得对应的构造方法来构造对象,当前枚举类是提供了两个参数分别是String和int。
            Constructor<?> declaredConstructorStudent = classStudent.getDeclaredConstructor(String.class,int.class,int.class,String.class);
            //设置为true后可修改访问权限
            declaredConstructorStudent.setAccessible(true);
            Object objectStudent = declaredConstructorStudent.newInstance("父类参数",18,666,"绿色");
            TestEnum testEnum = (TestEnum) objectStudent;
            System.out.println("获得枚举的私有构造函数："+testEnum);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        reflectPrivateConstructor();
    }


    public static void main3(String[] args) {
        //拿到枚举实例BLACK
        TestEnum testEnum = TestEnum.BLACK;
        //拿到枚举实例RED
        TestEnum testEnum21 = TestEnum.RED;
        System.out.println(testEnum.compareTo(testEnum21));
        System.out.println(BLACK.compareTo(RED));
        System.out.println(RED.compareTo(BLACK));
    }

    public static void main2(String[] args) {
        TestEnum[] testEnums = TestEnum.values();

        for (int i = 0; i < testEnums.length; i++) {
            System.out.println(testEnums[i]+" " +testEnums[i].ordinal());
        }

        System.out.println("======");
        System.out.println(TestEnum.valueOf("BLACK"));

    }

    public static void main1(String[] args) {
        TestEnum testEnum2 = TestEnum.BLACK;
        switch (testEnum2) {
            case RED:
                System.out.println("red");
                break;
            case BLACK:
                System.out.println("black");
                break;
            case WHITE:
                System.out.println("WHITE");
                break;
            case GREEN:
                System.out.println("black");
                break;
            default:
                break;
        }
    }
}
