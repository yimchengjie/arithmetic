package com.ycj.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Q_6183
 *
 * @author yanchengjie
 * @version : Q_6183.java, v 0.1 2022/9/18 11:29 yanchengjie Exp$
 */
public class Q_6183 {

	public int[] sumPrefixScores(String[] words) {
		int size = 0;
		for (String word : words) {
			size+=word.length();
		}
		Map<String, Integer> prefixMap = new HashMap<>(size);
		int[] counts = new int[words.length];
		for (String word : words) {
			for (int i = 1; i <= word.length(); i++) {
				String prefixString = word.substring( 0, i);
				Integer count = prefixMap.get(prefixString);
				if (count == null) {
					count = 0;
					for (String s : words) {
						if (s.length()<i) {
							continue;
						}
						String substring = s.substring(0, i);
						if (substring.equals(prefixString)) {
							count++;
						}
					}
					if (count == 1) {
						break;
					}
					prefixMap.put(prefixString, count);
				}
			}
		}
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			int prefixCount = 0;
			for (int j = 1; j <= word.length(); j++) {
				String prefixString = word.substring(0, j);
				Integer conPrefixCount = prefixMap.get(prefixString);
				if (conPrefixCount == null) {
					prefixCount+= word.length() - j +1;
					break;
				}
				prefixCount+=conPrefixCount;
			}
			counts[i] = prefixCount;
		}
		return counts;
	}

	public static void main(String[] args) {
		String[] words = {"gwhbctqi","znrfyqrfxq","znrfyqrkiz","gwhvkdcl","znrfyqrflu","gwhvkdvwua","peqcsygcod","znrfcwkqzg","uihxxdegpb","prevxepmd"};
		System.out.println(Arrays.toString(new Q_6183().sumPrefixScores(words)));
	}

}
