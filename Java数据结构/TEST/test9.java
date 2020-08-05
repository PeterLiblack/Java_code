//二维数组打印
import java.util.*;

public class Printer {
	public int[] arrayPrint(int[][] arr, int n) {
		// write code here
		int[] res = new int[n*n];
		int index = 0;
		int startX = 0;
		int startY = n-1;
		while(startX < n){
			int x = startX;
			int y = startY;
			while(x<n&&y<n)
				res[index++]=arr[x++][y++];
			if(startY>0)
				startY--;//确定新的开始纵坐标
			else
				startX++;//确定新的开始横坐标
		}
		return res;
	}
}




//回文串
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String s = sc.nextLine();
			//去掉两端或者本身是否是回文
			if (isPalindrome(s.substring(0, s.length() - 1)) || isPalindrome(s.substring(1, s.length()))|| isPalindrome(s)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
	//这个函数是判断字符串是否为回文串
	public static boolean isPalindrome(String s) {
		return new StringBuilder(s).reverse().toString().equals(s);
	}
}



//最近公共祖先
import java.util.*;

public class LCA {
	public int getLCA(int a, int b) {
		while (a != b) {
			if (a > b) {
				a /= 2;
			}else {
				b /= 2;
			}
		}
		return a;
	}
}





//空格替换
import java.util.*;

public class Replacement {
	public String replaceSpace(String iniString, int length) {
		// 如果允许分配额外空间
		if (iniString == null || iniString.length() <= 0) {
			return iniString;
		}
		StringBuilder sb = new StringBuilder();
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




import java.util.*;

public class Replacement {
	public String replaceSpace(String iniString, int length) {
		//字符串生成字符数组
		char[] ch = iniString.toCharArray();
		if(iniString == null || length <= 0) {
			return null;
		}
		int mLen = 0;//计算字符的个数
		int numBlank = 0;//计算空格的数组
		int i = 0;//从0号下标开始遍历
		while(i < ch.length) {
			++mLen;
			if(ch[i] == ' ') {
				++numBlank;
			}
			++i;
		}
		//替换为%20之后，新数组的长度。
		int newlen = mLen + numBlank * 2;//a%20b%20c%20d a b c d
		//新的数组
		char []ch2 = new char[newlen];
		//先把ch里面的内容，全部拷贝到ch2,我们要在ch2里面进行操作。
		System.arraycopy(ch,0,ch2,0,length);
		int indexofMLen = mLen-1;//也必须减一
		int indexofnew = newlen-1;//不减一就越界了
		while(indexofnew > indexofMLen && indexofMLen >= 0) {
			if(ch2[indexofMLen] == ' ') {
				ch2[indexofnew--] = '0';
				ch2[indexofnew--] = '2';
				ch2[indexofnew--] = '%';
			} else {
				ch2[indexofnew] = ch2[indexofMLen];
				indexofnew--;
			}
			--indexofMLen;
		}
		return String.copyValueOf(ch2);
	}
}