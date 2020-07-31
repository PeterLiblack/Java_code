//nowcoder有两盒（A、B）乒乓球，有红双喜的、有亚力亚的……
//现在他需要判别A盒是否包含了B盒中所有的种类，并且每种球的数量不少于B盒中的数量，
// 基本思路
// 借助 哈希表 保存每个盒子中的每种球的类别和数目.
// 然后遍历其中的一个 map 和另外一个 map 进行对比即可.

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()) {
			String boxA=sc.next();
			String boxB=sc.next();
			// 创建两个 hash 表. key 为球的种类, value 为球的数量
			HashMap<String,Integer> hashMapBoxA=new HashMap<String,Integer>();
			HashMap<String,Integer> hashMapBoxB=new HashMap<String,Integer>();
			// 初始化 BoxA
			for(int i=0;i<boxA.length();i++) {
				if(hashMapBoxA.containsKey(boxA.charAt(i)+"")) {
					hashMapBoxA.put(boxA.charAt(i)+"",hashMapBoxA.get(boxA.charAt(i)+"")+1);
				} else {
					hashMapBoxA.put(boxA.charAt(i)+"",1);
				}
			}
			// 初始化 BoxB
			for(int i=0;i<boxB.length();i++) {
				if(hashMapBoxB.containsKey(boxB.charAt(i)+"")) {
					hashMapBoxB.put(boxB.charAt(i)+"",hashMapBoxB.get(boxB.charAt(i)+"")+1);
				} else {
					hashMapBoxB.put(boxB.charAt(i)+"",1);
				}
			}
		// 遍历 BoxB, 和 BoxA 中的元素进行对比. flag 表示是否是满足包含关系
			int flag=0;
			for(String key:hashMapBoxB.keySet()) {
				if(!hashMapBoxA.containsKey(key)) {
					flag=1;
					break;
				} else {
					if(hashMapBoxA.get(key)<hashMapBoxB.get(key)) {
						flag=1;
						break;
					}
				}
			}
			if(flag==1) {
				System.out.println("No");
			} else {
				System.out.println("Yes");
			}
		}
	}
}




//先输入字典中单词的个数，再输入n个单词作为字典单词。
//输入一个单词，查找其在字典中兄弟单词的个数
//再输入数字n

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int num = in.nextInt();
			String[] s = new String[num];
			int count = 0;
			for(int i = 0;i<num;i++) {
				s[i] = in.next();
			}
			String key = in.next();
			char[] keyChar = key.toCharArray();
			Arrays.sort(keyChar);
			int no = in.nextInt();//第几个
			ArrayList<String> list = new ArrayList<String>();
			for(int i = 0;i<num;i++) {
				int c = check(key,s[i],keyChar);
				count += c;
				if(c==1)
				list.add(s[i]);
			}
			System.out.println(count);
			Collections.sort(list);
			if(count>=no)
			System.out.println(list.get(no-1));
		}
	}

	// 核心的比较函数. keyChar 在调用的时候就已经排好序了.
	private static int check(String key,String word,char[] keyChar) {
		// 就是将两个单词按字符排序后看相不相同就行了.
		if(key.equals(word)||key.length()!=word.length())
			return 0;
		char[] wordChar = word.toCharArray();
		Arrays.sort(wordChar);
		return Arrays.equals(keyChar, wordChar)?1:0;
	}
}