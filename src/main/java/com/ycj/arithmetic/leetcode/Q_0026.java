package com.ycj.arithmetic.leetcode;


import com.ycj.arithmetic.utils.MethodExecuteTimeUtils;

import java.util.Arrays;

/**
 * Q_0026. 删除有序数组中的重复项
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/submissions/
 */

public class Q_0026 {
    public static int removeDuplicates(int[] nums) {
        if (nums == null){
            return 0;
        }
        int newLength=nums.length;
        int point = 1;
        int cur = 0;
        while(point< nums.length) {
            if (nums[point] == nums[cur]) {
                point++;
                newLength--;
            }else {
                nums[cur+1] = nums[point];
                cur++;
                point++;
            }
        }
        return newLength;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int[] nums1=new int[]{1,1,2,3};
        MethodExecuteTimeUtils.printRunTime(()-> {
            System.out.println(removeDuplicates(nums));
            System.out.println(Arrays.toString(nums));
        });
        MethodExecuteTimeUtils.printRunTime(()-> {
            System.out.println(removeDuplicates(nums1));
            System.out.println(Arrays.toString(nums1));
        });
    }
}
