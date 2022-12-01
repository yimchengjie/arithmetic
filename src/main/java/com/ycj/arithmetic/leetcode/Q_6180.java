package com.ycj.arithmetic.leetcode;

/**
 * Q_6180
 *
 * @author yanchengjie
 * @version : Q_6180.java, v 0.1 2022/9/18 10:36 yanchengjie Exp$
 */
public class Q_6180 {

	public int smallestEvenMultiple(int n) {
		if (n%2==0){
			return n;
		}else {
			return n*2;
		}
	}

	public static void main(String[] args) {
		int n = 5;
		System.out.println(new Q_6180().smallestEvenMultiple(n));
	}

}
