//微信红包

import java.util.*;
public class Gift {
	public int getValue(int[] gifts, int n) {
		Arrays.sort(gifts);//数组排序，采用Arrays的sort方法
		int ans = gifts[n/2];//理论上超过半数的数字
		int num = 0;
		//遍历数组，进行统计
		for(int i = 0; i < gifts.length; i++) {
			if(gifts[i] == ans) {
				num++;
			}
		}
		return num <= n/2 ? 0 : ans;
	}
}

import java.util.*;
public class Gift {
	public int getValue(int[] gifts, int n) {
		Arrays.sort(gifts);//数组排序，采用Arrays的sort方法
		int ans = gifts[n/2];//理论上超过半数的数字
		int num = 0;
		//遍历数组，进行统计
		for(int i = 0; i < gifts.length; i++) {
			if(gifts[i] == ans) {
				num++;
			}
		}
		return num <= n/2 ? 0 : ans;
	}
}

import java.util.*;
public class Gift {
	public int getValue(int[] gifts, int n) {
		Arrays.sort(gifts);//数组排序，采用Arrays的sort方法
		int ans = gifts[n/2];//理论上超过半数的数字
		int num = 0;
		//遍历数组，进行统计
		for(int i = 0; i < gifts.length; i++) {
			if(gifts[i] == ans) {
				num++;
			}
		}
	return num <= n/2 ? 0 : ans;
	}
}


//链表分割

import java.util.*;
public class Gift {
	public int getValue(int[] gifts, int n) {
		Arrays.sort(gifts);//数组排序，采用Arrays的sort方法
		int ans = gifts[n/2];//理论上超过半数的数字
		int num = 0;
		//遍历数组，进行统计
		for(int i = 0; i < gifts.length; i++) {
			if(gifts[i] == ans) {
				num++;
			}
		}
		return num <= n/2 ? 0 : ans;

		if (pHead == null || pHead.next == null) {
			return pHead;
		}
		ListNode cur = pHead;
		//定义2个链表，此处Shead Bhead两个头指针
		ListNode Shead = new ListNode(-1);
		ListNode Bhead = new ListNode(-1);
		ListNode Stmp = Shead;
		ListNode Btmp = Bhead;
		while (cur != null) {
			if (cur.val < x) {//值小于x的节点
				Stmp.next = new ListNode(cur.val);
				Stmp = Stmp.next;
			} else {//值大于等于x的节点
				Btmp.next = new ListNode(cur.val);
				Btmp = Btmp.next;
			}
			cur = cur.next;
		}
		//第1个链表的头
		cur = Shead;
		//循环遍历找到第1个链表的尾
		while (cur.next != null && cur.next.val != -1) {
		cur = cur.next;
		}
		//cur的next指向第2个节点的next(非头节点)
		//相当于将第1个链表和第2个链表连接
		cur.next = Bhead.next;
		return Shead.next;//返回第1个节点next(不含头节点)
	}
}