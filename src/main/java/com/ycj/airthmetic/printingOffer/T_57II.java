package com.ycj.airthmetic.printingOffer;

import java.util.ArrayList;
import java.util.List;

import com.ycj.airthmetic.utils.MethodExecuteTimeUtils;

/**
 * T_57II 和为s的连续正数序列
 * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 */
public class T_57II {

    public static int[][] findContinuousSequence(int target) {
        List<int[]> list=new ArrayList<>();
        int left=1;
        // right>left
        int right=2;

        int sum=left+right;
        while (left<=target/2) {
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
        MethodExecuteTimeUtils.printRunTime(new Runnable() {
            @Override
            public void run() {
                int[][] result=findContinuousSequence(9);
                System.out.print("[");
                for (int i = 0; i < result.length; i++) {
                    System.out.print("[");
                    for (int j = 0; j < result[i].length; j++) {
                        if (j!=result[i].length-1) {
                            System.out.print(result[i][j]+",");
                        }else{
                            System.out.print(result[i][j]);
                        }
                    }
                    System.out.print("]");
                }
                System.out.println("]");
            }
        });
    }
}