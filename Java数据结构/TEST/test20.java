// 找x
import java.util.Arrays;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.nextLine();//输入第一个数 表示数字个数 n
		String[] nums = sc.nextLine().split(" ");//输入n个数字，空格分割
		String x = sc.nextLine();//输入要找的数字
		System.out.println(Arrays.asList(nums).indexOf(x));
	}
}




// 整数与IP地址间的转换
import java.util.*;
public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String ip = sc.nextLine(); //输入IP地址字符串
			String ip10 = sc.nextLine();//输入10进制表示的IP地址字符串
			System.out.println(convertIp10(ip));//IP地址转10进制字符串
			System.out.println(convertIp(ip10));//10进制IP地址转IP地址
		}
	}

	private static long convertIp10(String ip){
		String[] ips = ip.split("\\.");//使用.分割
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<ips.length;i++){
			sb.append(binaryString(ips[i]));//10进制数转二进制字符串
		}
		return Long.parseLong(sb.toString(),2);
	}

	private static String binaryString(String s){//十进制转换为8位二进制
		StringBuffer sb = new StringBuffer();
		int num = Integer.parseInt(s);
		int k = 1<<7;
		for(int i=0;i<8;i++){
			int flag = (num&k)==0?0:1;
			sb.append(flag);
			num=num<<1;
		}
		return sb.toString();
	}

	private static String convertIp(String ip10){
		StringBuffer sb = new StringBuffer();
		String ip2 = Long.toBinaryString(Long.parseLong(ip10));//长整型转二进制字符串（JDK Long的
		静态方法）
		String as = "";
		if(ip2.length()<32){//不足32位前面补0
			for(int i=0;i<32-ip2.length();i++){
				as +="0";
			}
		}
		ip2 = as+ip2;
		//IP地址每一段进行拼接
		String[] ips = new String[4];
		ips[0] = ip2.substring(0,8);
		ips[1] = ip2.substring(8,16);
		ips[2] = ip2.substring(16,24);
		ips[3] = ip2.substring(24);
		for(int i=0;i<4;i++){
			sb.append(Integer.parseInt(ips[i],2));
			if(i!=3){
				sb.append(".");
			}
		}
		return sb.toString();
	}
}