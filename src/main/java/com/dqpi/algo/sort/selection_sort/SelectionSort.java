package com.dqpi.algo.sort.selection_sort;

import com.dqpi.algo.config.CanvasConfig;
import com.dqpi.algo.painter.Painter;
import com.dqpi.algo.vm.MainVm;
import lombok.Setter;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Mountain
 * @date 2020/10/16
 */
@Component
public class SelectionSort {
    
    @Resource
    private SelectionSortDraw draw;
    
    @Resource
    private Painter painter;
    
    @Resource
    private MainVm mainVm;
    
    @Resource
    private CanvasConfig canvasConfig;

    @Setter
    private int[] numbers;
    
    @Async
    public void selectionSort() {
        draw.setNumbers(numbers);
        
        setData(0, -1, -1);
        for (int i = 0; i < numbers.length; i++) {
            int minIndex = i;
            setData(i, -1, minIndex);
            for (int j = i + 1; j < numbers.length; j ++) {
                setData(i, j, minIndex);
                if (numbers[j] < numbers[minIndex]) {
                    minIndex = j;
                }
            }
            swap(minIndex, i);
        }
        setData(numbers.length, -1, -1);
        
        mainVm.setInitShow(true);
        mainVm.setStartShow(true);
    }
    
    private void setData(int orderIndex, int currentCompareIndex, int currentMinIndex) {
        draw.orderedIndex = orderIndex;
        draw.currentCompareIndex = currentCompareIndex;
        draw.currentMinIndex = currentMinIndex;
        painter.draw(canvasConfig.getDelay(), draw);
    }

    private void swap(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}

