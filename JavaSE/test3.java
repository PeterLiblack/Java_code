//老师想知道从某某同学当中，分数最高的是多少，现在请你编程模拟老师的询问。
//当然，老师有时候需要更新某位同学的成绩.

//import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int M=0 ,N=0;
        int i;
        int A = 0,B = 0;
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
                N = in.nextInt();
                M = in.nextInt();  
     
    //          System.out.println (N + " " + M);
                 
            int[] score = new int[N];
            for(i=0; in.hasNext() && i<N; i++){
                score[i] = in.nextInt();
    //          System.out.println (score[i] + " ");
            }
             
            String c = null;
             
            for(i=0; in.hasNext() && i< M; i++){
                c  = in.next();
                A = in.nextInt();
                B = in.nextInt();  
                process(c,A,B,score);
            }
        }
             
    }
 
    private static void process(String c, int a, int b, int[] score) {
        int begin,end;     
         
        if(c.equals("Q")){
            end = Math.max(a, b);
            begin = Math.min(a, b)-1;
            int max = score[begin];
            for(int i=begin;i<end;i++){
                if(max<score[i]){
                    max = score[i];
                }
            }
            System.out.println(max);
        }else if(c.equals("U")){
            score[a-1] = b;
        }
    }
}


//对于每组数据,第一行是两个整数n(1≤n<100000)表示怪物的数量和a表示小易的初始能力值.
//第二行n个整数,b1,b2...bn(1≤bi≤n)表示每个怪物的防御力
import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        //先构造对应的输入输出格式
        Scanner scanner=new Scanner(System.in);
        //获取输入判断
        while(scanner.hasNext())
        {
            //初始化
            int n=scanner.nextInt();
            int init=scanner.nextInt();
            int[] monster=new int [n];
            for(int i=0;i<n;i++)
            {
                //获取对应的数值
                monster[i]=scanner.nextInt();
                if(init>monster[i])
                {
                    init+=monster[i];
                }
                else
                {
                    //这时候一定monster大
                    init+=GetGYS(init,monster[i]);
                }
            }
            System.out.println(""+init);
        }      
        //关闭scanner
        scanner.close();
    }
     
    //获取对应最大公约数
    public static int GetGYS(int n,int m)
    {
        if(m%n==0)
            return n;
        else
        {
            return GetGYS(m%n,n);
        }
         
    }
}
