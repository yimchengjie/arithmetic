package com.ycj.arithmetic.utils;

import java.util.Objects;

/**
 * ListNode
 * @author yanchengjie
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
            str.append(",").append(node.val);
        }
        str.append("]");
        return str.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListNode listNode = (ListNode) o;
        return val == listNode.val && Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}