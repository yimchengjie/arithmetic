package com.ycj.arithmetic.leetcode;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.List;

/**
 * Q_6170
 *
 * @author yanchengjie
 * @version : Q_6170.java, v 0.1 2022/9/4 11:18 yanchengjie Exp$
 */
public class Q_6170 {

	public static int mostBooked(int n, int[][] meetings) {
		List<List<int[]>> list = new ArrayList<>(n);
		int max = 0;
		int maxRoom = 0;
		int minEndTime = Integer.MAX_VALUE;
		for (int i = 0; i < meetings.length; i++) {
			int[] meeting = meetings[i];
			int start = meeting[0];
			int end = meeting[1];
			minEndTime = Math.min(minEndTime,end);
			int index = 0;
			boolean hasDone = false;
			while (true) {
				for (int j = 0; j < n; j++) {
					if (list.size() <= j || list.get(j) == null || list.get(j).size() == 0) {
						List<int[]> hasMeetings = new ArrayList<>();
						hasMeetings.add(meeting);
						list.add(hasMeetings);
						hasDone = true;
						break;
					} else {
						List<int[]> hasMeetings = list.get(j);
						boolean hasConflict = hasConflict(hasMeetings, start, end);
						if (!hasConflict) {
							hasMeetings.add(meeting);
							if (hasMeetings.size() > max){
								max = hasMeetings.size();
								maxRoom = index;
							}
							hasDone = false;
							break;
						}else {
							hasDone = true;
						}
					}
					index++;
				}
				if (hasDone) {
					break;
				}
				start = minEndTime;
				end = minEndTime+end-start;
			}
		}
		System.out.println(JSON.toJSONString(list));
		return maxRoom;
	}

	private static boolean hasConflict(List<int[]> hasMeetings, int start, int end) {
		for (int[] hasMeeting : hasMeetings) {
			if (hasMeeting[0] <= start || hasMeeting[1] > end) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int n = 3;
		int[][] meetings = {{1,20},{2,10},{3,5},{4,9},{6,8}};
		System.out.println(mostBooked(n, meetings));
	}
}
