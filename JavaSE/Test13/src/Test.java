import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @Author Li_ZW
 * @Date: 2020/05/10
 * @Time: 20:31
 * @Description
 * 认识异常
 */

class UserError extends Exception {
    public UserError(String message) {
        super(message);
    }
}
class PasswordError extends Exception {
    public PasswordError(String message) {
        super(message);
    }
}

public class Test {



    private static String userName = "admin";
    private static String password = "123456";
    //自定义异常
    public static void main14(String[] args) {
        try {
            login("admin", "123456");
        } catch (UserError userError) {
            userError.printStackTrace();
        } catch (PasswordError passwordError) {
            passwordError.printStackTrace();
        }
    }
    public static void login(String userName, String password) throws UserError,
            PasswordError {
        if (!Test.userName.equals(userName)) {
            throw new UserError("用户名错误");
        }
        if (!Test.password.equals(password)) {
            throw new PasswordError("密码错误");
        }
        System.out.println("登陆成功");
    }

    //登录操作
    /*private static String userName = "admin";
    private static String password = "123456";
    public static void main14(String[] args) {
        login("admin", "123456");
    }
    public static void login(String userName, String password) {
        if (!Test.userName.equals(userName)) {
            // TODO 处理用户名错误
        }
        if (!Test.password.equals(password)) {
            // TODO 处理密码错误
        }
        System.out.println("登陆成功");
    }*/

    public static void main13(String[] args) {
        System.out.println(readFile2());
    }
    public static String readFile2() {
        File file = new File("d:/test.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return sc.nextLine();
    }

    //受查异常
    public static void main12(String[] args) throws FileNotFoundException {
        System.out.println(readFile());

        //Error:(16, 36) java: 未报告的异常错误java.io.FileNotFoundException; 必须对其进行捕获或声明以便抛出
    }
    public static String readFile() throws FileNotFoundException {
        // 尝试打开文件, 并读其中的一行.
        File file = new File("d:/test.txt");
        // 使用文件对象构造 Scanner 对象.
        Scanner sc = new Scanner(file);
        return sc.nextLine();
    }

    //抛出异常
    public static void main11(String[] args) {
        System.out.println(divide(10, 0));

        //Exception in thread "main" java.lang.ArithmeticException: 抛出除 0 异常
    }
    public static int divide(int x, int y) {
        if (y == 0) {
            throw new ArithmeticException("抛出除 0 异常");
        }
        return x / y;
    }

    //如果向上一直传递都没有合适的方法处理异常, 最终就会交给 JVM 处理,
    //程序就会异常终止(和我们最开始未使用 try catch 时是一样的).
    public static void main10(String[] args) {
        func2();
        System.out.println("after try catch");

        //Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 100
    }
    public static void func2() {
        int[] arr = {1, 2, 3};
        System.out.println(arr[100]);
    }

    //如果本方法中没有合适的处理异常的方式, 就会沿着调用栈向上传递
    public static void main9(String[] args) {
        try {
            func();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        System.out.println("after try catch");

        //java.lang.ArrayIndexOutOfBoundsException: 100
        //after try catch
    }
    public static void func() {
        int[] arr = {1, 2, 3};
        System.out.println(arr[100]);
    }

    //使用 try 负责回收资源
    public static void main8(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int num = sc.nextInt();
            System.out.println("num = " + num);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // finally 表示最后的善后工作, 例如释放资源
    public static void main7(String[] args) {
        int[] arr = {1, 2, 3};
        try {
            System.out.println("before");
            arr = null;
            System.out.println(arr[100]);
            System.out.println("after");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally code");
        }

        //before
        //finally code
        //java.lang.NullPointerException
    }

    //也可以用一个 catch 捕获所有异常(不推荐)
    public static void main6(String[] args) {
        int[] arr = {1, 2, 3};
        try {
            System.out.println("before");
            arr = null;
            System.out.println(arr[100]);
            System.out.println("after");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("after try catch");

        //before
        //after try catch
        //java.lang.NullPointerException
    }

    // catch 可以有多个
    public static void main5(String[] args) {
        int[] arr = {1, 2, 3};
        try {
            System.out.println("before");
            arr = null;
            System.out.println(arr[100]);
            System.out.println("after");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("这是个数组下标越界异常");
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("这是个空指针异常");
            e.printStackTrace();
        }
        System.out.println("after try catch");

        //before
        //这是个空指针异常
        //after try catch
        //java.lang.NullPointerException
    }

    // catch 只能处理对应种类的异常
    public static void main4(String[] args) {
        int[] arr = {1, 2, 3};
        try {
            System.out.println("before");
            arr = null;
            System.out.println(arr[100]);
            System.out.println("after");
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        System.out.println("after try catch");

        //before
        //Exception in thread "main" java.lang.NullPointerException
    }

    //使用 try catch 后的程序执行过程
    public static void main3(String[] args) {
        int[] arr = {1, 2, 3};
        try {
            System.out.println("before");
            System.out.println(arr[100]);
            System.out.println("after");
        } catch (ArrayIndexOutOfBoundsException e) {
       // 打印出现异常的调用栈
            e.printStackTrace();
        }
        System.out.println("after try catch");

        //before
        //after try catch
        //java.lang.ArrayIndexOutOfBoundsException: 100
    }

    //不处理异常
    public static void main2(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println("before");
        System.out.println(arr[100]);
        System.out.println("after");

        //before
        //Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 100
    }

    public int num = 10;
    public static void main1(String[] args) {
        /*//0异常
        System.out.println(10 / 0);
        //Exception in thread "main" java.lang.ArithmeticException: / by zero*/

        /*//数组越界访问异常
        int[] arr = {1, 2, 3};
        System.out.println(arr[100]);
        //Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 100*/

        //访问null对象异常
        Test t = null;
        System.out.println(t.num);
        //Exception in thread "main" java.lang.NullPointerException
    }
}
