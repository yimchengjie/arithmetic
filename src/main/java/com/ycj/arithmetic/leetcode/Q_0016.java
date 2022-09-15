package com.ycj.arithmetic.leetcode;

import com.ycj.arithmetic.utils.MethodExecuteTimeUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Q_0016.最接近的三数之和
 */
public class Q_0016 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> lists = nSum(nums, 0, target, 3);
        int minSum = Integer.MAX_VALUE;
        int minSub = Integer.MAX_VALUE;
        for (List<Integer> list : lists) {
            int sum = 0;
            for (Integer integer : list) {
                sum += nums[integer];
            }
            int sub = Math.abs(sum - target);
            if (sub < minSub) {
                minSum = sum;
                minSub = sub;
            }
        }
        return minSum;
    }

    public List<List<Integer>> nSum(int[] nums, int startIndex, int target, int n) {
        List<List<Integer>> list = new ArrayList<>();
        if (n == 2) {
            int minSubValue = Integer.MAX_VALUE;
            int mostLikeStartIndex;
            int mostLikeEndIndex;
            int endIndex = nums.length - 1;
            List<List<Integer>> mostLLikeList = new ArrayList<>();
            while(startIndex < endIndex) {
                int startValue = nums[startIndex];
                int endValue = nums[endIndex];
                int sum = startValue + endValue;
                if (Math.abs(sum - target) < minSubValue) {
                    mostLikeStartIndex = startIndex;
                    mostLikeEndIndex = endIndex;
                    minSubValue = Math.abs(sum - target);
                    mostLLikeList = new ArrayList<>();
                    mostLLikeList.add(new ArrayList<>(Arrays.asList(mostLikeStartIndex, mostLikeEndIndex)));
                }
                if (sum < target) {
                    startIndex++;
                }else{
                    endIndex--;
                }
            }
            list.addAll(mostLLikeList);
        } else {
            for (int i = startIndex; i < nums.length; i++) {
                List<List<Integer>> list1 = nSum(nums, i + 1, target - nums[i], n - 1);
                for (List<Integer> integers : list1) {
                    integers.add(i);
                    list.add(integers);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        Q_0016 run = new Q_0016();
        MethodExecuteTimeUtils.printRunTime(() -> {
            System.out.println(run.threeSumClosest(nums, target));
        });
    }

}
