package com.ycj.airthmetic.leetcode;

import java.util.HashSet;

import com.ycj.airthmetic.utils.ListNode;
import com.ycj.airthmetic.utils.MethodExecuteTimeUtils;

/**
 * Q_0083 删除排序链表中的重复元素
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
public class Q_0083 {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head==null) {
            return null;
        }
        HashSet<Integer> set=new HashSet<>();
        ListNode node = head;
        ListNode pre = null;
        while (node!=null) {
            if (set.contains(node.val)) {
                pre.next=node.next;
            }else{
                set.add(node.val);
                pre=node;
            }
            node=node.next;
        }
        return head;
    }



    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(1);
        listNode1.next.next = new ListNode(1);
        listNode1.next.next.next = new ListNode(2);
        listNode1.next.next.next.next = new ListNode(3);
        listNode1.next.next.next.next.next = new ListNode(3);
        listNode1.next.next.next.next.next.next = new ListNode(4);
        System.out.println(listNode1);

        MethodExecuteTimeUtils.printRunTime(() -> System.out.println(deleteDuplicates(listNode1)));
    }
}