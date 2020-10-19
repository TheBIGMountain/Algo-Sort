package com.dqpi.algo.sort.radix_sort;

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
public class RadixSort {
    @Resource
    private RadixSortDraw draw;
    
    @Resource
    private Painter painter;
    
    @Resource
    private MainVm mainVm;
    
    @Setter
    private int[] numbers;
    
    

    @Async
    public void radixSort() {
        draw.setNumbers(numbers);
        for (int i = 0; i < draw.colors.length; i++) {
            draw.colors[i] = painter.getRandomColor();
        }
        painter.draw(draw);

        int[][] buckets = new int[10][numbers.length];
        int[] count = new int[10];
        setData(0, 0,-1, false, false);
        for (int i = 0; i < 3; i ++) {
            int pow = (int) Math.pow(10, i);
            for (int value : numbers) {
                int digit = value / pow % 10;
                buckets[digit][count[digit]] = value;
                count[digit]++;
                setData(digit, count[digit], -1, false, false);
            }

            int index = 0;
            for (int k = 0; k < buckets.length; k ++) {
                int j = 0;
                while (count[k] != 0) {
                    setData(k, count[k], index, true, i == 2);
                    numbers[index] = buckets[k][j];
                    j ++;
                    count[k] --;
                    index ++;
                    setData(k, count[k], index, true, i == 2);
                }
            }
        }
        
        mainVm.setInitShow(true);
        mainVm.setStartShow(true);
    }
    
    
    
    private void setData(int index, int value, int current, boolean isStart, boolean isEnd) {
        draw.count[index] = value;
        draw.current = current;
        draw.isStart = isStart;
        draw.isEnd = isEnd;
        painter.rest();
    }
}
