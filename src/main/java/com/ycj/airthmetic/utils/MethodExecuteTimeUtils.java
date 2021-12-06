package com.ycj.airthmetic.utils;

/**
 * MethodExecuteTimeUtils
 */
public class MethodExecuteTimeUtils {

    public static long runTime(Runnable runnable){
        long startTime = System.nanoTime();
        //logger.info("开始时间"+startTime);
        Thread thread = new Thread(runnable);
        thread.run();
        long endTime = System.nanoTime();
        //logger.info("结束时间"+endTime);
        return endTime-startTime;
    }

    public static void printRunTime(Runnable runnable){
        long runtime = runTime(runnable);
        System.out.println("[Done]: "+runtime/100000.00+" ms");
    }
}