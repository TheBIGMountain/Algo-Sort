package com.dqpi.algo.enums;

/**
 * @author Mountain
 * @date 2020/10/17
 */
public enum AlgoEnum {
    /**
     * 1 -- 冒泡排序
     * 2 -- 选择排序
     * 3 -- 插入排序
     * 4 -- 归并排序
     * 5 -- 快速排序
     * 6 -- 随机快排
     * 7 -- 双路排序
     * 8 -- 三路排序
     * 9 -- 堆排序
     * 10 -- 希尔排序
     * 11 -- 计数排序
     * 12 -- 基数排序
     */
    BUBBLE_SORT,
    SELECTION_SORT,
    INSERT_SORT,
    MERGE_SORT,
    QUICK_SORT,
    RANDOM_QUICK_SORT,
    TWO_WAY_QUICK_SORT,
    THREE_WAY_QUICK_SORT,
    HEAP_SORT,
    SHELL_SORT,
    COUNTING_SORT,
    RADIX_SORT,
    ;

    private static final AlgoEnum[] ALGOS = {
            BUBBLE_SORT,
            SELECTION_SORT,
            INSERT_SORT,
            MERGE_SORT,
            QUICK_SORT,
            RANDOM_QUICK_SORT,
            TWO_WAY_QUICK_SORT,
            THREE_WAY_QUICK_SORT,
            HEAP_SORT,
            SHELL_SORT,
            COUNTING_SORT,
            RADIX_SORT
    };
    
    public static AlgoEnum getAlgo(int code) {
        return ALGOS[code];
    }
}
