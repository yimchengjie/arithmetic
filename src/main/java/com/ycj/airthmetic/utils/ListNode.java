package com.ycj.airthmetic.utils;

/**
 * ListNode
 */
public class ListNode {
    public int val;
    public ListNode next=null;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        ListNode node=this;
        str.append("ListNode [").append(node.val);
        while (node.next!=null) {
            node=node.next;
            str.append(","+node.val);
        }
        str.append("]");
        return str.toString();
    }
}