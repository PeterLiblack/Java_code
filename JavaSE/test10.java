//有一棵无穷大的满二叉树，其结点按根结点一层一层地从左往右依次编号，根结点编号为1。
//现在有两个结点a，b。请设计一个算法，求出a和b点的最近公共祖先的编号。给定两个int a,b。
//为给定结点的编号。请返回a和b的最近公共祖先的编号。注意这里结点本身也可认为是其祖先。

import java.util.*;

public class LCA {
    public int getLCA(int a, int b) {
        // write code here
        while(a!=b){
            if(a>b) a/=2;
            else    b/=2;
        }
        return a;
    }
}



//编写一个方法，将字符串中的空格全部替换为“%20”。假定该字符串有足够的空间存放新增的字符，
//并且知道字符串的真实长度(小于等于1000)，同时保证字符串由大小写的英文字母组成。
//给定一个string iniString 为原始的串，以及串的长度 int len, 返回替换后的string。

import java.util.*;
 
public class Replacement {
    public String replaceSpace(String iniString, int length) {
        // 如果允许分配额外空间
        if (iniString == null || iniString.length() <= 0)
            return iniString;
         
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            char c = iniString.charAt(i);
            if (c == ' ')
                sb.append("%20");
            else
                sb.append(c);
        }
        return sb.toString();
    }
}




/**
 *  题意很简单，主要是边界的处理：
 *   1. 沿着主对角线打印，所以每次打印之后x与y都要加1，直到x或y超出边界。
 *   2. 每轮遍历的起始点，是遵循(0,n-1)...（0,0）...（n-1,0）。
  *           也就是y先减小到0，然后x增加到n-1。所以遍历的终止条件是startX>=n。 *
 **/
import java.util.*;
 
public class Printer {
    public int[] arrayPrint(int[][] arr, int n) {
        // write code here
        int[] res = new int[n*n];
        int index = 0;
        int startX = 0;
        int startY = n-1;
        while(startX<n){
            int x = startX;
            int y = startY;
            while(x<n&&y<n)
                res[index++]=arr[x++][y++];
            if(startY>0)
                startY--;
            else
                startX++;
        }
        return res;
    }
}


//给定一个字符串，问是否能通过添加一个字母将其变为回文串。

import java.util.*;

public class Main{
    public static void main(String as[]){
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
           String s=in.next();
           System.out.println(getAns(s.toCharArray(),0,s.length()-1,false)?"YES":"NO");
        }
    }
    private static boolean getAns(char[] a,int start,int end,boolean flag){
        if(end<=start){
            return true;
        }
        if(a[start]==a[end]){
            return getAns(a,start+1,end-1,flag);
        }
        else{
           if(flag){
               return false;
           }
           return getAns(a,start,end-1,true)||getAns(a,start+1,end,true);
        }
    }
}