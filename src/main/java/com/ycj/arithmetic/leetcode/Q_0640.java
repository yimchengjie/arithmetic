package com.ycj.arithmetic.leetcode;

import com.ycj.arithmetic.utils.MethodExecuteTimeUtils;

/**
 * Q_0640.解方程
 */
public class Q_0640 {
    public static String solveEquation(String equation) {
        String equationd = equation.replace("-", "+-");
        String[] split = equationd.split("=");
        String left = split[0];
        String right = split[1];

        int ax = 0;
        int result = 0;

        String[] lefts = left.split("\\+");
        String[] rights = right.split("\\+");

        for (String oneLeft : lefts) {
            if (oneLeft.equals("")){
                continue;
            }
            if (oneLeft.contains("x")) {
                oneLeft = oneLeft.replace("x","");
                if (oneLeft.equals("")){
                    oneLeft ="1";
                }
                if (oneLeft.contains("-")) {
                    String replace = oneLeft.replace("-", "");
                    if (replace.equals("")){
                        replace ="1";
                    }
                    ax-=Integer.parseInt(replace);
                }else {
                    ax+=Integer.parseInt(oneLeft);
                }
            }else {
                if (oneLeft.contains("-")) {
                    String replace = oneLeft.replace("-", "");
                    result+=Integer.parseInt(replace);
                }else {
                    result-=Integer.parseInt(oneLeft);
                }
            }
        }

        for (String oneRight : rights) {
            if (oneRight.equals("")){
                continue;
            }
            if (oneRight.contains("x")) {
                oneRight = oneRight.replace("x","");
                if (oneRight.equals("")){
                    oneRight ="1";
                }
                if (oneRight.contains("-")) {
                    String replace = oneRight.replace("-", "");
                    if (replace.equals("")){
                        replace ="1";
                    }
                    ax+=Integer.parseInt(replace);
                }else {
                    ax-=Integer.parseInt(oneRight);
                }
            }else {
                if (oneRight.contains("-")) {
                    String replace = oneRight.replace("-", "");
                    result-=Integer.parseInt(replace);
                }else {
                    result+=Integer.parseInt(oneRight);
                }
            }
        }

        if (ax == 0 && result == 0) {
            return "Infinite solutions";
        }else if (ax == 0){
            return "No solution";
        }
        return String.format("x=%s", result / ax);
    }

    public static void main(String[] args) {
        MethodExecuteTimeUtils.printRunTime(()->{
            System.out.println(solveEquation("2=-x"));
        });
    }
}
