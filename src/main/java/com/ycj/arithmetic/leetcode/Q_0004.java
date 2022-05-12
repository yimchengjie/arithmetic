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
	public static void findMedianSortedArrays(int[] nums1, int[] nums2) {

	}

	public static void main(String[] args) {
		int[] nums1 = new int[]{1,3}, nums2 = new int[]{2};
		MethodExecuteTimeUtils.printRunTime(()->findMedianSortedArrays(nums1,nums2));
	}
}
