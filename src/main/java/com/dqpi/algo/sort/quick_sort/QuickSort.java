package com.dqpi.algo.sort.quick_sort;

import com.dqpi.algo.config.CanvasConfig;
import com.dqpi.algo.enums.AlgoEnum;
import com.dqpi.algo.painter.Painter;
import com.dqpi.algo.vm.MainVm;
import lombok.Setter;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Mountain
 * @date 2020/10/17
 */
@Component
public class QuickSort {
    @Resource
    private QuickSortDraw draw;

    @Resource
    private Painter painter;

    @Resource
    private MainVm mainVm;

    @Resource
    private CanvasConfig canvasConfig;

    @Setter
    private int[] numbers;
    
    @Async
    public void quickSort(AlgoEnum algoEnum) {
        
    }
}
