package com.ycj.arithmetic.leetcode;

import java.util.HashSet;

import com.ycj.arithmetic.utils.ListNode;
import com.ycj.arithmetic.utils.MethodExecuteTimeUtils;

/**
 * Q_0141 环形链表 https://leetcode-cn.com/problems/linked-list-cycle/
 * @author yanchengjie
 */
public class Q_0141 {

    /**
     * 快慢指针 环形会相遇
     */
    public static boolean hasCycle1(ListNode head) {
        if (head != null && head.next != null) {
            ListNode slow = head;
            ListNode fast = head.next;
            while (fast != null && fast.next != null) {
                if (slow == fast) {
                    return true;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        return false;
    }

    /**
     * HashSet方法
     * @param head 头节点
     * @return
     * HashSet中不能有重复的值
     * 只需要遍历一遍链表,每个节点都存入HashSet
     *      如果出现空,说明链表无环,尾结点指向null
     *      如果出现节点在HashSet中存在,表面是第二次添加该节点, 说明有环
     * 他的运行次数就是链表所有节点的个数
     */
    public static boolean hasCycle2(ListNode head) {
        if (head != null && head.next != null) {
            HashSet<ListNode> set = new HashSet<>();
            set.add(head);
            while (head.next != null) {
                if (set.contains(head.next)) {
                    return true;
                }
                set.add(head.next);
                head = head.next;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node1 = new ListNode(1);
        ListNode node9 = new ListNode(9);
        node4.next = node5;
        node5.next = node1;
        node1.next = node9;
        node9.next = node5;
        MethodExecuteTimeUtils.printRunTime(() -> System.out.println( hasCycle1(node4)));

        MethodExecuteTimeUtils.printRunTime(() -> System.out.println( hasCycle2(node4)));
    }
}