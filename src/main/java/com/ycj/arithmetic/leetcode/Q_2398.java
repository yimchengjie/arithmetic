package com.ycj.arithmetic.leetcode;

import java.util.Arrays;

/**
 * Q_2398. 预算内最多的机器人数目
 *
 * @author yanchengjie
 * @version : Q_6174.java, v 0.1 2022/9/3 23:03 yanchengjie Exp$
 */
public class Q_2398 {

	public static int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
		int left = 0, right = 0;
		int N = chargeTimes.length;
		int maxCount = 0;
		long sumBudge = 0;
		int maxChargeTime = 0;
		long sumRunningCosts = 0;
		while (left < N && right <= N) {
			if (sumBudge >= budget) {
				left++;
				if (left >= N) {
					break;
				}
				sumRunningCosts -= runningCosts[left - 1];
				maxChargeTime = 0;
				for (int i = left; i < right; i++) {
					maxChargeTime = Math.max(maxChargeTime,chargeTimes[i]);
				}
				sumBudge = (long) maxChargeTime + (long) (right - left) * sumRunningCosts;
			} else {
				right++;
				if (right > N) {
					break;
				}
				sumRunningCosts += runningCosts[right - 1];
				maxChargeTime = Math.max(maxChargeTime, chargeTimes[right - 1]);
				sumBudge = (long) maxChargeTime + (long) (right - left) * sumRunningCosts;
				if (sumBudge<=budget) {
					maxCount = Math.max(maxCount,right-left);
				}
			}
		}
		return maxCount;
	}

	public static void main(String[] args) {

		int[] chargeTimes = new int[50000];
		Arrays.fill(chargeTimes, 1);

		int[] runningCosts = new int[50000];
		Arrays.fill(runningCosts, 100000);

		long budget = 100000000000000L;
		System.out.println(maximumRobots(chargeTimes, runningCosts, budget));
	}

}
