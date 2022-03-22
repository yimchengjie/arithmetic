package com.ycj.arithmetic.leetcode;

import com.ycj.arithmetic.utils.MethodExecuteTimeUtils;

/**
 * Q_0322 零钱兑换
 * https://leetcode-cn.com/problems/coin-change/
 * @author yanchengjie
 */
public class Q_0322 {

    public static int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        // F(x)表示组成x需要的硬币个数
        // 那么  F(x)=F(x-coins[i])+1
        return coinChange(coins, amount, new int[amount]);
    }

    public static int coinChange(int[] coins, int amount, int[] counts) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (counts[amount - 1] != 0) {
            return counts[amount - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, amount - coin, counts);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        counts[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return counts[amount - 1];
    }

    public static void main(String[] args) {
        MethodExecuteTimeUtils.printRunTime(() -> {
            int count = coinChange(new int[] { 1, 2, 5 }, 11);
            System.out.println(count);
        });
    }
}