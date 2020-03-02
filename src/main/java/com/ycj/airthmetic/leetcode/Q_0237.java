package com.ycj.airthmetic.leetcode;

import com.ycj.airthmetic.utils.MethodExecuteTimeUtils;

/**
 * Q_0237 删除链表中的节点
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 */
public class Q_0237 {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { 
            val = x; 
        }
    }

    public static void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
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
                deleteNode(node1);
            }
        });
    }
}