package com.ycj.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Q_1656.设计有序流
 */
public class Q_1656 {
    public static class OrderedStream {
        private final String[] values;
        private int index;
        public OrderedStream(int n){
            values = new String[n];
            index = 0;
        }

        public List<String> insert(int idKey, String value) {
            this.values[idKey - 1] = value;
            if (this.values[index] != null) {
                List<String> list = new ArrayList<>();
                list.add(values[index]);
                int i;
                for (i = index+1; i < values.length; i++) {
                    if (values[i]!=null) {
                        list.add(values[i]);
                    }else{
                        break;
                    }
                }
                index = i;
                return list;
            }else {
                return Collections.emptyList();
            }

        }
    }

    public static void main(String[] args) {
        OrderedStream os= new OrderedStream(5);
        System.out.println(Arrays.toString(os.insert(3, "ccccc").toArray())); // 插入 (3, "ccccc")，返回 []
        System.out.println(Arrays.toString(os.insert(1, "aaaaa").toArray())); // 插入 (1, "aaaaa")，返回 ["aaaaa"]
        System.out.println(Arrays.toString(os.insert(2, "bbbbb").toArray())); // 插入 (2, "bbbbb")，返回 ["bbbbb", "ccccc"]
        System.out.println(Arrays.toString(os.insert(5, "eeeee").toArray())); // 插入 (5, "eeeee")，返回 []
        System.out.println(Arrays.toString(os.insert(4, "ddddd").toArray())); // 插入 (4, "ddddd")，返回 ["ddddd", "eeeee"]
    }
}
