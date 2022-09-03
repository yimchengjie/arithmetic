package com.ycj.arithmetic.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Q_6171
 *
 * @author yanchengjie
 * @version : Q_6171.java, v 0.1 2022/9/3 22:33 yanchengjie Exp$
 */
public class Q_6171 {
	public static boolean findSubarrays(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length - 1 ; i++) {
			int j = i+1;
			int sum = nums[i] + nums[j];
			if (set.contains(sum)) {
				return true;
			}
			set.add(sum);
		}
		return false;
	}

	public static void main(String[] args) {
		int[] nums = {0,0,0};
		System.out.println(findSubarrays(nums));
	}
}
