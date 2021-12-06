package com.ycj.airthmetic.leetcode;

import com.ycj.airthmetic.utils.MethodExecuteTimeUtils;

/**
 * Q_0121 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class Q_0121 {

    public static int maxProfit(int[] prices) {
        if (prices==null) {
            return 0;
        }
        if (prices.length==1) {
            return 0;
        }
        int max=0;
        int sub=0;
        int startIndex=0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[startIndex]>prices[i]) {
                startIndex=i;
            }
            sub=prices[i]-prices[startIndex];
            if (sub>max) {
                max=sub;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] question=new int[]{7,1,5,3,6,4};
        MethodExecuteTimeUtils.printRunTime(()-> System.out.println(maxProfit(question)));
    }
}