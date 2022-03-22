package com.ycj.arithmetic.leetcode;

import java.util.Stack;

import com.ycj.arithmetic.utils.MethodExecuteTimeUtils;


/**
 * Q0020 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 * @author yanchengjie
 */
public class Q_0020 {

    /**
     * 遇到左括号入栈, 遇到右括号出栈比较
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] ss = s.toCharArray();
        for (char c : ss) {
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char left = stack.pop();
                    if (left == '(' && c != ')') {
                        return false;
                    }
                    if (left == '[' && c != ']') {
                        return false;
                    }
                    if (left == '{' && c != '}') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        MethodExecuteTimeUtils.printRunTime(() -> System.out.println(isValid("[")));
    }
}