//给定一句英语，要求你编写程序，将句中所有单词的顺序颠倒输出。

import java.util.*;
 
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String line=sc.nextLine();
        String[] list=line.split(" ");
        for(int i=list.length-1;i>0;i--){
            System.out.print(list[i]+" ");
        }
        System.out.print(list[0]);
    }
}



//开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
//处理：1、 记录最多8条错误记录，循环记录（或者说最后只输出最后出现的八条错误记录），对相同的错误记录（净文件名（保留最后16位）称和行号完全匹配）只记录一条，错误计数增加；
//2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
//3、 输入的文件可能带路径，记录文件名称不能带路径。

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
 
public class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Map<String, Integer> map=new LinkedHashMap<String, Integer>();
        while(sc.hasNext()){
            String str=sc.next();
            int linenum=sc.nextInt();
            String[] arr=str.split("\\\\");  //根据\切割
            String s=arr[arr.length-1];
            if(s.length()>16)  //截取
                s=s.substring(s.length()-16);
            String key=s+" "+linenum;
            int value=1;
            if(map.containsKey(key))
                map.put(key, map.get(key)+1);
            else {
                map.put(key, value);
            }
        }
        int count=0;
        for(String string:map.keySet()){
            count++;
            if(count>(map.keySet().size()-8)) //输出最后八个记录
                System.out.println(string+" "+map.get(string));
        }
    }
}

import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //LinkedHashMap可以保证按照存入顺序
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        int count = 0;
        while (sc.hasNextLine()) {
            String str_1 = sc.nextLine();
            //读取一行  存入一行至map中
            mapDispose(map, str_1);
        }
        // 输出后8位
            for (String st : map.keySet()) {
                count++;
                if (count > (map.size() - 8)) {
                    System.out.println(st + " " + map.get(st));
                }
            }
    }
     
    public static void mapDispose(Map<String, Integer> map, String str) {
        // "\\s" 是按照单个空格 、多个空格、tab制表符分割
        String[] strArr = str.split("\\s+");
        // "\\\\"按照反斜杠分割
        String[] nameArr = strArr[0].split("\\\\");
        int num = Integer.parseInt(strArr[1]);
        String name = nameArr[nameArr.length - 1];
        // 取最后有效的16个字符为最终文件名
        if (name.length() > 16) {
            name = name.substring(name.length() - 16);
        }
        // 将文件名和行号组成字符串 作为map的key值存放
        String key = name + " " + num;
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
        } else {
            map.put(key, 1);
        }
    }
}


//如果你是哈利·波特迷，你会知道魔法世界有它自己的货币系统 —— 就如海格告诉哈利的：
//“十七个银西可(Sickle)兑一个加隆(Galleon)，二十九个纳特(Knut)兑一个西可，很容易。”
//现在，给定哈利应付的价钱P和他实付的钱A，你的任务是写一个程序来计算他应该被找的零钱。

import java.util.Scanner;

public class Main {
    private static final int[] W = {17*29,29,1};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] p = in.next().split("\\.");
        String[] a = in.next().split("\\.");
        int[] P = {Integer.parseInt(p[0]),Integer.parseInt(p[1]),Integer.parseInt(p[2])};
        int[] A = {Integer.parseInt(a[0]),Integer.parseInt(a[1]),Integer.parseInt(a[2])};
        int ta = A[0]*W[0]+A[1]*W[1]+A[2]*W[2];
        int tp = P[0]*W[0]+P[1]*W[1]+P[2]*W[2];
        int t = ta-tp;
        if(ta<tp){
            System.out.print("-");
            t = -t;
        }
        System.out.println(t/W[0]+"."+t%W[0]/W[1]+"."+t%W[0]%W[1]/W[2]);
    }
}


//请编写一个方法，输出0到n(包括n)中数字2出现了几次。
//给定一个正整数n，请返回0到n的数字中2出现了几次。

import java.util.*;
 
public class Count2 {
    public int countNumberOf2s(int n) {
        int count = 0;
    for (int i = 1; i <= n; i *= 10) {
        int a = n / i,b = n % i;
        //之所以补8，是因为当百位为0，则a/10==(a+8)/10，
        //当百位>=2，补8会产生进位位，效果等同于(a/10+1)
        count += (a + 7) / 10 * i + ((a % 10 == 2) ? b + 1 : 0);
    }
    return count;
    }
}