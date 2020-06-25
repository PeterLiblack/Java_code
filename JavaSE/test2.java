//实现一个函数，检查二叉树是否平衡，平衡的定义如下，
//对于树中的任意一个结点，其两颗子树的高度差不超过1。
//给定指向树根结点的指针TreeNode* root，请返回一个bool，代表这棵树是否平衡。

import java.util.*;
  
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/

public class Balance {
    public boolean isBalance(TreeNode root) {
        if(root==null){
            return true;
        }else{
            int left = getDeep(root.left);
            int right = getDeep(root.right);
            if(Math.abs(left-right)<=1){
                return isBalance(root.left)&&isBalance(root.right);
            }else{
                return false;
            }
        }      
    }
      
    public int getDeep(TreeNode root){
        if(root!=null){
            int left = getDeep(root.left);
            int right = getDeep(root.right);
            return left>right?left+1:right+1;
        }else{
            return 0;
        }
    }
}

//给定一系列正整数，请按要求对数字进行分类，并输出以下5个数字：
//A1 = 能被5整除的数字中所有偶数的和；
//A2 = 将被5除后余1的数字按给出顺序进行交错求和，即计算n1-n2+n3-n4...；
//A3 = 被5除后余2的数字的个数；
//A4 = 被5除后余3的数字的平均数，精确到小数点后1位；
//A5 = 被5除后余4的数字中最大数字。

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;
import java.util.Collections;
public class Main{
    public static void main(String[] args){
        int i = 0;
        int sum;
        int countA2 = 0;
        int countA4 = 0;
        int countA5 = 0;
        int A1 = 0;
        int A2 = 0;
        int A3 = 0;
        double A4 = 0;
        int A5 = 0;
        List<Integer> list = new ArrayList<Integer>();
        Scanner input = new Scanner(System.in);
        sum = input.nextInt();
        int[] array = new int[sum];
        while(i<sum){
            array[i] = input.nextInt();
            i++;
        }
       // Arrays.sort(array);
        for(int j=0;j<array.length;j++){
            int r = array[j]%5;
            switch(r){
                case 0:{
                    if(array[j]%2==0){
                       A1+= array[j]; 
                    }
                    break;
                }
                case 1:{
                    A2 += (((countA2%2==0)?(1):(-1))*array[j]);
                    countA2++;
                    break;
                }
                 case 2:{
                    A3 ++;
                    break;
                }
                 case 3:{
                    A4 += array[j];
                    countA4++;
                    break;
                }
                 case 4:{
                    list.add(array[j]);
                    A5 = list.get(countA5);
                    countA5++;
                    break;
                }
                default:
                    break;
            }
        }
        if(A1 == 0){
            System.out.print("N"+" ");
        }else{
            System.out.print(A1+" ");
        }
          if(A2 == 0){
            System.out.print("N"+" ");
        }else{
            System.out.print(A2+" ");
        }
          if(A3 == 0){
            System.out.print("N"+" ");
        }else{
            System.out.print(A3+" ");
        }
          if(A4 == 0){
            System.out.print("N"+" ");
        }else{
             DecimalFormat df = new DecimalFormat("#.0");
            System.out.print(df.format(A4/countA4)+" ");
        }
          if(A5 == 0){
            System.out.print("N");
        }else{
            A5 = Collections.max(list);
            System.out.print(A5);
        }
    }
     
}



//例如，YrR8RrY是小红想做的珠串；那么ppRYYGrrYBR2258可以买，因为包含了
//全部她想要的珠子，还多了8颗不需要的珠子；ppRYYGrrYB225不能买，
//因为没有黑色珠子，并且少了一颗红色的珠子。

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String oldStr = sc.nextLine();
        String needStr = sc.nextLine();
 
        Map<Character,Integer> map = new HashMap<>();
        char[] chars = oldStr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])){
                int count = map.get(chars[i]);
                map.put(chars[i],count+1);
            }else {
                map.put(chars[i],1);
            }
        }
 
        char[] needChars = needStr.toCharArray();
        int lastCount = 0;
        for (int i = 0; i < needChars.length; i++) {
            if (map.containsKey(needChars[i])){
                if (map.get(needChars[i])>0){
                    int count = map.get(needChars[i]);
                    map.put(needChars[i],count-1);
                }else {
                    lastCount++;
                }
            }else {
 
                lastCount++;
            }
        }
 
        if (lastCount==0){
            System.out.println("Yes "+(oldStr.length()-needStr.length()));
        }else {
            System.out.println("No "+lastCount);
        }
 
    }
}


//有两个用链表表示的整数，每个结点包含一个数位。
//这些数位是反向存放的，也就是个位排在链表的首部。
//编写函数对这两个整数求和，并用链表形式返回结果。

//给定两个链表ListNode* A，ListNode* B，请返回A+B的结果(ListNode*)。

import java.util.*;
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

public class Plus {
    public ListNode plusAB(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        ListNode p1 = a, p2 = b;
        ListNode head = new ListNode(0);
        ListNode p = head;
        int sum = 0;
        while (p1 != null || p2 != null || sum != 0) {
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            p.next = new ListNode(sum % 10);
            sum /= 10;
            p = p.next;
        }
        return head.next;
    }
}