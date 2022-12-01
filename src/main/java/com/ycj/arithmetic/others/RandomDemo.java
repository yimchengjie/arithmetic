package com.ycj.arithmetic.others;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/**
 * RandonDemo
 *
 * @author yanchengjie
 * @version RandonDemo.java, 2022/12/1 19:54 yanchengjie
 */
public class RandomDemo {

	private static final Map<Integer, int[]> RAN = new HashMap<Integer, int[]>(){{
		put(1, new int[]{1,10});
		put(2, new int[]{11,100});
		put(3, new int[]{101,1000});
		put(4, new int[]{1001, 4000});
	}};

	private static final Map<Integer, String> RESULT = new HashMap<Integer, String>(){{
		put(1, "一等奖");
		put(2, "二等奖");
		put(3, "三等奖");
		put(4, "谢谢惠顾");
	}};

	public static void main(String[] args) throws IOException {
		Scanner in=new Scanner(System.in);

		for (;;) {
			System.out.print("继续请按1: ");
			String accept=in.next();
			if (Integer.parseInt(accept) != 1) {
				break;
			}
			int random = (int) (Math.random() * 4000 + 1);
			//System.out.println("随机数: "+random);
			int level = getLevel(random);
			System.out.println("结果: "+RESULT.get(level));
		}
	}

	private static int getLevel(int random) {
		Set<Entry<Integer, int[]>> entries = RAN.entrySet();
		for (Entry<Integer, int[]> entry : entries) {
			int[] value = entry.getValue();
			if (random >=value[0] && random <=value[1]) {
				return entry.getKey();
			}
		}
		return 4;
	}
}
