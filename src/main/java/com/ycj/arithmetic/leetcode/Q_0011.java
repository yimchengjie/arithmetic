package com.ycj.arithmetic.leetcode;

import com.ycj.arithmetic.utils.MethodExecuteTimeUtils;

/**
 * Q_0011.盛最多水的容器
 */
public class Q_0011 {

    public static int maxArea(int[] height) {
        int max=0;
        int left = 0,right = height.length -1;
        while (left<right) {
            int area = (right-left)*Math.min(height[left],height[right]);
            max = Math.max(area,max);
            if (height[left] > height[right]){
                right--;
            }else {
                left++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        MethodExecuteTimeUtils.printRunTime(()->{
            System.out.println(maxArea(height));
        });
    }
}
