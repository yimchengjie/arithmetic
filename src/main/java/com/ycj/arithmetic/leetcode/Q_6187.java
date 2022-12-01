package com.ycj.arithmetic.leetcode;

import com.alibaba.fastjson.JSON;
import java.util.Arrays;

/**
 * Q_6187
 *
 * @author yanchengjie
 * @version : Q_6187.java, v 0.1 2022/9/17 23:49 yanchengjie Exp$
 */
public class Q_6187 {

	public long minimumMoney(int[][] transactions) {
		Arrays.sort(transactions, (o1, o2) -> (-o1[0]+o2[0]));
		System.out.println(JSON.toJSONString(transactions));
		int sum = 0;
		for (int i = 0; i < transactions.length; i++) {
			int[] transaction = transactions[i];
			sum += transaction[0];
		}
		if (transactions[transactions.length-1][0] != 0){
			sum -= transactions[transactions.length-1][1];
		}
		return sum;
	}

	public static void main(String[] args) {
		int[][] transactions = {{2,1},{5,0},{4,2}};
		System.out.println(new Q_6187().minimumMoney(transactions));
	}

}
