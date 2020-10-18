package com.dqpi.algo.sort.insert_sort;

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
public class InsertSort {
    @Resource
    private InsertSortDraw draw;
    
    @Resource
    private Painter painter;
    
    @Resource
    private MainVm mainVm;
    
    @Setter
    private int[] numbers;

    @Async
    public void insertSort() {
        draw.setNumbers(numbers);
        painter.draw(draw);
        
        setData(0, -1);
        for (int i = 1; i < numbers.length; i++) {
            setData(i - 1, i);
            int temp = numbers[i];
            int j = i;
            while (j > 0 && numbers[j - 1] > temp) {
                numbers[j] = numbers[j - 1];
                setData(i + 1, j - 1);
                j --;
            }
            numbers[j] = temp;
        }
        setData(numbers.length, -1);
        
        mainVm.setInitShow(true);
        mainVm.setStartShow(true);
    }
    
    private void setData(int orderIndex, int currentIndex) {
        draw.orderIndex = orderIndex;
        draw.currentIndex = currentIndex;
        painter.rest();
    }
}
