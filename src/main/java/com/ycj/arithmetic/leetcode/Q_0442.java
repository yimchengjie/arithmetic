package com.ycj.arithmetic.leetcode;

import com.ycj.arithmetic.utils.MethodExecuteTimeUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Q_0442
 *
 * @author yanchengjie
 * @version : Q_0442.java, v 0.1 2022/5/8 23:53 yanchengjie Exp$
 */
public class Q_0442 {

	public static void main(String[] args) {
		int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
		MethodExecuteTimeUtils.printRunTime(() -> {
			List<Integer> list = findDuplicates(nums);
			System.out.println(list);
		});
	}

	private static List<Integer> findDuplicates(int[] nums) {
		List<Integer> result = new ArrayList<>(nums.length/2);
		for (int i = 0; i < nums.length; i++) {
			int value = Math.abs(nums[i]);
			if (nums[value-1] > 0) {
				nums[value-1] = -nums[value-1];
			}else{
				result.add(Math.abs(nums[i]));
			}
		}
		return result;
	}
}
