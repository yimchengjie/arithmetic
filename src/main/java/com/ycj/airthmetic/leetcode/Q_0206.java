package com.ycj.airthmetic.leetcode;

import java.util.Stack;

import com.ycj.airthmetic.utils.ListNode;
import com.ycj.airthmetic.utils.MethodExecuteTimeUtils;

/**
 * Q_0206 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class Q_0206 {

    // 递归
    public static ListNode reverseList(ListNode head) {
        if (head==null) {
            return head;
        }
        if (head.next==null) {
            return head;
        }
        ListNode newHead=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }


    // 迭代
    public static ListNode reverseList1(ListNode head) {
        if (head==null||head.next==null) {
            return head;
        }
        ListNode newHead=null;
        ListNode curr=head;
        while (curr!=null) {
            ListNode temp=curr.next;
            curr.next=newHead;
            newHead=curr;
            curr=temp;
        }
        return newHead;
    }

    // 占用内存过多
    public static ListNode reverseList2(ListNode head) {
        Stack<ListNode> stack=new Stack<>();
        stack.push(head);
        ListNode next=head.next;
        while (next!=null) {
            stack.push(next);
            next=next.next;
        }
        ListNode newHead=stack.pop();
        next=stack.pop();
        newHead.next=next;
        while(next!=null&&!stack.isEmpty()){
            next.next=stack.pop();
            next=next.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        ListNode node1=new ListNode(1);
        ListNode node9=new ListNode(9);
        node4.next=node5;
        node5.next=node1;
        node1.next=node9;
        node9.next=null;

        MethodExecuteTimeUtils.printRunTime(new Runnable(){
            @Override
            public void run() {
                System.out.println(reverseList1(node4).val);
            }
        });
    }
    
}