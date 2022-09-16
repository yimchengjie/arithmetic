package com.ycj.arithmetic.leetcode;

/**
 * Q_2399. 检查相同字母间的距离
 *
 * @author yanchengjie
 * @version : Q_6167.java, v 0.1 2022/9/4 10:34 yanchengjie Exp$
 */
public class Q_2399 {
	public static boolean checkDistances(String s, int[] distance) {
		char[] chars = s.toCharArray();
		for (int i = 0; i < distance.length; i++) {
			int dis = distance[i];
			char j = (char) ('a'+i);
			Integer start = null;
			for (int i1 = 0; i1 < chars.length; i1++) {
				if (chars[i1] == j && start == null){
					start = i1;
				}else if (chars[i1] == j && start != null){
					if (i1-start-1 != dis) {
						return false;
					}
					break;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {

		String s = "abaccb";
		int[] distance = {1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		System.out.println(checkDistances(s, distance));
	}

}
