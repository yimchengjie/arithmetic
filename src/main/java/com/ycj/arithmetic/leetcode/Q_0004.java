package com.ycj.arithmetic.leetcode;

import com.ycj.arithmetic.utils.MethodExecuteTimeUtils;

/**
 * Q_0004 寻找两个正序数组的中位数
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 *
 * @author yanchengjie
 * @version : Q_0004.java, v 0.1 2022/3/23 0:44 yanchengjie Exp$
 */
public class Q_0004 {

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int length = nums1.length + nums2.length;
		int size = 0;
		int[] result = new int[length / 2 + 1];
		int i = 0, j = 0;
		while (size < length / 2 + 1) {
			if (i == nums1.length) {
				result[size] = nums2[j];
				j++;
				size++;
				continue;
			}
			if (j == nums2.length) {
				result[size] = nums1[i];
				i++;
				size++;
				continue;
			}
			if (nums1[i] > nums2[j]) {
				result[size] = nums2[j];
				j++;
			} else {
				result[size] = nums1[i];
				i++;
			}
			size++;
		}
		if (length % 2 == 0) {
			return (result[size - 1] + result[size - 2]) / 2.0;
		} else {
			return result[size - 1];
		}
	}

	public static void main(String[] args) {
		int[] nums1 = new int[]{1, 2}, nums2 = new int[]{3, 4};
		MethodExecuteTimeUtils.printRunTime(() -> System.out.println(findMedianSortedArrays(nums1, nums2)));
	}
}
