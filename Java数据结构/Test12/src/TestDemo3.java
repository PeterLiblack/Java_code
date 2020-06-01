import java.util.ArrayList;
import java.util.HashMap;
import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;


/**
 * @Author Li_ZW
 * @Date: 2020/05/31
 * @Time: 20:51
 * @Description
 */

public class TestDemo3 {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "hello");
        map.put(2, "bit");
        map.put(3, "hello");
        map.put(4, "lambda");
        /*map.forEach(new BiConsumer<Integer, String>(){
            @Override
            public void accept(Integer k, String v){
                System.out.println(k + "=" + v);
            }
        });*/
        map.forEach((k,v)->System.out.println(k + "=" + v));
    }


    public static void main1(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("bit");
        list.add("hello");
        list.add("lambda");
        /*list.sort(new Comparator<String>() {
            @Override
            public int compare(String str1, String str2){
                //注意这里比较长度
                return str1.length()-str2.length();
            }
        });*/
        list.sort((str1,str2)->str1.length()-str2.length());

        list.forEach(s->System.out.print(s+" "));



       /* list.forEach(new Consumer<String>(){
            @Override
            public void accept(String str){
                //简单遍历集合中的元素。
                System.out.print(str+" ");
            }
        });*/
        //list.forEach(s->System.out.print(s+" "));
    }
}

