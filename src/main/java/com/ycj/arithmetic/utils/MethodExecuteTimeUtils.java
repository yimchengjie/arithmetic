package com.ycj.arithmetic.utils;

/**
 * MethodExecuteTimeUtils
 * @author yanchengjie
 */
public class MethodExecuteTimeUtils {

    public static long runTime(Runnable runnable){
        long startTime = System.nanoTime();
        runnable.run();
        long endTime = System.nanoTime();
        return endTime-startTime;
    }

    public static void printRunTime(Runnable runnable){
        long runtime = runTime(runnable);
        System.out.println("[Done]: "+runtime/100000.00+" ms");
    }
}