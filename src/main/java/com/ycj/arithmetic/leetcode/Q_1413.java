package com.ycj.arithmetic.leetcode;

import com.ycj.arithmetic.utils.MethodExecuteTimeUtils;

/**
 * Q_1413. 逐步求和得到正数的最小值
 * https://leetcode.cn/problems/minimum-value-to-get-positive-step-by-step-sum/
 */
public class Q_1413 {
    public static int minStartValue(int[] nums) {
        int minSum = 0;
        int curSum = 0;
        for (int num : nums) {
            curSum += num;
            if (curSum < minSum) {
                minSum = curSum;
            }
        }
        return -minSum + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-3,2,-3,4,2};
        MethodExecuteTimeUtils.printRunTime(()-> System.out.println(minStartValue(nums)));
    }
}
