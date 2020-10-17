package com.dqpi.algo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Mountain
 * @date 2020/10/17
 */
@AllArgsConstructor
@Getter
public enum AlgoEnum {
    /**
     * 1 -- 选择排序
     * 2 -- 插入排序
     */
    SELECTION_SORT(1),
    INSERT_SORT(2),
    MERGE_SORT(3),
    ONE_WAY_QUICK_SORT(4),
    TWO_WAY_QUICK_SORT(5),
    THREE_WAY_QUICK_SORT(6),
    ;
    private final int code;
    
    private static final AlgoEnum[] ALGOS = { SELECTION_SORT, INSERT_SORT, MERGE_SORT };
    
    public static AlgoEnum getAlgo(int code) {
        return ALGOS[code - 1];
    }
}
