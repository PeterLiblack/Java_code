// 计算日期到天数转换
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ;
		while(sc.hasNext()) {
			int year = sc.nextInt() ;
			int month = sc.nextInt() ;
			int day = sc.nextInt() ;
			int Day = outDay(year, month, day) ;
			System.out.println(Day);
		}
		sc.close();
	}

	private static int outDay(int year, int month, int day) {
		//定义数组，这里2月的天数取28，假设是平年。
		int [] Day = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31} ;
		//对年进行添加判断以及求余
		if(year <= 0 ||month <= 0 || month > 12 || day<= 0 || day > Day[month - 1])
			return -1;
		//如果是闰年，那么2月应该有29天。
		if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			Day[1] = 29 ;
		}
		int sum = 0 ;
		//这里要注意，如果是5月14日，5月这一个月不能算进去，算前4个月。
		for(int i = 0 ; i < month - 1 ; i ++) {
			sum += Day[i] ;
		}
		//最后sum需要加上当前月份的日期。
		return sum + day;
	}
}



//字符串加解密

import java.util.*;

public class Main {
	//对字符进行加密，加密原理：当前字符的后一个字符并且是大写
	//如果是数字则加1就好了，这里要注意如果是小写z,那么对应大写A.
	//大写Z对象小写a.
	public static char encryption(char c) {
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
	//字符解密过程
	public static char decryption(char c) {
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
	//加密，将输入的字符串中的每个字符进行加密。
	public static String enCryption(String s) {
		char[] cs = s.toCharArray();
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < cs.length; i++){
			sb.append(encryption(cs[i]));
		}
		return sb.toString();
	}
	//解密
	public static String deCryption(String s) {
		char[] cs = s.toCharArray();
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < cs.length; i++) {
			sb.append(decryption(cs[i]));
		}
		return sb.toString();
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String s1 = sc.nextLine();//加过密的密码
			String s2 = sc.nextLine();//解密的密码
			System.out.println(enCryption(s1));
			System.out.println(deCryption(s2));
		}
		sc.close();
	}
}


//连续最大和

import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		while(sc.hasNext()) {
			n = sc.nextInt();
			int[] num = new int[n];
			for(int i=0;i<n;i++) {
				num[i] = sc.nextInt();
			}
			int result = maxArry(num,n);
			System.out.println(result);
		}
	}

	public static int maxArry(int[] arr,int len) {
		if(arr == null || len <= 0){
			return -1;
		}
		int maxnum = 0x80000000;
		int sum;

		for(int i = 0;i < len;i++) {
			//每次从当前位置i开始进行累加，求最大值。
			sum = 0;
			for(int j = i;j < len;j++) {
				sum = sum+arr[j];
				if(sum > maxnum) {
					maxnum = sum;
				}
			}
		}
		return maxnum;
	}
}


import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		while(sc.hasNext()){
			n = sc.nextInt();
			int[] num = new int[n];
			for(int i=0;i<n;i++){
				num[i] = sc.nextInt();
			}
			int result = maxArry(num,n);
			System.out.println(result);
		}
	}

	public static int maxArry(int[] array,int len) {
		if(array == null || len <= 0) {
			return -1;
		}
		//假设最大值为这个数字，这里有一个几千，这个数字正好是整形的最小值。
		int maxnum = 0x80000000;
		int sum = 0;
		for(int i = 0;i < len;i++) {
			if(sum <= 0) {
				sum = array[i];
			}else{
				sum += array[i];
			}
			if(sum > maxnum) {
				maxnum = sum;
			}
		}
		return maxnum;
	}
}




//坐标移动

import java.util.*;
public class Main{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		//判断是否有下一个录入的元素
		while(sc.hasNext()){
			String str=sc.nextLine();
			//使用;切割录入的字符串数据,返回字符串数组
			String[] A=str.split(";");
			int x=0,y=0;
			for(String string:A){
				//遍历字符串数组获取每一个部分内容,分别判断0索引对应的元素的内容
				//判断从1号位置开始是否有连续的1到2位的数字。(数字是0-9)
				if(string.charAt(0)=='D' && string.substring(1).matches("[0-9]{1,2}"))
					//将字符串的字符转换为整形数字
					x+=Integer.parseInt(string.substring(1));
				if(string.charAt(0)=='W' && string.substring(1).matches("[0-9]{1,2}"))
					y+=Integer.parseInt(string.substring(1));
				if(string.charAt(0)=='S' && string.substring(1).matches("[0-9]{1,2}"))
					y-=Integer.parseInt(string.substring(1));
				if(string.charAt(0)=='A' && string.substring(1).matches("[0-9]{1,2}"))
					x-=Integer.parseInt(string.substring(1));
			}
			System.out.println(x+","+y);
		}
		sc.close();
	}
}