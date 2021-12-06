package com.ycj.airthmetic.leetcode;

import java.util.Stack;

import com.ycj.airthmetic.utils.MethodExecuteTimeUtils;


/**
 * Q0020 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class Q_0020 {

    // 遇到左括号入栈, 遇到右括号出栈比较
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] ss = s.toCharArray();
        int length = ss.length;
        for (int i = 0; i < length; i++) {
            if (ss[i] == '{' || ss[i] == '(' || ss[i] == '[') {
                stack.push(ss[i]);
            }else{
                if (stack.isEmpty()) {
                    return false;
                }else{
                    char left=stack.pop();
                    if(left=='('&&ss[i]!=')'){
                        return false;
                    }
                    if(left=='['&&ss[i]!=']'){
                        return false;
                    }
                    if(left=='{'&&ss[i]!='}'){
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