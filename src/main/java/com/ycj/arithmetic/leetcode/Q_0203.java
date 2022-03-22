package com.ycj.arithmetic.leetcode;

import com.ycj.arithmetic.utils.ListNode;
import com.ycj.arithmetic.utils.MethodExecuteTimeUtils;

/**
 * Q_0203 移除链表元素
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * @author yanchengjie
 */
public class Q_0203 {

    public static ListNode removeElements(ListNode head, int val) {
        if (head==null) {
            return null;
        }
        while (head.val == val) {
            head = head.next;
            if (head==null) {
                return null;
            }
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(6);
        listNode1.next.next.next = new ListNode(3);
        listNode1.next.next.next.next = new ListNode(4);
        listNode1.next.next.next.next.next = new ListNode(5);
        listNode1.next.next.next.next.next.next = new ListNode(6);
        System.out.println(listNode1);
        MethodExecuteTimeUtils.printRunTime(() -> System.out.println(removeElements(listNode1, 6)));
    }
}