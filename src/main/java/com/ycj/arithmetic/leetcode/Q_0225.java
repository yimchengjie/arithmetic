package com.ycj.arithmetic.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import com.ycj.arithmetic.utils.MethodExecuteTimeUtils;

/**
 * Q_0225 用队列实现栈
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 * @author yanchengjie
 */
public class Q_0225 {

    private final Queue<Integer> list;

    /**
     * 该类就是要实现的栈
     */
    public Q_0225(){
        list=new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        list.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int removed=top();
        list.remove(removed);
        return removed;
    }
    
    /** Get the top element. */
    public Integer top() {
        Iterator<Integer> iterator=list.iterator();
        Integer top=null;
        while (iterator.hasNext()) {
            top=iterator.next();
        }
        return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return list.isEmpty();
    }

    public static void main(String[] args) {
        MethodExecuteTimeUtils.printRunTime(() -> {
            Q_0225 obj = new Q_0225();
            obj.push(3);
            int param3 = obj.top();
            System.out.println(param3);
            int param2 = obj.pop();
            System.out.println(param2);
            boolean param4 = obj.empty();
            System.out.println(param4);
        });
    }
}