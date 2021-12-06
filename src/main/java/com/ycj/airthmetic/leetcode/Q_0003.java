package com.ycj.airthmetic.leetcode;

import com.ycj.airthmetic.utils.MethodExecuteTimeUtils;
import java.util.HashSet;
import java.util.Set;

/**
 * Q_0003
 *
 * @author yanchengjie
 * @version $Id: Q_0003.java, v 0.1 2021/12/6 21:10 yanchengjie Exp$
 */
public class Q_0003 {

    public static void main(String[] args) {
        MethodExecuteTimeUtils.printRunTime(()->lengthOfLongestSubstring("abcabcdb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        Set<Character> children = new HashSet<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            children.add(chars[i]);
            for (int j = i + 1; j < chars.length; j++) {
                if (!children.contains(chars[j])){
                    children.add(chars[j]);
                    max = max > j - i + 1 ? max : j - i + 1;
                }else{
                    break;
                }
            }
        }
        System.out.println(max);
        return max;
    }

}
