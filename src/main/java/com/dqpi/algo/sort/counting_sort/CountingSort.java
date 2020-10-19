package com.dqpi.algo.sort.counting_sort;

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
public class CountingSort {
    @Resource
    private CountingSortDraw draw;
    
    @Resource
    private Painter painter;
    
    @Resource
    private MainVm mainVm;
    
    @Setter
    private int[] numbers;

    @Async
    public void countingSort() {
        int[] count = new int[painter.getCanvasHeight() + 1];
        for (int i = 0; i < draw.colors.length; i++) {
            draw.colors[i] = painter.getRandomColor();
        }
        draw.setNumbers(numbers);
        draw.setCount(count);
        painter.draw(draw);
        
        for (int number : numbers) {
            setData(number, false);
            count[number] ++;
        }

        for (int i = 0, j = 0; i < count.length; i++) {
            while (count[i] > 0) {
                setData(j, true);
                numbers[j] = i;
                j ++;
                setData(j, true);
                count[i] --;
            }
        }
        setData(numbers.length, true);
        
        mainVm.setInitShow(true);
        mainVm.setStartShow(true);
    }
    
    
    private void setData(int current, boolean isStart) {
        draw.current = current;
        draw.isStart = isStart;
        painter.rest();
    }
}
