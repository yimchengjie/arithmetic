package com.ycj.arithmetic.leetcode;

import com.alibaba.fastjson.JSON;
import com.ycj.arithmetic.utils.MethodExecuteTimeUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Q_1282
 *
 * @author yanchengjie
 * @version : Q_1282.java, v 0.1 2022/8/12 21:09 yanchengjie Exp$
 */
public class Q_1282 {
	public static List<List<Integer>> groupThePeople(int[] groupSizes) {
		if(groupSizes == null) {
			return Collections.emptyList();
		}
		Map<Integer,List<Integer>> map = new HashMap<>();
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < groupSizes.length; i++) {
			int size = groupSizes[i];
			List<Integer> sizeList = map.getOrDefault(size, new ArrayList<>());
			if (size == 1){
				list.add(Collections.singletonList(i));
				continue;
			}
			if (sizeList.size() == size) {
				list.add(sizeList);
				map.remove(size);
			}else {
				sizeList.add(i);
				map.put(size,sizeList);
				if (sizeList.size() == size) {
					list.add(sizeList);
					map.remove(size);
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		int[] groupSizes = new int[]{3,3,3,3,3,1,3};
		MethodExecuteTimeUtils.printRunTime(()->{
			System.out.println(JSON.toJSONString(groupThePeople(groupSizes)));
		});
	}

}
