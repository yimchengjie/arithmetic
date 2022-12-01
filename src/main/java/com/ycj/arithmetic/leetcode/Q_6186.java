package com.ycj.arithmetic.leetcode;

import java.util.Arrays;

/**
 * Q_6186
 *
 * @author yanchengjie
 * @version : Q_6186.java, v 0.1 2022/9/17 23:14 yanchengjie Exp$
 */
public class Q_6186 {

	public int[] smallestSubarrays(int[] nums) {
		if (nums.length == 1) {
			return new int[]{1};
		}
		int MAX = 0;
		int Result = 0;
		for (int i = 0; i < nums.length; i++) {
			Result|=nums[i];
			if (Result>MAX) {
				MAX = Result;
			}
		}

		int[] counts = new int[nums.length];
		int right = 0;
		for (int i = 0; i < counts.length - 1; i++) {
			if (right<i){
				right = i;
			}
			int count = right-i+1;
			int max = nums[i];
			for (int x = i; x<=right; x++){
				max|=nums[x];
			}
			if (max < MAX) {
				int result = max;
				for (int j = right + 1; j < nums.length; j++) {
					result |= nums[j];
					System.out.println("i:" + i + "j:" + j + "result:" + result + "max" + max);
					if (result > max) {
						count = j - i + 1;
						max = result;
						right = j;
						if (max == MAX) {
							break;
						}
					}
				}
			}
			counts[i] = count;
			int temp = nums[i];
			while(i < counts.length - 1 && temp == nums[i+1]){
				if (count>1){
					counts[i+1] = --count;
				}else{
					counts[i+1] = count;
				}
				i++;
			}
		}
		counts[nums.length - 1] = 1;
		return counts;
	}

	public static void main(String[] args) {
		int[] nums = {44,45,67,87,95,1,86,51,78,24,41,23,38,47,11,89,35,68,73,57,28,83,53,38,90,40,13,33,58,51,48,60,97,95,22,35,30,83,55,9,76,55,94,31,97,100,97,6,67,36,95,35,13,16,50,89,56,46,83,44,28,67,86,51,21,81,17,70,57,99,56,16};
		System.out.println(Arrays.toString(new Q_6186().smallestSubarrays(nums)));
	}

}
