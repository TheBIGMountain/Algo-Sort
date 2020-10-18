package com.dqpi.algo.enums;

/**
 * @author Mountain
 * @date 2020/10/18
 */
public enum SortStatusEnum {
    /**
     * 1 -- 普通乱序
     * 2 -- 近乎有序
     * 3 -- 元素相等
     */
    CHAOS_ORDER,
    ALMOST_ORDER,
    EQUAL_ORDER
    ;

    private static final SortStatusEnum[] SORT_STATUES = {
            CHAOS_ORDER,
            ALMOST_ORDER,
            EQUAL_ORDER
    };

    public static SortStatusEnum getAlgo(int code) {
        return SORT_STATUES[code];
    }
}
