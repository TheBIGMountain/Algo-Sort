package com.dqpi.algo.sort.shell_sort;

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
public class ShellSort {
    @Resource
    private ShellSortDraw draw;
    
    @Resource
    private Painter painter;
    
    @Resource
    private MainVm mainVm;
    
    @Setter
    private int[] numbers;

    @Async
    public void shellSort() {
        draw.setNumbers(numbers);
        painter.draw(draw);
        
        for (int gap = numbers.length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < numbers.length; i ++) {
                int j = i;
                int temp = numbers[j];
                if (numbers[j] < numbers[j - gap]) {
                    while (j - gap >= 0 && temp < numbers[j - gap]) {
                        numbers[j] = numbers[j - gap];
                        j = j - gap;
                    }
                    numbers[j] = temp;
                }
            }   
        }
            
        mainVm.setInitShow(true);
        mainVm.setStartShow(true);
    }
    
    private void swap(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
    
    private void setData(int orderIndex, int currentIndex, int currentCompareIndex) {
        draw.orderIndex = orderIndex;
        draw.currentIndex = currentIndex;
        draw.currentCompareIndex = currentCompareIndex;
        painter.rest();
    }
}
