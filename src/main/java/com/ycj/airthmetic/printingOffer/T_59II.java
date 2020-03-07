package com.ycj.airthmetic.printingOffer;

import com.ycj.airthmetic.utils.MethodExecuteTimeUtils;

import java.util.*;

/**
 * T_59II 队列的最大值
 * https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
 */
public class T_59II {


    private LinkedList<Integer> queue=null;
    private Deque<Integer> deque=new LinkedList<>();

    public T_59II() {
        queue=new LinkedList<>();
    }

    public int max_value() {
        return deque.isEmpty()?-1:deque.peek();
    }

    public void push_back(int value) {
        while (!deque.isEmpty()&&value>deque.peekLast()){
            deque.pollLast();
        }
        deque.offer(value);
        queue.offer(value);
    }

    public int pop_front() {
        if (queue.isEmpty()){
            return -1;
        }else{
            int first =  queue.pop();
            if (first==max_value()){
                deque.pop();
            }
            return first;
        }
    }

    public static void main(String[] args) {
        MethodExecuteTimeUtils.printRunTime(() -> {
            T_59II test=new T_59II();
            System.out.println(test.max_value());
            System.out.println(test.pop_front());
            System.out.println(test.max_value());
            test.push_back(46);
            System.out.println(test.max_value());
            System.out.println(test.pop_front());
            System.out.println(test.max_value());
            System.out.println(test.pop_front());
            test.push_back(868);
            System.out.println(test.pop_front());

            /*System.out.println(test.pop_front());
            test.push_back(15);
            System.out.println(test.max_value());
            test.push_back(9);
            System.out.println(test.max_value());*/
        });
    }
}
