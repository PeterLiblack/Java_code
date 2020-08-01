// 思路很简单.
// 骆驼命名法
// 首先一个字符一个字符的读取内容
// 1. 遇到 _ 就直接跳过
// 2. 如果上一个字符是 _ 则下一个字符转为大写字母
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		while(scanner.hasNext()) {
			String str=scanner.nextLine();
			// 先将字符串按 _ 切分
			String[] words=str.split("_");
			String result=words[0];
			for(int i=1;i<words.length;i++) {
				// 将首字母转为大写即可.
				result+=(char)(words[i].charAt(0)-'a'+'A');
				for(int j=1;j<words[i].length();j++) {
					result+=words[i].charAt(j);
				}
			}
		System.out.println(result);
		}
	}
}




// 单词倒排
// 这个问题是包含了字符串常见操作的 切分 和 合并
// 核心是在于 split 的用法
import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()) {
			String str=sc.nextLine();
			// 使用正则表达式作为分割符.
			String []strArray=str.split("[^a-zA-Z]+");
			for(int i=strArray.length-1;i>=2;i--) {
				System.out.print(strArray[i]+' ');
			}
			if(strArray[0].length()==0)//如果字符串数组的第一个元素是空串，那么下标为1的元素就是最后一个要输出的元素，末尾不要再加空格
				System.out.println(strArray[1]);
			else
				System.out.println(strArray[1]+' '+strArray[0]);
		}
	}
}




// 电话号码
// 借助字符串当成一个表, 完成字母和数字之间的转换即可. 注意处理大小写的情况.
import java.util.*;

public class Main {
	public static void main(String[] args) {
	// symbol 和 number 对应下标的字符是有对应关系的.
		String symbol="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		String number="222333444555666777788899991234567890";
		Scanner scanner=new Scanner(System.in);
		while(scanner.hasNext()) {
			int n=scanner.nextInt();
			ArrayList<String> arrayList=new ArrayList<String>();
			for(int i=0;i<n;i++) {
				String str=scanner.next();
				str=str.replace("-","");
				String result="";
				for(int j=0;j<7;j++) {
					result+=number.charAt(symbol.indexOf(str.charAt(j)+""));
				}
				result=result.substring(0,3)+"-"+result.substring(3,7);
				if(!arrayList.contains(result))
					arrayList.add(result);
			}
			Collections.sort(arrayList);
			for(int j=0;j<arrayList.size();j++) {
			 System.out.println(arrayList.get(j));
			}
			System.out.println();
		}
	}
}




// 基于递归实现 dfs(深度优先搜索) 即可. 这是一个比较典型的背包问题
// 核心思路, 基于递归实现 dfs(深度优先搜索) 即可. 这是一个比较典型的背包问题.
// 假设问题的解为F(n, m)，可分解为两个子问题 F(n-1, m-n)和F(n-1, m)。对这两个问题递归求解，求解过
// 程中，如果找到了符合条件的数字组合，则打印出来
// 例如 1, 2, 3, 4, 5, 求有多少中组合和为 5
// 对于 1 这个元素来说, 可能会放到结果中, 可能不放到结果中
// 如果放到结果中, 就相当于求 2...5 中取若干个数字和为 4. (即为F(n-1, m-n))
// 如果不放到结果中, 就相当于求 2...5 中取若干个数字和为 5. (即为F(n-1, m))
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	// res 用于保存最终结果
	static ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, m;
		while(sc.hasNext()) {
			n = sc.nextInt();
			m = sc.nextInt();
			// 核心逻辑在此. 注意理解 m, n 的含义.
			// 题目要求是求 1...n 中取若干个数, 和为 m
			dfs(1, m, n);
			// 打印结果集合
			for(ArrayList<Integer> l : res) {
				int i = 0;
				for(; i < l.size() - 1; i++) {
					System.out.print(l.get(i) + " ");
				}
				System.out.println(l.get(i));
			}
		}
	}
	public static void dfs(int index, int count, int n) {
		if(count == 0) {
			res.add(new ArrayList<>(list));
		} else {
			for(int i = index; i <= count && i <= n; i++) {
			list.add(i);
			// 此处进行了递归, 对问题进行拆解.
			// 求 1...n 中取若干个数字和为 m, 能把问题拆解为
			// 求 2...n 中取若干给数字, 和为 m - 1
			dfs(i + 1, count - i, n);
			list.remove(list.size() - 1);
			}
		}
	}
}