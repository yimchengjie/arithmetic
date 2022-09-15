package com.ycj.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Q_0018. 四数之和
 */
public class Q_0018 {

    public static void main(String[] args) {
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        System.out.println(fourSum(nums, target));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        return nSum(0, target, 4, nums);
    }

    public static List<List<Integer>> nSum(int startIndex, long target, int n, int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (n == 2) {
            int endIndex = nums.length - 1;
            while (startIndex < endIndex) {
                int startValue = nums[startIndex];
                int endValue = nums[endIndex];
                long sum = startValue + endValue;
                if (sum < target) {
                    while (startIndex < endIndex && startValue == nums[startIndex]) startIndex++;
                } else if (sum > target) {
                    while (startIndex < endIndex && endValue == nums[endIndex]) endIndex--;
                } else {
                    list.add(new ArrayList<>(Arrays.asList(startValue, endValue)));
                    while (startIndex < endIndex && startValue == nums[startIndex]) startIndex++;
                    while (startIndex < endIndex && endValue == nums[endIndex]) endIndex--;
                }
            }
        } else {
            for (int i = startIndex; i < nums.length; i++) {
                int temp = nums[i];
                List<List<Integer>> lists = nSum(i + 1, target - temp, n - 1, nums);
                for (List<Integer> integers : lists) {
                    integers.add(temp);
                    integers.sort(Integer::compareTo);
                    list.add(integers);
                }
                while (i < nums.length && nums[i] == temp) {
                    i++;
                }
                i--;
            }
        }
        return list;
    }
}
