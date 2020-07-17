//一个数组有 N 个元素，求连续子数组的最大和。 例如：[-1,2,1]，和最大的连续子数组为[2,1]，其和为 3

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = 0;
        while(sc.hasNext()){
            n = sc.nextInt();
            int[] num = new int[n];
            for(int i=0;i<n;i++){
                num[i] = sc.nextInt();
            }
            int max = num[0];
            int sum = num[0];
            for(int i=1;i<n;i++){
                if(sum>=0){
                    sum += num[i];
                }else{
                    sum=num[i];
                }
                if(sum>max)max=sum;
            }
            System.out.println(max);
        }
    }
}


//开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。
//从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
//输入：
//合法坐标为A(或者D或者W或者S) + 数字（两位以内）坐标之间以;分隔。
//非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。

import java.util.*;

public class Main{
     
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String str=sc.nextLine();
            String[] A=str.split(";");
            int x=0,y=0;
            for(String string:A){
                if(string.charAt(0)=='D' && string.substring(1).matches("[0-9]+"))
                    x+=Integer.parseInt(string.substring(1));
                 
                if(string.charAt(0)=='W' && string.substring(1).matches("[0-9]+"))
                    y+=Integer.parseInt(string.substring(1));
                 
                if(string.charAt(0)=='S' && string.substring(1).matches("[0-9]+"))
                    y-=Integer.parseInt(string.substring(1));
                 
                if(string.charAt(0)=='A' && string.substring(1).matches("[0-9]+"))
                    x-=Integer.parseInt(string.substring(1));
               
            }
            System.out.println(x+","+y);
        }
         
        sc.close();
    }
     
   
}



//根据输入的日期，计算是这一年的第几天。
//详细描述：
//输入某年某月某日，判断这一天是这一年的第几天？。

import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        while(sc.hasNext()){
            int year = sc.nextInt() ;
            int month = sc.nextInt() ;
            int day = sc.nextInt() ;
            int Day = outDay(year, month, day) ;
            System.out.println(Day);
        }
        sc.close();
 
    }
 
    private static int outDay(int year, int month, int day) {
        int [] Day = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31} ;
        if(year <= 0 ||month <= 0 || month > 12 || day<= 0 || day > Day[month - 1])
            return -1;
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
            Day[1] = 29 ;
        }
         
        int sum = 0 ;
        for(int i = 0 ; i < month - 1 ; i ++){
            sum += Day[i] ;
        }
        return sum + day;
    }
 
}





//1、对输入的字符串进行加解密，并输出。

//2加密方法为：

//当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；

//当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；

//其他字符不做变化。

//3、解密方法为加密的逆过程。

import java.util.*;
 
public class Main {
     
    public static char encryption(char c){
        if(c >= 'a' && c < 'z')
            return (char)(c + 1 - 32);
        else if(c == 'z')
            return 'A';
        else if(c >= 'A' && c < 'Z')
            return (char)(c + 1 + 32);
        else if(c == 'Z')
            return 'a';
        else if(c >= '0' && c < '9')
            return (char)(c + 1);
        else if(c == '9')
            return '0';
        else
            return c;
    }
     
    public static char decryption(char c){
        if(c > 'a' && c <= 'z')
            return (char)(c - 1 - 32);
        else if(c == 'a')
            return 'Z';
        else if(c > 'A' && c <= 'Z')
            return (char)(c - 1 + 32);
        else if(c == 'A')
            return 'z';
        else if(c > '0' && c <= '9')
            return (char)(c - 1);
        else if(c == '0')
            return '9';
        else
            return c;
    }
     
    public static String enCryption(String s){
        char[] cs = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < cs.length; i++){
            sb.append(encryption(cs[i]));
        }
        return sb.toString();
    }
     
    public static String deCryption(String s){
        char[] cs = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < cs.length; i++){
            sb.append(decryption(cs[i]));
        }
        return sb.toString();
    }
     
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            System.out.println(enCryption(s1));
            System.out.println(deCryption(s2));
        }
        sc.close();
    }
}