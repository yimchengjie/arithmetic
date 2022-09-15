package com.ycj.arithmetic.leetcode;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Q_6176
 *
 * @author yanchengjie
 * @version : Q_6176.java, v 0.1 2022/9/11 10:34 yanchengjie Exp$
 */
public class Q_6176 {

	public static int mostFrequentEven(int[] nums) {
		Map<Integer, Integer> numsCount = new HashMap<>();
		for (int num : nums) {
			if (num % 2 == 0) {
				Integer integer = numsCount.get(num);
				if (integer == null) {
					numsCount.put(num, 1);
				} else {
					numsCount.put(num, integer + 1);
				}
			}
		}
		if (numsCount.size()==0){
			return -1;
		}else{
			int maxCount = 0;
			int result = -1;
			Arrays.sort(nums);
			for (int num : nums) {
				Integer integer = numsCount.get(num);
				if (integer == null) {
					continue;
				}
				if (integer > maxCount) {
					maxCount = integer;
					result = num;
				}
			}
			return result;
		}
	}

	public static void main(String[] args) {
		int[] nums = {0, 1, 2, 2, 4, 4, 1};
		System.out.println(mostFrequentEven(nums));
	}

}
