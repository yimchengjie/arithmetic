package com.ycj.airthmetic.utils;

import java.util.concurrent.ExecutorService;
import java.util.logging.Logger;

import ch.qos.logback.core.util.ExecutorServiceUtil;

/**
 * MethodExecuteTimeUtils
 */
public class MethodExecuteTimeUtils {

    public static ExecutorService executor = ExecutorServiceUtil.newExecutorService();

    public static Logger logger = Logger.getLogger(String.valueOf(MethodExecuteTimeUtils.class));
    
    public static long runTime(Runnable runnable){
        long startTime = System.nanoTime();
        //logger.info("开始时间"+startTime);
        executor.execute(runnable);
        long endTime = System.nanoTime();
        //logger.info("结束时间"+endTime);
        return endTime-startTime;
    }

    public static void printRunTime(Runnable runnable){
        long runtime = runTime(runnable);
        System.out.println("[Done]: "+runtime/100000.00+" ms");
    }
}