//输入一个字符串，然后对每个字符进行奇校验，最后输出校验后的二进制数
//(如'3’，输出：10110011)

import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.next();
            char[] array = s.toCharArray();
            for (char c : array) {
                String s1 = Integer.toBinaryString(c);
                String s2 = String.format("%07d", Integer.parseInt(s1));
                int count = 0;
                for (int j = 0; j < 7; j++) {
                    if (s2.charAt(j) == '1') count++;
                }
                System.out.println(count % 2 == 0 ? "1" + s2 : "0" + s2);
            }
        }
    }
}


//对N个长度最长可达到1000的数进行排序

import java.util.*;
import java.math.*;

public class Main{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            int n = s.nextInt();
            BigInteger[] bg = new BigInteger[n];
            for(int i=0; i<n; i++)
                bg[i] = s.nextBigInteger();
            Arrays.sort(bg);
            for(int i=0; i<n; i++)
                System.out.println(bg[i]);
        }
    }
}


//给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），
//每段绳子的长度记为k[1],...,k[m]。请问k[1]x...xk[m]可能的最大乘积是多少？
//例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
public class Solution {
    public int cutRope(int target) {
        if(target<2) {
            return 0;
        }
        if(target==2) {
            return 1;
        }
        if(target == 3) {
            return 2;
        }
        
        int *products = new int[target+1];
        products[0]=0;
        products[1]=1;
        products[2]=2;
        products[3]=3;

        int max=0;
        for(int i=4;i<=target;++i) {
            max=0;
            for(int j=1;j<=i/2;++j) {
                int product = products[j]*products[i-j];
                if(max<product)
                    max=product;
                
                products[i]=max;
            }
        }
        max=products[target];
        delect[] products;
        
        return max;
    }
}