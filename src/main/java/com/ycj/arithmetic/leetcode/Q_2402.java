package com.ycj.arithmetic.leetcode;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

/**
 * Q_2402. 会议室 III
 *
 * @author yanchengjie
 * @version : Q_6170.java, v 0.1 2022/9/4 11:18 yanchengjie Exp$
 */
public class Q_2402 {

	public static int mostBooked(int n, int[][] meetings) {
		Arrays.sort(meetings, Comparator.comparingInt(meeting -> meeting[0]));
		int[] counts = new int[meetings.length];
		Map<Integer, Long> meetingRoom = new HashMap<>(n);
		for (int i = 0; i < n; i++) {
			meetingRoom.put(i, null);
		}
		int newestRelaxRoom = 0;
		Long newestRelaxEndTime = Long.MAX_VALUE;
		for (int[] meeting : meetings) {
			long startTime = meeting[0];
			long endTime = meeting[1];
			boolean canIn = false;
			for (int i = 0; i < n; i++) {
				Long lastEndTime = meetingRoom.get(i);
				if (lastEndTime == null || lastEndTime <= startTime) {
					canIn = true;
					System.out.println(i + "号会议室排入[" + startTime + "," + endTime + "]");
					meetingRoom.put(i, endTime);
					counts[i]++;
					newestRelaxRoom = i;
					newestRelaxEndTime = endTime;
					break;
				}
			}
			if (!canIn) {
				endTime = endTime - startTime + newestRelaxEndTime;
				startTime = newestRelaxEndTime;
				newestRelaxEndTime = endTime;
				System.out.println("move" + newestRelaxRoom + "号会议室排入[" + startTime + "," + endTime + "]");
				meetingRoom.put(newestRelaxRoom, endTime);
				counts[newestRelaxRoom]++;
			}
			for (int i = 0; i < n; i++) {
				Long lastTime = meetingRoom.get(i);
				if (lastTime != null && lastTime < newestRelaxEndTime) {
					newestRelaxEndTime = lastTime;
					newestRelaxRoom = i;
				}else if (lastTime != null && lastTime.equals(newestRelaxEndTime)) {
					if (i<newestRelaxRoom) {
						newestRelaxRoom = i;
					}
				}
			}
			System.out.println("room"+newestRelaxRoom+",endTime"+newestRelaxEndTime);

		}
		int maxRoom = 0;
		int maxCount = 0;
		for (int i = 0; i < counts.length - 1; i++) {
			if (counts[i] > maxCount) {
				maxCount = counts[i];
				maxRoom = i;
			}
		}
		return maxRoom;
	}

	public static void main(String[] args) {
		int n = 2;
		int[][] meetings = {{43,44},{34,36},{11,47},{1,8},{30,33},{45,48},{23,41},{29,30}};
		Arrays.sort(meetings, Comparator.comparingInt(meeting -> meeting[0]));
		System.out.println(JSON.toJSONString(meetings));
		System.out.println(mostBooked(n, meetings));
	}
}
