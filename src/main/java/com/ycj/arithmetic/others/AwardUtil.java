package com.ycj.arithmetic.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 抽奖程序帮助类
 * @author FlyerZuo
 *
 */
public class AwardUtil {
	
	private static int getRandomNumberInRange(int max) {
		int min = 1;
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}
 
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
	
	private static Map<String,Record> lottery(Map<Integer,Record> map,int totalSize,int awardSize)
	{
		Map<String,Record> result = new HashMap<String, Record>();
		for(int i = 0;i<awardSize; i++) {
			int value = getRandomNumberInRange(totalSize);
			Record record = map.get(value);
			if(result.get(record.getOpenId()) == null)
			{
				//抽中
				result.put(record.getOpenId(), record);
			}
			else
			{
				i--;
			}
		}
		return result;
	}
	
	/**
	 * 抽奖调用函数入口
	 * @param records 所有参与抽奖的记录
	 * @param totalSize 权重分母
	 * @param awardSize 奖品数量
	 * @return
	 */
	public static Map<String,Record> lottery(List<Record> records,int totalSize,int awardSize)
	{
		Map<Integer,Record> map = new HashMap<Integer,Record>();
		int min = 1;
		int max = 0;
		for (Record record : records) {
			min = max + record.getMax() + 1;
			max += record.getMax() + record.getRate();
			for(int i = min;i<=max;i++)
			{
				map.put(i, new Record(record.getAwardCode(), record.getOpenId(), record.getRate(), min, max));
			}
		}
		
		return lottery(map,totalSize,awardSize);
	}

	/**
	 * 示例调用方法
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Record> list = new ArrayList<Record>();
		list.add(new Record("test","openid001",12));
		list.add(new Record("test", "openid002", 12));
		list.add(new Record("test", "openid003", 5));
		list.add(new Record("test", "openid004", 1));
		list.add(new Record("test", "openid005", 1));
		
		//31为以上抽奖重量的和，即 12 + 12 + 5 + 1 + 1
		Map<String,Record> result = lottery(list, 31, 2);
		//结果即为抽奖返回结果
		Iterator<String> it = result.keySet().iterator();
		while(it.hasNext())
		{
			System.out.println(result.get(it.next()));
		}
	}
}
