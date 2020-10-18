package com.dqpi.algo.sort.bubble_sort;

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
public class BubbleSort {
    @Resource
    private BubbleSortDraw draw;
    
    @Resource
    private Painter painter;
    
    @Resource
    private MainVm mainVm;
    
    @Setter
    private int[] numbers;

    @Async
    public void bubbleSort() {
        draw.setNumbers(numbers);
        painter.draw(draw);
        
        setData(numbers.length, -1, -1);
        for (int i = 0, k = numbers.length; i < k; k --) {
            setData(k, -1, i);
            for (int j = i + 1; j < k; j ++) {
                if (numbers[j] < numbers[j - 1]) {
                    setData(k - i, j, j - 1);
                    swap(j, j - 1);
                    continue;
                }
                setData(k - i, j, j - 1);
            }
        }
        setData(-1, -1, -1);
        
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
