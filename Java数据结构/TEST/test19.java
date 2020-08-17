//守形数
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			isShouXingShu(scanner.nextInt());
		}
	}
	public static void isShouXingShu(int x) {
		int x2 = x * x;
		String s1 = String.valueOf(x); //原数字转String
		String s2 = String.valueOf(x2);//原数字平方转String
		//平方数从低位截取，相当于字符串从末尾截取
		String s = s2.substring(s2.length() - s1.length(), s2.length());
		if (s.equals(s1))
			System.out.println("Yes!");
		else
			System.out.println("No!");
	}
}




//-密码验证合格程序

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
		//子串校验
		//a.从下标i开始，每次截取2个字符的字符串
		//b.从下标i+1开始截取剩余字符构成字符串，判断是否包含a中截取的字符串
		//包含说明出现重复，不包含说明没有重复
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