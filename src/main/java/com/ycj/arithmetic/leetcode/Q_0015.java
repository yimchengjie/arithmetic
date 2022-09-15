package com.ycj.arithmetic.leetcode;

import com.alibaba.fastjson.JSON;
import com.ycj.arithmetic.utils.MethodExecuteTimeUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Q_0015.三数之和
 */
public class Q_0015 {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return nSum(nums, 0, 3, 0);
    }

    private static List<List<Integer>> nSum(int[] nums, int start, int n, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (n == 2) {
            int end = nums.length - 1;
            while (start < end) {
                int startNum = nums[start], endNum = nums[end];
                int sum = startNum + endNum;
                if (sum == target) {
                    list.add(new ArrayList<>(Arrays.asList(nums[start], nums[end])));
                    while (start < end && nums[start] == startNum) {
                        start++;
                    }
                    while (start < end && nums[end] == endNum) {
                        end--;
                    }
                } else if (sum < target) {
                    start++;
                } else if (sum > target) {
                    end--;
                }
            }
        } else {
            for (int i = start; i < nums.length; i++) {
                List<List<Integer>> lists = nSum(nums, i + 1, n - 1, target - nums[i]);
                for (List<Integer> integers : lists) {
                    integers.add(nums[i]);
                    list.add(integers);
                }
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 1, 1, 2};
        MethodExecuteTimeUtils.printRunTime(() -> {
            System.out.println(JSON.toJSONString(threeSum(nums)));
        });
    }
}
