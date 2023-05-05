package com.ycj.arithmetic.utils;

import static java.awt.Image.SCALE_SMOOTH;

import cn.hutool.core.img.ImgUtil;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.imageio.ImageIO;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.filters.Watermark;
import net.coobird.thumbnailator.geometry.Positions;

public class ImageUtil {

    public static BufferedImage readFromPath(String path){
        BufferedImage img = ImgUtil.read(path);
        img = ImgUtil.toBufferedImage(ImgUtil.scale(img,256,160));
        BufferedImage bufImg = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = bufImg.createGraphics();
        bufImg = graphics.getDeviceConfiguration()
                .createCompatibleImage(img.getWidth(), img.getHeight(), Transparency.TRANSLUCENT);
        graphics = bufImg.createGraphics();
        graphics.drawImage(img, 0, 0, null);
        return bufImg;
    }

    public static BufferedImage readFromPath(String path, int width, int height){
        BufferedImage read;
        read = ImgUtil.read(path);
        return ImgUtil.toBufferedImage(read.getScaledInstance(width, height, SCALE_SMOOTH));
    }

    public static BufferedImage hengxiang(BufferedImage pre, BufferedImage next) {
        return mergeBufferedImage(pre, next, 0);
    }

    public static BufferedImage shuxiang(BufferedImage pre, BufferedImage next) {
        return mergeBufferedImage(pre, next, 1);
    }

    private static BufferedImage mergeBufferedImage(BufferedImage pre, BufferedImage next, int type) {
        int[] preRgb = getRgb(pre);
        int[] nextRgb = getRgb(next);
        int dstHeight, dstWidth;
        if (type == 0) {
            dstHeight = pre.getHeight();
            dstWidth = pre.getWidth()+next.getWidth();
        }else {
            dstWidth = pre.getWidth();
            dstHeight = pre.getHeight()+ next.getHeight();
        }
        BufferedImage imageNew = new BufferedImage(dstWidth, dstHeight, BufferedImage.TYPE_INT_RGB);
        imageNew.setRGB(0, 0, pre.getWidth(), pre.getHeight(), preRgb, 0, pre.getWidth());
        if (type == 0) {
            imageNew.setRGB(pre.getWidth(), 0, next.getWidth(), next.getHeight(), nextRgb, 0, next.getWidth());
        }else {
            imageNew.setRGB(0, pre.getHeight(), next.getWidth(), next.getHeight(), nextRgb, 0, next.getWidth());
        }
        return imageNew;
    }

    public static BufferedImage watermarking(BufferedImage origin, BufferedImage water) {
        try {
            return Thumbnails.of(origin)
                    .size(origin.getWidth(), origin.getHeight()) // 大小
                    .watermark(Positions.CENTER, water, 0.3f)// 0.5f表示透明度，最大值为1
                    .outputQuality(1)   // 图片质量，最大值为1
                    .asBufferedImage();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static BufferedImage overMerge(BufferedImage back, BufferedImage font){
        //通过底图创建画笔
        BufferedImage image = new BufferedImage(back.getWidth(),back.getHeight(),BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = image.getGraphics();
        //在底图上画第一张图
        graphics.drawImage(back,0,0,null);
        //在底图上画第二张图
        graphics.drawImage(font,0,0,null);
        return image;
    }

    private static int[] getRgb(BufferedImage bufferedImage){
        return bufferedImage.getRGB(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), new int[bufferedImage.getWidth() * bufferedImage.getHeight()], 0,
                bufferedImage.getWidth());
    }

    public static void writeOut(BufferedImage bufferedImage, String dest) {
        File outFile = new File(dest);
        // 写图片，输出到硬盘
        try {
            ImageIO.write(bufferedImage, "png", outFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
