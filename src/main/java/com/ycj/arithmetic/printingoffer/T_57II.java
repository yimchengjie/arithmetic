package com.ycj.arithmetic.printingoffer;

import java.util.ArrayList;
import java.util.List;

import com.ycj.arithmetic.utils.MethodExecuteTimeUtils;

/**
 * T_57II 和为s的连续正数序列
 * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 * @author yanchengjie
 */
public class T_57II {

    public static int[][] findContinuousSequence(int target) {
        List<int[]> list=new ArrayList<>();
        int left=1;
        // right>left
        int two = 2;
        int right= two;

        int sum=left+right;
        while (left<=target/ two) {
            if (sum<target) {
                right++;
                sum+=right;
            }else if (sum>target) {
                sum-=right;
                right--;
                sum-=left;
                left++;
            }else{
                int[] arr=new int[right-left+1];
                for (int i = left; i <= right; i++) {
                    arr[i-left]=i;
                }
                list.add(arr);
                left++;
                right=left+1;
                sum=left+right;
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        MethodExecuteTimeUtils.printRunTime(() -> {
            int[][] result=findContinuousSequence(9);
            System.out.print("[");
            for (int[] ints : result) {
                System.out.print("[");
                for (int j = 0; j < ints.length; j++) {
                    if (j != ints.length - 1) {
                        System.out.print(ints[j] + ",");
                    } else {
                        System.out.print(ints[j]);
                    }
                }
                System.out.print("]");
            }
            System.out.println("]");
        });
    }
}