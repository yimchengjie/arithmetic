package com.ycj.arithmetic.calendar;

import cn.hutool.core.io.resource.ResourceUtil;
import com.ycj.arithmetic.utils.ImageUtil;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyCalendar {

	private static Integer year;

	private static Integer month;

	private static Integer day;

	private static String[] header = new String[]{
			"pic/week0.png",
			"pic/week1.png",
			"pic/week2.png",
			"pic/week3.png",
			"pic/week4.png",
			"pic/week5.png",
			"pic/week6.png",
	};

	public static BufferedImage generateCalendar(int y, int m, int day, boolean water) {
		//获取当前系统时间
		Calendar c = Calendar.getInstance();
		//设置指定的日期
		c.set(Calendar.YEAR, y);
		c.set(Calendar.MONTH, m - 1);
		c.set(Calendar.DAY_OF_MONTH, 1);
		//获取指定月份的总天数
		int dayOfMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		//获取指定月份第一天的星期
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
		//显示

		BufferedImage headerImg = ImageUtil.readFromPath(ResourceUtil.getResource(header[0]).getPath());
		for (int i = 1; i < header.length; i++) {
			headerImg = ImageUtil.hengxiang(headerImg, ImageUtil.readFromPath(ResourceUtil.getResource(header[i]).getPath()));
		}
		dayOfWeek = dayOfWeek == 0 ? 7 : dayOfWeek;
		//获取指定月份前面的空格数
		int space = dayOfWeek - 1;
		int count = 0;
		BufferedImage blank = null;
		if (space > 0) {
			blank = ImageUtil.readFromPath(ResourceUtil.getResource("pic/blank.png").getPath());
			for (int i = 1; i < space; i++) {
				blank = ImageUtil.hengxiang(blank, ImageUtil.readFromPath(
						ResourceUtil.getResource("pic/blank.png").getPath()));
			}
			count = space;
		}
		List<BufferedImage> shuxiang = new ArrayList<>();
		BufferedImage oneWeek = null;
		for (int i = 1; i <= dayOfMonth; i++) {
			BufferedImage aday = ImageUtil.readFromPath(
					ResourceUtil.getResource("pic/days/" + i + ".png").getPath());
			if (i == day) {
				aday = ImageUtil.overMerge(aday, ImageUtil.readFromPath(
						ResourceUtil.getResource("pic/select.png").getPath()));
			}
			count++;
			//判断是不是当前系统的日期时间
			if (Objects.nonNull(blank)) {
				if (Objects.isNull(oneWeek) && i == 1) {
					oneWeek = ImageUtil.hengxiang(blank, aday);
				}else {
					oneWeek = ImageUtil.hengxiang(oneWeek, aday);
				}
			} else {
				if (Objects.isNull(oneWeek)) {
					oneWeek = aday;
				} else {
					oneWeek = ImageUtil.hengxiang(oneWeek, aday);
				}
			}
			if (count % 7 == 0) {
				shuxiang.add(oneWeek);
				oneWeek = null;
				count = 0;
			}
			if (i == dayOfMonth) {
				shuxiang.add(oneWeek);
			}
		}
		BufferedImage image = ImageUtil.shuxiang(headerImg, shuxiang.get(0));

		for (int i = 1; i < shuxiang.size(); i++) {
			image = ImageUtil.shuxiang(image, shuxiang.get(i));
		}
		if (water) {
			return ImageUtil.watermarking(image,
					ImageUtil.readFromPath(ResourceUtil.getResource("pic/water.png").getPath(),
							image.getWidth(), image.getHeight()));

		} else {
			return image;
		}
	}


	public static void main(String[] args) {
		int year = 2023;
		int month = 5;
		int day = 0;
		BufferedImage image = generateCalendar(year, month, day, false);
		ImageUtil.writeOut(image, "E:\\ycjCoding\\arithmetic\\src\\main\\resources\\pic\\out\\"+String.format("%s-%s-%s",year, month, day)+".png");
	}

}
