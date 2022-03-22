package com.ycj.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.ycj.arithmetic.utils.ListNode;
import com.ycj.arithmetic.utils.MethodExecuteTimeUtils;

/**
 * Q_0876 链表的中间结点 
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * @author yanchengjie
 */
public class Q_0876 {

    public static ListNode middleNode(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        if (node.next==null) {
            return node;
        }
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int size = list.size();
        int answer = size / 2 ;
        return list.get(answer);
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(3);
        listNode1.next.next.next = new ListNode(4);
        listNode1.next.next.next.next = new ListNode(5);
        listNode1.next.next.next.next.next = new ListNode(6);
        listNode1.next.next.next.next.next.next = new ListNode(7);
        System.out.println(listNode1);
        MethodExecuteTimeUtils.printRunTime(() -> System.out.println(middleNode(listNode1)));
    }
}