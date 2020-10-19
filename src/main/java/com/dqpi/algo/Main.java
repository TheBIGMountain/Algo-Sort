package com.dqpi.algo;

/**
 * @author Mountain
 * @date 2020/10/19
 */
public class Main {
    /**
     * 基数排序
     */
    private static void radixSort(int[] numbers) {
        // 创建10个桶存放待排序元素
        int[][] buckets = new int[10][numbers.length];
        // 记录每个桶中元素个数
        int[] count = new int[10];
        // 待排序数组的最高位
        int l = 3;
        for (int i = 0; i < l; i ++) {
            int pow = (int) Math.pow(10, i);
            // 放入桶中
            for (int value : numbers) {
                int digit = value / pow % 10;
                buckets[digit][count[digit]] = value;
                count[digit]++;
            }

            // 取出桶中元素，放回原数组
            int index = 0;
            for (int k = 0; k < buckets.length; k ++) {
                int j = 0;
                while (count[k] != 0) {
                    numbers[index] = buckets[k][j];
                    j ++;
                    count[k] --;
                    index ++;
                }
            }
        }
    }
}
