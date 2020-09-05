//两个链表的第一个公共结点
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

import java.util.HashMap;
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode current1 = pHead1;
        ListNode current2 = pHead2;
 
        HashMap<ListNode, Integer> hashMap = new HashMap<ListNode, Integer>();
        while (current1 != null) {
            hashMap.put(current1, null);
            current1 = current1.next;
        }
        while (current2 != null) {
            if (hashMap.containsKey(current2))
                return current2;
            current2 = current2.next;
        }
        return null;
    }
}




//求平方根
import java.util.*;


public class Solution {
    public int sqrt(int x) {
        if (x== 0)
            return 0;
        int left = 1, right = x;
        while (true) {
            int mid = left + (right - left) / 2;
            //这里判断不用if (mid * mid > x)，因为使用mid > x / mid一定会有结果
            if (mid > x / mid)
                right = mid - 1;
            else {
                if(mid+1>x/(mid+1))
                    return mid;
                left=mid+1;
            }
        }
    }
}




//判断链表中是否有环
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
//遍历链表的同时，让前一个节点的next指向head（或者是任意一个指定的内存），
//在后续的遍历中，如果有节点的当前next指向了head，则说明有环。
//破坏链表，达到最快
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode p = head;
        while(p!=null){
            ListNode aft = p.next;
            if(aft==head) return true;
            p.next=head;
            p=aft;
        } 
        return false;
    }
}
