//删除公共字符
import java.util.*;

public class Main {
	public static String DeleteChars(String str1,String str2) {
		if(str1==null || str2==null)
			return null;
		//数组大小为256因为，字符最多256个
		boolean[] hashTable = new boolean[256];
		int lenStr2 = str2.length();
		int i = 0;
		//将str2中字符对应的hashtable数组中的位置上的值设为ture
		while(i < lenStr2) {
			int index = str2.charAt(i);
			hashTable[index] = true;
			i++;
		}
		char[] str1s = str1.toCharArray();
		int k = 0;
		int j = 0;
		//开始遍历str1,没有出现过的字符，覆盖掉出现过的字符
		while(k < str1s.length) {
			int index = str1s[k];
			//如果没有出现过，建议画图理解
			if(!hashTable[index]) {
				str1s[j++] = str1s[k];
			}
			k++;
		}
		//不进行重新拷贝的话，打印果会包含原有的部分数据。
		str1s = Arrays.copyOf(str1s,j);
		return String.copyValueOf(str1s);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String s1 = sc.nextLine();
			String s2 = sc.nextLine();
			String str = DeleteChars(s1,s2);
			System.out.println(str);
		}
	}
}




//句子逆序

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while (cin.hasNextLine()) {
			String str = cin.nextLine();
			System.out.println(reverseSentence(str));
		}
	}

	//逆置函数
	public static void reverse(char[] ch,int start,int end) {
		while(start < end) {
			char tmp=ch[start];
			ch[start]=ch[end];
			ch[end]=tmp;
			start++;
			end--;
		}
	}

	//核心代码
	public static String reverseSentence(String str) {
		if(str == null) {
			return null;
		}
		char[] ch = str.toCharArray();
		//先对整体进行逆置
		reverse(ch,0,str.length()-1);
		int i = 0;
		int j = 0;
		//开始部分逆置，建议对着代码进行画图理解
		while(i < ch.length) {
			//都是空格，都进行++
			if(ch[i] == ' ') {
				i++;
				j++;
			}else if(j == ch.length || ch[j] == ' ' ) {//顺序不能反，否则会空指针异常
			//逆置每个单词,这里是--j，j本身会发生移动
				reverse(ch,i,--j);
				i = ++j;
			}else {
				++j;
			}
		}
		return String.copyValueOf(ch);
	}
}