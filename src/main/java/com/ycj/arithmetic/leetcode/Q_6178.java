package com.ycj.arithmetic.leetcode;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Q_6178
 *
 * @author yanchengjie
 * @version : Q_6178.java, v 0.1 2022/9/11 11:07 yanchengjie Exp$
 */
public class Q_6178 {

	public static int minGroups(int[][] intervals) {
		Arrays.parallelSort(intervals, Comparator.comparingInt(o -> o[0]));
		List<List<int[]>> list = new ArrayList<>();
		for (int[] interval : intervals) {
			boolean can = false;
			int start = interval[0];
			int end = interval[1];
			if (list.size() > 0) {
				for (List<int[]> group : list) {
					boolean conflict = false;
					if (group.size() > 0) {
						for (int[] ints : group) {
							if (!(end < ints[0] || start > ints[1])) {
								conflict = true;
								break;
							}
						}
						if (!conflict) {
							group.add(interval);
							can = true;
							break;
						}
					}
				}
			}
			if (!can) {
				List<int[]> arrayList = new ArrayList<>();
				arrayList.add(interval);
				list.add(arrayList);
			}

		}
		return list.size();
	}

	public static void main(String[] args) {
		int[][] intervals = {{229966,812955},{308778,948377},{893612,952735},{395781,574123},{478514,875165},{766513,953839},{460683,491583},{133951,212694},{376149,838265},{541380,686845},{461394,568742},{804546,904032},{422466,467909},{557048,758709},{680460,899053},{110928,267321},{470258,650065},{534607,921875},{292993,994721},{645020,692560},{898840,947977},{33584,330630},{903142,970252},{17375,626775},{804313,972796},{582079,757160},{785002,987823},{599263,997719},{486500,527956},{566481,813653},{211239,863969},{808577,883125},{21880,516436},{264747,412144},{327175,772333},{984807,988224},{758172,916673},{23583,406006},{954674,956043},{379202,544291},{688869,785368},{841735,983869},{99836,916620},{332504,740696},{740840,793924},{896607,920924},{868540,922727},{125849,550941},{433284,685766}};
		System.out.println(minGroups(intervals));
	}

}
