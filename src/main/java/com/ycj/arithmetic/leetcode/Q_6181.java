package com.ycj.arithmetic.leetcode;

/**
 * Q_6181
 *
 * @author yanchengjie
 * @version : Q_6181.java, v 0.1 2022/9/18 10:39 yanchengjie Exp$
 */
public class Q_6181 {

	public int longestContinuousSubstring(String s) {
		char[] chars = s.toCharArray();
		int left=0; int right = 1;
		int max = 1;
		while (right<chars.length){
			if (chars[right] - chars[right-1] == 1) {
				max = Math.max(right-left+1 , max);
			}else{
				left = right;
			}
			right++;

		}
		return max;
	}

	public static void main(String[] args) {
		String s = "abcde";
		System.out.println(new Q_6181().longestContinuousSubstring(s));
	}

}
