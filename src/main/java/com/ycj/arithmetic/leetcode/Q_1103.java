package com.ycj.arithmetic.leetcode;

import com.ycj.arithmetic.utils.MethodExecuteTimeUtils;

/**
 * Q_1103 分糖果 II 
 * https://leetcode-cn.com/problems/distribute-candies-to-people/
 * @author yanchengjie
 */
public class Q_1103 {

    public static int[] distributeCandies(int candies, int numPeople) {
        int[] answer = new int[numPeople];
        int cycle = 0;
        while (candies > 0) {
            for (int i = 1; i <= numPeople; i++) {
                int send = Math.min(candies, (i + numPeople * cycle));
                answer[i - 1] = answer[i - 1] + send;
                candies -= send;
            }
            cycle++;
        }
        return answer;
    }

    public static void main(String[] args) {
        MethodExecuteTimeUtils.printRunTime(() -> {
            int[] answer = distributeCandies(60, 4);
            for (int j : answer) {
                System.out.print(j + " ");
            }
        });
    }
}