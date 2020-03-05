package com.ycj.airthmetic.leetcode;

import com.ycj.airthmetic.utils.MethodExecuteTimeUtils;

/**
 * Q_1103 分糖果 II 
 * https://leetcode-cn.com/problems/distribute-candies-to-people/
 */
public class Q_1103 {

    public static int[] distributeCandies(int candies, int num_people) {
        int[] answer = new int[num_people];
        int cycle = 0;
        while (candies > 0) {
            for (int i = 1; i <= num_people; i++) {
                int send = candies > (i + num_people * cycle) ? (i + num_people * cycle) : candies;
                answer[i - 1] = answer[i - 1] + send;
                candies -= send;
            }
            cycle++;
        }
        return answer;
    }

    public static void main(String[] args) {
        MethodExecuteTimeUtils.printRunTime(new Runnable() {
            @Override
            public void run() {
                int[] answer = distributeCandies(60, 4);
                for (int i = 0; i < answer.length; i++) {
                    System.out.print(answer[i] + " ");
                }
            }
        });
    }
}