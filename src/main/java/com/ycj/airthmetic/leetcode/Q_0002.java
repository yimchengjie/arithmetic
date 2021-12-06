package com.ycj.airthmetic.leetcode;

import com.ycj.airthmetic.utils.ListNode;
import com.ycj.airthmetic.utils.MethodExecuteTimeUtils;

/**
 * Q_0002 两数相加 
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class Q_0002 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode(0);
        ListNode pre = new ListNode(0);
        pre.next = answer;
        while (true) {
            if (l1 != null) {
                answer.val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                answer.val += l2.val;
                l2 = l2.next;
            }
            if (answer.val>=10) {
                answer.next = new ListNode(answer.val / 10) ;
                answer.val = answer.val % 10;
            }else if (l1==null&&l2==null) {
                break;
            }else{
                answer.next = new ListNode(0);
            }
            answer = answer.next;
        }
        return pre.next;
    }

    public static void main(String[] args) {
        // ListNode listNode1 = new ListNode(5);
        // ListNode listNode2 = new ListNode(5);

        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(3);
        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);
        System.out.println(listNode1);
        System.out.println(listNode2);


        MethodExecuteTimeUtils.printRunTime(() -> System.out.println(addTwoNumbers(listNode1, listNode2)));
    }
}