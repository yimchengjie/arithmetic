package com.ycj.arithmetic.interviewgolden;

import com.ycj.arithmetic.utils.MethodExecuteTimeUtils;

/**
 * T_10_01
 * @author yanchengjie
 */
public class T_10_01 {

    public static void merge(int[] aArr, int m, int[] bArr, int n) {
        int index = 0;
        for (int value : bArr) {
            // 取出b
            boolean flag = false;
            for (int j = index; j < m; j++) {
                // 取出a一个一个比较
                int a = aArr[j];
                if (value < a) {
                    if (m + n - 1 - j >= 0) {
                        System.arraycopy(aArr, j, aArr, j + 1, m + n - 1 - j);
                    }
                    aArr[j] = value;
                    index = j;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                aArr[m] = value;
                index = m;
            }
            m++;
            n--;
        }
        for (int i = 0; i < m + n; i++) {
            System.out.print(aArr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] aArr = new int[]{1, 2, 3, 0, 0, 0};
        int[] bArr = new int[]{2, 5, 6};
        MethodExecuteTimeUtils.printRunTime(() -> merge(aArr, 3, bArr, 3));
    }
}