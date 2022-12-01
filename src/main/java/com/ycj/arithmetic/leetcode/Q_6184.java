package com.ycj.arithmetic.leetcode;

/**
 * 6184. 统计共同度过的日子数
 *
 * @author yanchengjie
 * @version : Q_6184.java, v 0.1 2022/9/17 22:33 yanchengjie Exp$
 */
public class Q_6184 {

	static int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};


	public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {

		int aliceStart = countDay(arriveAlice);
		int aliceEnd = countDay(leaveAlice);
		int bobStart = countDay(arriveBob);
		int bobEnd = countDay(leaveBob);

		if (aliceStart < bobStart) {
			// alice先来
			if (aliceEnd < bobStart) {
				return 0;
			}
			if (aliceEnd > bobStart && aliceEnd < bobEnd) {
				return aliceEnd - bobStart + 1;
			}
			if (aliceEnd > bobStart && aliceEnd > bobEnd) {
				return bobEnd - bobStart + 1;
			}

		} else if (aliceStart > bobStart){
			// bob先来
			if (bobEnd < aliceStart) {
				return 0;
			}

			if (bobEnd > aliceStart && bobEnd < aliceEnd) {
				return bobEnd - aliceStart + 1;
			}

			if (bobEnd > aliceStart && bobEnd > aliceEnd) {
				return aliceEnd - aliceStart + 1;
			}
		}else {
			// 一起来
			int leaveDay = Math.min(aliceEnd,bobEnd);
			return leaveDay - aliceStart +1;
		}
		return 0;
	}

	private int countDay(String mmDD) {
		String[] mmDDs = mmDD.split("-");
		int mon = Integer.parseInt(mmDDs[0]);
		int day = Integer.parseInt(mmDDs[1]);
		int days = 0;
		for (int i = 1; i < mon; i++) {
			System.out.println("第" + i + "月," + months[i - 1] + "天");
			days += months[i - 1];
		}
		days += day;
		System.out.println("第" + mon + "月" + day + "天");
		System.out.println(days);
		return days;
	}

	public static void main(String[] args) {
		String arriveAlice = "01-01", leaveAlice = "12-31", arriveBob = "01-01", leaveBob = "12-31";
		System.out.println(new Q_6184().countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob));
	}

}
