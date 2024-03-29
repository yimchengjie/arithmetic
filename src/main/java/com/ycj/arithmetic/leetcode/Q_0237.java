package com.ycj.arithmetic.leetcode;

import com.ycj.arithmetic.utils.ListNode;
import com.ycj.arithmetic.utils.MethodExecuteTimeUtils;

/**
 * Q_0237 删除链表中的节点
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * @author yanchengjie
 */
public class Q_0237 {

    public static void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }

    public static void main(String[] args) {
        ListNode node5=new ListNode(5);
        ListNode node1=new ListNode(1);
        ListNode node9=new ListNode(9);
        new ListNode(4).next=node5;
        node5.next=node1;
        node1.next=node9;
        node9.next=null;
        
        MethodExecuteTimeUtils.printRunTime(() -> deleteNode(node1));
    }
}