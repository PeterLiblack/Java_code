import java.lang.reflect.Field;

/**
 * @Author Li_ZW
 * @Date: 2020/05/08
 * @Time: 19:53
 * @Description
 * String
 */

public class TestDemo {
    //StringBuffer使用
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("Hello").append("World");
        fun(sb);
        System.out.println(sb);

        //字符串反转
        StringBuffer sb2 = new StringBuffer("hello world");
        System.out.println(sb2.reverse());

        //删除
        StringBuffer sb3 = new StringBuffer("hello world");
        System.out.println(sb3.delete(5, 10));

        //插入
        StringBuffer sb4 = new StringBuffer("hello world");
        System.out.println(sb4.delete(5, 10).insert(0, "你好"));
    }
    public static void fun(StringBuffer temp) {
        temp.append("\n").append("www.word.com.cn");
    }

    //其他常用方法
    public static void main12(String[] args) {
        //trim()方法的使用
        String str = " hello world " ;
        System.out.println("["+str+"]");
        System.out.println("["+str.trim()+"]");

        //大小写转换
        String str2 = " hello%$$%@#$%world 哈哈哈 " ;
        System.out.println(str2.toUpperCase());
        System.out.println(str2.toLowerCase());

        //字符串length()
        String str3 = " hello%$$%@#$%world 哈哈哈 " ;
        System.out.println(str3.length());

        //isEmpty()方法
        System.out.println("hello".isEmpty());
        System.out.println("".isEmpty());
        System.out.println(new String().isEmpty());

        //首字母大写
        System.out.println(fistUpper("yuisama"));
        System.out.println(fistUpper(""));
        System.out.println(fistUpper("a"));
    }
    public static String fistUpper(String str) {
        if ("".equals(str)||str==null) {
            return str ;
        }
        if (str.length()>1) {
            return str.substring(0, 1).toUpperCase()+str.substring(1) ;
        }
        return str.toUpperCase() ;
    }

    //字符串截取
    public static void main11(String[] args) {
        String str = "hello world" ;
        System.out.println(str.substring(5));
        System.out.println(str.substring(0, 5));
    }

    //字符串拆分
    public static void main10(String[] args) {
        //按照空格拆分
        String str = "hello world hello boy" ;
        String[] result = str.split(" ") ;
        for(String s: result) {
            System.out.println(s);
        }

        //字符串的部分拆分
        String str2 = "hello world hello bit" ;
        String[] result2 = str.split(" ",2) ;
        for(String s: result2) {
            System.out.println(s);
        }

        //拆分IP地址
        String str3 = "192.168.1.1" ;
        String[] result3 = str.split("\\.") ;
        for(String s: result3) {
            System.out.println(s);
        }

        //多次拆分
        String str4 = "name=zhangsan&age=18" ;
        String[] result4 = str.split("&") ;
        for (int i = 0; i < result4.length; i++) {
            String[] temp = result4[i].split("=") ;
            System.out.println(temp[0]+" = "+temp[1]);
        }
    }

    //字符串替换
    public static void main9(String[] args) {
        String str = "hello world" ;
        System.out.println(str.replaceAll("l", "_"));
        System.out.println(str.replaceFirst("l", "_"));
    }

    //字符串查找
    public static void main8(String[] args) {
        //使用contains()进行位置查找 最简单
        String str = "hello world" ;
        System.out.println(str.contains("world"));

        //使用indexOf()方法进行位置查找
        String str2 = "hello world" ;
        System.out.println(str2.indexOf("world")); //
        System.out.println(str2.indexOf("book")); //
        if (str.indexOf("hello") != -1) {
            System.out.println("可以查到指定字符串！");
        }
    }

    //字符串比较
    public static void main7(String[] args) {
        String str1 = "hello" ;
        String str2 = "Hello" ;
        System.out.println(str1.equals(str2));
        System.out.println(str1.equalsIgnoreCase(str2));

        //compareTo()是一个可以区分大小关系的方法，是String方法里是一个非常重要的方法。
        System.out.println("A".compareTo("a"));
        System.out.println("a".compareTo("A"));
        System.out.println("A".compareTo("A"));
        System.out.println("AB".compareTo("AC"));
        System.out.println("刘".compareTo("杨"));
    }

    //给定字符串一个字符串, 判断其是否全部由数字所组成.
    public static void main6(String[] args) {
        String str = "1a23456" ;
        System.out.println(isNumber(str)? "字符串由数字所组成！" : "字符串中有非数字成员！");
    }
    public static boolean isNumber(String str) {
        char[] data = str.toCharArray() ;
        for (int i = 0; i < data.length; i++) {
            if (data[i]<'0' || data[i]>'9') {
                return false ;
            }
        }
        return true ;
    }

    //获取指定位置字符
    public static void main5(String[] args) {
        String str = "hello" ;
        System.out.println(str.charAt(0));

        String str1 = "hello world" ;
        // 将字符串变为字符数组
        char[] data = str1.toCharArray() ;
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]+" ");
        }

        // 字符数组转为字符串
        System.out.println(new String(data)); // 全部转换
        System.out.println(new String(data,5,5)); // 部分转换

    }

    //修改字符串
    public static void main4(String[] args) {
        String str = "Hello";
        str = "h" + str.substring(1);
        System.out.println(str);
    }
/*    public static void main4(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String str = "Hello";
        // 获取 String 类中的 value 字段. 这个 value 和 String 源码中的 value 是匹配的.
        Field valueField = String.class.getDeclaredField("value");
        // 将这个字段的访问属性设为 true
        valueField.setAccessible(true);
        // 把 str 中的 value 属性获取到.
        char[] value = (char[]) valueField.get(str);
        // 修改 value 的值
        value[0] = 'h';
        System.out.println(str);
    }*/

    //字符串常量池
    public static void main3(String[] args) {
        /*String str1 = "hello" ;
        String str2 = "hello" ;
        String str3 = "hello" ;
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str2 == str3);*/

        // 该字符串常量并没有保存在对象池之中
        String str1 = new String("hello") ;
        String str2 = "hello" ;
        System.out.println(str1 == str2);

        String str3 = new String("hello").intern() ;
        String str4 = "hello" ;
        System.out.println(str3 == str4);
    }

    //字符串比较相等
    public static void main2(String[] args) {
        String str1 = "Hello";
        String str2 = "Hello";
        System.out.println(str1 == str2);

        String str3 = new String("Hello");
        String str4 = new String("Hello");
        System.out.println(str3 == str4);
    }

    //创建字符串
    public static void main1(String[] args) {
        // 方式一
        String str = "Hello world";
        System.out.println(str);
        // 方式二
        String str2 = new String("Hello world");
        System.out.println(str2);
        // 方式三
        char[] array = {'a', 'b', 'c'};
        String str3 = new String(array);
        System.out.println(str3);
    }
}
