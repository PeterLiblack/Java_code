//守形数是这样一种整数，它的平方的低位部分等于它本身。 
//比如25的平方是625，低位部分是25，因此25是一个守形数。 
//编一个程序，判断N是否为守形数。

import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n1=sc.nextInt();
            int n2=(int)Math.pow(n1,2);//1.求出n2
            // 2.先将n2转换成字符串，用字符串的截取功能将n3截取出来，再次转换为数字
            String s1=""+n2;
            String s2=s1.substring(1);
            //当n1=2或者n1=3的时候求出来的m无法进行截取，所以我们要进行排除这个
            if(s2.length()>0) {
                int n3 = Integer.parseInt(s2);
                if (n1 == n3) {//3.n3与n1进行对比即可
                    System.out.println("Yes!");
                } else {
                    System.out.println("No!");
                }
            }else {
                System.out.println("No!");
            }
        }
    }
}


//密码验证合格程序  密码要求:
//1.长度超过8位
//2.包括大小写字母.数字.其它符号,以上四种至少三种
//3.不能有相同长度大于等于2的子串重复

import java.util.*;

public class Main {
    // 1.长度超过8位
    public static boolean checkLength(String password){
        if (password==null || password.length()<=8)
            return false;
        return true;
    }
    // 2.包括大小写字母.数字.其它符号,以上四种至少三种
    public static boolean checkCharKinds(String password){
        int Digit=0 , lowercase=0,uppercase=0,others=0;
        char[] ch = password.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i]>='0'&&ch[i]<='9') {
                Digit=1;
                continue;
            }
            else if (ch[i]>='a'&&ch[i]<='z') {
                lowercase=1;
                continue;
            }
            else if (ch[i]>='A'&&ch[i]<='Z') {
                uppercase=1;
                continue;
            }else {
                others=1;
                continue;
            }
        }
        int total = Digit+lowercase+uppercase+others;
        return total>=3 ? true : false;
    }
    // 3.不能有相同长度超2的子串重复
    public static boolean checkCharRepeat(String password){
        for(int i=0 ;i<password.length()-2 ;i++){
            String substr1 =password.substring(i, i+3);
            if (password.substring(i+1).contains(substr1))
               return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextLine()) {
            String psw = cin.nextLine();
            if (checkLength(psw)&&checkCharKinds(psw)&&checkCharRepeat(psw))
                System.out.println("OK");
            else
                System.out.println("NG");
        }
    }
}



//今年公司年会的奖品特别给力，但获奖的规矩却很奇葩：
//1. 首先，所有人员都将一张写有自己名字的字条放入抽奖箱中；
//2. 待所有字条加入完毕，每人从箱中取一个字条；
//3. 如果抽到的字条上写的就是自己的名字，那么“恭喜你，中奖了！”
//现在告诉你参加晚会的人数，请你计算有多少概率会出现无人获奖？

import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
             int n=sc.nextInt();
             double sum1=factorial(n);
             double sum2=count(n);
             double result=(sum2/sum1)*100; //计算成%的形式
            System.out.println(String.format("%.2f",result)+"%");
        }
    }
    //计算所有人都抽不到奖的情况：错排算法
    private static double count(int n) {
      if(n==1){
          return 0;
      }else if(n==2){
          return 1;
      }else {
          return (n-1)*(count(n-1)+count(n-2));
      }
    }
 
    //计算阶乘：迭代写法
    private static double factorial(int n) {
        double sum=1;
        while(n>1){
           sum=sum*n;
           n--;
        }
        return sum;
    }
    //计算阶乘：递归写法
    private  static double factorical2(int n){
       if(n==0||n==1){
           return 1;
       }
       return n*factorical2(n-1);
    }
}


//给定一个有n个正整数的数组A和一个整数sum,求选择数组A中部分数字和为sum的方案数。
//当两种选取方案有一个数字的下标不一样,我们就认为是不同的组成方案。

import java.util.*;

public class Main{
    public static long bag(int []weight,int n,int sum){
        long dp[]=new long[sum+1];
        dp[0]=1;
        int i,j;
        for(i=0;i<n;i++){
            for(j=sum;j>=weight[i];j--){
               dp[j]=dp[j-weight[i]]+dp[j];
            }
        }
        return dp[sum];
    }
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int sum=s.nextInt();
        int i,j;
        int arr[]=new int[n];
        for(i=0;i<n;i++){
            arr[i]=s.nextInt();
        }
        System.out.println(bag(arr,n,sum));
    }
}