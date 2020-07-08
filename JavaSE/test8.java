//输入第1行给出正整数N（<=105），即双方交锋的次数。随后N行，每行给出一次交锋的信息，
//即甲、乙双方同时给出的的手势。C代表“锤子”、J代表“剪刀”、B代表“布”，
//第1个字母代表甲方，第2个代表乙方，中间有1个空格。

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
 
/**
 * 锤子剪刀布
 * 题目描述
 * 大家应该都会玩“锤子剪刀布”的游戏：
 * 现给出两人的交锋记录，请统计双方的胜、平、负次数，并且给出双方分别出什么手势的胜算最大。
 * 输入描述:
 * 输入第1行给出正整数N（<=105），即双方交锋的次数。随后N行，每行给出一次交锋的信息，
 * 即甲、乙双方同时给出的的手势。C代表“锤子”、J代表“剪刀”、B代表“布”，第1个字母代表甲方，
 * 第2个代表乙方，中间有1个空格。
 * 输出描述:
 * 输出第1、2行分别给出甲、乙的胜、平、负次数，数字间以1个空格分隔。第3行给出两个字母，
 * 分别代表甲、乙获胜次数最多的手势，中间有1个空格。如果解不唯一，则输出按字母序最小的解。
 * 输入例子:
 * 10
 * C J
 * J B
 * C B
 * B B
 * B C
 * C C
 * C B
 * J B
 * B C
 * J J
 * 输出例子:
 * 5 3 2
 * 2 3 5
 * B B
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
 
        Model mA = new Model();
        Model mB = new Model();
 
        for (int i = 0; i < N; i++) {
            String a = sc.next();
            String b = sc.next();
            judge(a, b, mA, mB);
        }
 
        System.out.println(mA.win + " " + mA.tie + " " + mA.lose);
        System.out.println(mB.win + " " + mB.tie + " " + mB.lose);
        System.out.println(getMostGen(mA.map) + " " + getMostGen(mB.map));
    }
 
    public static void judge(String a, String b, Model mA,
                             Model mB) {
        if (a.equals("C")) {
            if (b.equals("C")) {
                mA.tie++;
                mB.tie++;
            } else if (b.equals("J")) {
                mA.win++;
                mB.lose++;
                mA.map.put("C", mA.map.get("C") + 1);
            } else {
                mA.lose++;
                mB.win++;
                mB.map.put("B", mA.map.get("B") + 1);
            }
        } else if (a.equals("J")) {
            if (b.equals("C")) {
                mA.lose++;
                mB.win++;
                mB.map.put("C", mA.map.get("C") + 1);
            } else if (b.equals("J")) {
                mA.tie++;
                mB.tie++;
            } else {
                mA.win++;
                mB.lose++;
                mA.map.put("J", mA.map.get("J") + 1);
            }
        } else {
            if (b.equals("C")) {
                mA.win++;
                mB.lose++;
                mA.map.put("B", mA.map.get("B") + 1);
            } else if (b.equals("J")) {
                mA.lose++;
                mB.win++;
                mB.map.put("J", mA.map.get("J") + 1);
            } else {
                mA.tie++;
                mB.tie++;
            }
        }
    }
 
    public static String getMostGen(Map<String, Integer> map) {
        if (map.get("C") >= map.get("J")) {
            if (map.get("C") > map.get("B")) {
                return "C";
            } else {
                return "B";
            }
        } else {
            if (map.get("J") > map.get("B")) {
                return "J";
            } else {
                return "B";
            }
        }
    }
 
    static class Model {
        int win;
        int tie;
        int lose;
        Map<String, Integer> map;
 
        Model() {
            map = new HashMap<>();
            map.put("B", 0);
            map.put("C", 0);
            map.put("J", 0);
        }
    }
}



//有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶、3阶。
//请实现一个方法，计算小孩有多少种上楼的方式。为了防止溢出，请将结果Mod 1000000007
//给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000

import java.util.*;
 
public class GoUpstairs {
     
    public int countWays(int n) {
        // write code here
        long[] pre = {1, 2, 4};
        if(n<=0) return 0;
        else if(n<=3) return (int)pre[n-1];
        else{
            for(int i=4; i<=n; i++){
                long tmp = ((pre[0] + pre[1])%1000000007 +pre[2])%1000000007;
                pre[0] = pre[1];
                pre[1] = pre[2];
                pre[2] = tmp;
            }
        }
        return (int)pre[2];
    }
}


//Broken Keyboard

import java.util.*;
  
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String first=sc.next();
        String second=sc.next();
        first=first.toUpperCase();
        second=second.toUpperCase();
        for(int i=0;i<second.length();i++){
            first=first.replace(second.charAt(i)+"","");
        }
        String coutStr="";
        for(int i=0;i<first.length();i++){
            if(coutStr.contains(first.charAt(i)+"")){
                continue;
            }else{
                System.out.print(first.charAt(i));
                coutStr+=first.charAt(i);
            }
        }
        System.out.println();
    }
}



//输入球的中心点和球上某一点的坐标，计算球的半径和体积

import java.lang.Math;
import java.util.Scanner;
 
public class Main{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            double x0=in.nextFloat();
            double y0=in.nextFloat();
            double z0=in.nextFloat();
            double x1=in.nextFloat();
            double y1=in.nextFloat();
            double z1=in.nextFloat();
            //注意要在循环输入语句中输出结果
            //注意输入格式哟
            System.out.printf("%.3f",getRadius(x0,y0,z0,x1,y1,z1));
            System.out.print(" ");
            System.out.printf("%.3f",getVolume(x0,y0,z0,x1,y1,z1));
            System.out.println();
        }
        in.close();
    }
    //计算半径的方法，写的详细了点，快的话，可以直接return表达式
    public static double getRadius(double x0,double y0,double z0,double x1,double y1,double z1){
        double radius=0;
        double radiusSquare=0;
        radiusSquare=(x1-x0)*(x1-x0)+(y1-y0)*(y1-y0)+(z1-z0)*(z1-z0);
        radius=Math.sqrt(radiusSquare);//开根号方法
        return radius;
    }
    //计算体积的方法
    public static double getVolume(double x0,double y0,double z0,double x1,double y1,double z1){
        double volume=0;
        //调用math中的方法，也可以用r*r*r
        volume=4*Math.acos(-1)*Math.pow(getRadius(x0,y0,z0,x1,y1,z1), 3)/3;
        return volume;
    }
}