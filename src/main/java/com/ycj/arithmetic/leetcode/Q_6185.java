package com.ycj.arithmetic.leetcode;

import java.util.Arrays;

/**
 * Q_6185.运动员和训练师的最大匹配数
 *
 * @author yanchengjie
 * @version : Q_6185.java, v 0.1 2022/9/17 22:57 yanchengjie Exp$
 */
public class Q_6185 {

	public int matchPlayersAndTrainers(int[] players, int[] trainers) {
		if (players == null || players.length == 0){
			return 0;
		}
		if (trainers == null || trainers.length == 0){
			return 0;
		}
		Arrays.sort(players);
		Arrays.sort(trainers);
		int matchCount = 0;
		int loopCount = Math.min(players.length, trainers.length);
		int playerIndex = 0;
		int trainerIndex = 0;
		for (int i = 0; i < loopCount && trainerIndex < trainers.length; i++) {
			int player = players[playerIndex];
			while (trainerIndex < trainers.length) {
				int trainer = trainers[trainerIndex];
				trainerIndex++;
				if (player<=trainer) {
					matchCount++;
					playerIndex++;
					System.out.println("player"+player+",trainer"+trainer);
					break;
				}
			}
		}
		return matchCount;
	}

	public static void main(String[] args) {
		int[] players = {10,10,10,100,10}, trainers = {10,10,10};
		System.out.println(new Q_6185().matchPlayersAndTrainers(players, trainers));
	}
}
