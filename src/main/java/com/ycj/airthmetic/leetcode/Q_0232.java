package com.ycj.airthmetic.leetcode;

import java.util.Stack;

import com.ycj.airthmetic.utils.MethodExecuteTimeUtils;

/**
 * Q_0232 用栈实现队列
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 */
public class Q_0232 {

    private Stack<Integer> inStack=null;

    private Stack<Integer> outStack=null;

    /** Initialize your data structure here. */
    public Q_0232() {
        inStack=new Stack<>();
        outStack=new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (outStack.isEmpty()) {
            while (!inStack.empty()) {
                outStack.push(inStack.pop());
            }
            return outStack.pop();
        } else {
            return outStack.pop();
        }
    }
    
    /** Get the front element. */
    public int peek() {
        if (outStack.isEmpty()) {
            while (!inStack.empty()) {
                outStack.push(inStack.pop());
            }
            return outStack.peek();
        } else {
            return outStack.peek();
        }
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.isEmpty()&&outStack.isEmpty();
    }

    public static void main(String[] args) {
        MethodExecuteTimeUtils.printRunTime(new Runnable(){
            @Override
            public void run() {
                // TODO Auto-generated method stub
                Q_0232 q=new Q_0232();
                q.push(1);
                q.push(2);
                System.out.println(q.peek());
                System.out.println(q.pop());
                System.out.println(q.empty());
            }
        });
    }
    
}