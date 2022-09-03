package com.ycj.arithmetic.leetcode;

/**
 * Q_6172
 *
 * @author yanchengjie
 * @version : Q_6172.java, v 0.1 2022/9/3 22:43 yanchengjie Exp$
 */
public class Q_6172 {


	public static boolean isStrictlyPalindromic(int n) {
		for (int i = 2; i < n-1; i++) {
			String string = Integer.toString(n, i);
			System.out.println( string);
			char[] chars = string.toCharArray();
			for (int i1 = 0; i1 < chars.length/2; i1++) {
				if (chars[i1] != chars[chars.length-1-i1]) {
					return false;
				}
			}
		}
		return true;
	}


	public static void main(String[] args) {
		int n =4;
		System.out.println(isStrictlyPalindromic(n));
	}

}
