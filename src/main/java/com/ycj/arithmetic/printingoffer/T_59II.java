package com.ycj.arithmetic.printingoffer;

import com.ycj.arithmetic.utils.MethodExecuteTimeUtils;

import java.util.*;

/**
 * T_59II 队列的最大值
 * https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
 * @author yanchengjie
 */
public class T_59II {


    private final LinkedList<Integer> queue;
    private final Deque<Integer> deque=new LinkedList<>();

    public T_59II() {
        queue=new LinkedList<>();
    }

    public int maxValue() {
        return deque.isEmpty()?-1:deque.peek();
    }

    public void pushBack(int value) {
        while (!deque.isEmpty()&&value>deque.peekLast()){
            deque.pollLast();
        }
        deque.offer(value);
        queue.offer(value);
    }

    public int popFront() {
        if (queue.isEmpty()){
            return -1;
        }else{
            int first =  queue.pop();
            if (first== maxValue()){
                deque.pop();
            }
            return first;
        }
    }

    public static void main(String[] args) {
        MethodExecuteTimeUtils.printRunTime(() -> {
            T_59II test=new T_59II();
            System.out.println(test.maxValue());
            System.out.println(test.popFront());
            System.out.println(test.maxValue());
            test.pushBack(46);
            System.out.println(test.maxValue());
            System.out.println(test.popFront());
            System.out.println(test.maxValue());
            System.out.println(test.popFront());
            test.pushBack(868);
            System.out.println(test.popFront());
        });
    }
}
