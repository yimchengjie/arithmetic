package com.ycj.arithmetic.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import com.ycj.arithmetic.utils.MethodExecuteTimeUtils;

/**
 * Q_0994 腐烂的橘子 
 * https://leetcode-cn.com/problems/rotting-oranges/
 * @author yanchengjie
 */
public class Q_0994 {

    public static int orangesRotting(int[][] grid) {
        int xSize = grid.length;
        int ySize = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] { i, j });
                }
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        if (count == 0) {
            return 0;
        }
        int result = 0;
        while (count > 0 && !queue.isEmpty()) {
            result++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] bad = queue.poll();
                assert bad != null;
                int x = bad[0];
                int y = bad[1];
                if (x > 0 && grid[x - 1][y] == 1) {
                    count--;
                    grid[x - 1][y] = 2;
                    queue.add(new int[] { x - 1, y });
                }
                if (x < xSize-1 && grid[x + 1][y] == 1) {
                    count--;
                    grid[x + 1][y] = 2;
                    queue.add(new int[] { x + 1, y });
                }
                if (y > 0 && grid[x][y - 1] == 1) {
                    count--;
                    grid[x][y - 1] = 2;
                    queue.add(new int[] { x, y - 1 });
                }
                if (y < ySize-1 && grid[x][y + 1] == 1) {
                    count--;
                    grid[x][y + 1] = 2;
                    queue.add(new int[] { x , y + 1 });
                }
            }
        }
        if (count > 0) {
            return -1;
        } else {
            return result;
        }
    }

    public static void main(String[] args) {
        int[][] test = new int[][] { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        MethodExecuteTimeUtils.printRunTime(() -> System.out.println(orangesRotting(test)));
    }
}