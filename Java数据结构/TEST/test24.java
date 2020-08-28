//二叉树平衡检查
import java.util.*;
public class Balance {
	public boolean isBalance(TreeNode root) {
		//判断根元素是否为null
		if(root == null){
			return true;
		}
		//获取左边子树高度
		int leftHeight = getTreeHeight(root.left);
		int rightHeight = getTreeHeight(root.right);
		//左右子树的高度大于1表示不是平衡二叉树
		if(Math.abs(leftHeight - rightHeight) > 1){
			return false;
		}
		//isBalance()检查是否平衡
		return isBalance(root.left) && isBalance(root.right);
		}

	//计算树的高度
	public static int getTreeHeight(TreeNode root){
		if(root == null){
			return 0;
		}
		return Math.max(getTreeHeight(root.left), getTreeHeight(root.right)) + 1;
	}
}




//数字分类
import java.util.*;
public class Main{
	public static void main(String []args){
		Scanner in=new Scanner(System.in);
		int N=in.nextInt();
		int num[]=new int[N];//n个整数
		//A1-A5功能
		//flag : A2功能中用到的错误+-
		//count: A4中计数
		int A1=0,A2=0,A3=0,A4=0,A5=0,flag=1,count=0;
		for(int i=0;i<N;i++){
			num[i]=in.nextInt();
			//A1
			if(num[i]%5==0){
				if(num[i]%2==0)
					A1+=num[i];
			}
			//A2
			if(num[i]%5==1){
				A2+=flag*num[i];
				flag=-flag;
			}
			//A3
			if(num[i]%5==2){
				A3++;
			}
			//A4
			if(num[i]%5==3){
				A4+=num[i];
				count++;
			}
			//A5
			if(num[i]%5==4){
				if(num[i]>A5)
					A5=num[i];
			}
		}
		if(A1!=0){System.out.print(A1+" ");}
		else{System.out.print('N'+" ");}
		if(A2!=0){System.out.print(A2+" ");}
		else{System.out.print('N'+" ");}
		if(A3!=0){System.out.print(A3+" ");}
		else{System.out.print('N'+" ");}
		if(A4!=0){System.out.print(A4/count+"."+(int)((A4%count*100/count+5)/10)+" ");}
		else{System.out.print("N"+" ");}
		if(A5!=0){System.out.print(A5);}
		else{System.out.print("N");}
	}
}