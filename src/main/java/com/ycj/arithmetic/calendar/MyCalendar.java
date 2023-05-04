package com.ycj.arithmetic.calendar;

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
            "/home/yanchengjie/ycjCoding/arithmetic/src/main/resources/pic/sun.png",
            "/home/yanchengjie/ycjCoding/arithmetic/src/main/resources/pic/mon.png",
            "/home/yanchengjie/ycjCoding/arithmetic/src/main/resources/pic/tue.png",
            "/home/yanchengjie/ycjCoding/arithmetic/src/main/resources/pic/wed.png",
            "/home/yanchengjie/ycjCoding/arithmetic/src/main/resources/pic/thu.png",
            "/home/yanchengjie/ycjCoding/arithmetic/src/main/resources/pic/fri.png",
            "/home/yanchengjie/ycjCoding/arithmetic/src/main/resources/pic/sat.png",
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
        BufferedImage headerImg = ImageUtil.readFromPath(header[0]);
        for (int i = 1; i < header.length; i++) {
            headerImg = ImageUtil.hengxiang(headerImg, ImageUtil.readFromPath(header[i]));
        }
        dayOfWeek = dayOfWeek == 0 ? 7 : dayOfWeek;
        //获取指定月份前面的空格数
        int space = dayOfWeek - 1;
        int count = 0;
        BufferedImage blank = null;
        if (space > 0) {
            blank = ImageUtil.readFromPath("/home/yanchengjie/ycjCoding/arithmetic/src/main/resources/pic/blank.png");
            for (int i = 1; i < space; i++) {
                blank = ImageUtil.hengxiang(blank, ImageUtil.readFromPath(
                        "/home/yanchengjie/ycjCoding/arithmetic/src/main/resources/pic/blank.png"));
            }
        }
        List<BufferedImage> shuxiang = new ArrayList<>();
        BufferedImage oneWeek = null;
        for (int i = 1; i <= dayOfMonth; i++) {
            BufferedImage aday = ImageUtil.readFromPath(
                    "/home/yanchengjie/ycjCoding/arithmetic/src/main/resources/pic/days/" + 5 + ".png");
            if (i == day) {
                aday = ImageUtil.overMerge(aday, ImageUtil.readFromPath(
                        "/home/yanchengjie/ycjCoding/arithmetic/src/main/resources/pic/select.png"));
            }
            count++;
            //判断是不是当前系统的日期时间
            if (Objects.nonNull(blank)) {
                oneWeek = ImageUtil.hengxiang(blank, aday);
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
                    ImageUtil.readFromPath("/home/yanchengjie/ycjCoding/arithmetic/src/main/resources/pic/water.png",
                            image.getWidth(), image.getHeight()));

        } else {
            return image;
        }
    }


    public static void main(String[] args) {
        BufferedImage image = generateCalendar(2023, 5, 6, false);
        ImageUtil.writeOut(image, "/home/yanchengjie/ycjCoding/arithmetic/src/main/resources/pic/out/1.png");
    }

}
