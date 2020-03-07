package com.ycj.airthmetic.interviewGolden;

import com.ycj.airthmetic.utils.MethodExecuteTimeUtils;

/**
 * T_10_01
 */
public class T_10_01 {

    public static void merge(int[] A, int m, int[] B, int n) {
        int index = 0;
        for (int i = 0; i < B.length; i++) { // 取出b
            boolean flag = false;
            int b = B[i];
            for (int j = index; j < m; j++) { // 取出a一个一个比较
                int a = A[j];
                if (b < a) {
                    for (int k = m + n - 2; k >= j; k--) {
                        A[k + 1] = A[k];
                    }
                    A[j] = b;
                    index = j;
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                A[m] = b;
                index = m;
            }
            m++;
            n--;
        }
        for (int i = 0; i < m + n; i++) {
            System.out.print(A[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 0, 0, 0};
        int[] B = new int[]{2, 5, 6};
        MethodExecuteTimeUtils.printRunTime(new Runnable() {
            @Override
            public void run() {
                merge(A, 3, B, 3);
            }
        });
    }
}