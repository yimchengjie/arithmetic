package com.ycj.arithmetic.leetcode;

import java.util.Arrays;

/**
 * Q_2401. 最长优雅子数组
 *
 * @author yanchengjie
 * @version : Q_6169.java, v 0.1 2022/9/4 10:51 yanchengjie Exp$
 */
public class Q_2401 {
	public static int longestNiceSubarray(int[] nums) {
		int n=nums.length;
		int max = 1;
		for (int start = 0; start < n; start++) {
			for (int end = start+1; end < n; end++) {
				System.out.println(Arrays.toString(Arrays.stream(nums).skip(start).limit(end-start +1).toArray()));
				if (isNiceSubarray(nums,start,end)) {
					max = Math.max(end-start +1,max);
				}else {
					break;
				}
			}
		}
		return max;
	}

	private static boolean isNiceSubarray(int[] nums,int start,int end) {
		for (int i = start; i < end; i++) {
			for (int j = i+1; j <= end; j++) {
				if ((nums[i] & nums[j]) !=0){
					System.out.printf("false [%s,%s] \n",nums[i] , nums[j]);
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] nums = {1,3,8,48,10};
		System.out.println(longestNiceSubarray(nums));
	}
}
