package com.dqpi.algo.sort.shell_sort;

import com.dqpi.algo.painter.Painter;
import com.dqpi.algo.vm.MainVm;
import javafx.scene.paint.Color;
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
        draw.colors = new Color[numbers.length / 2];
        for (int i = 0; i < draw.colors.length; i++) {
            draw.colors[i] = painter.getRandomColor();
        }
        painter.draw(draw);
        
        for (int gap = numbers.length / 2; gap > 0; gap = gap / 2) {
            setData(-1, gap, -1, gap == 1);
            for (int i = 0; i < gap; i ++) {
                int j = i + gap;
                if (gap == 1) {
                    setData(j, gap, i, true);
                }
                else {
                    setData(j, gap, -1, false);
                }
                while (j < numbers.length) {
                    if (numbers[j] < numbers[j - gap]) {
                        int k = j;
                        int temp = numbers[k];
                        while (k - gap >= 0 && numbers[k - gap] > temp) {
                            numbers[k] = numbers[k - gap];
                            k = k - gap;
                            if (gap == 1) {
                                setData(k, gap, j, true);
                            }
                            else {
                                setData(k, gap, -1, false);
                            }
                        }
                        numbers[k] = temp;
                        if (gap == 1) {
                            setData(k, gap, j, true);
                        }
                        else {
                            setData(k, gap, -1, false); 
                        }
                    }
                    
                    j = j + gap;
                    if (gap == 1) {
                        setData(j, gap, j, true);
                    }
                    else {
                        setData(j, gap, -1, false);
                    }
                }
            }
        }
        setData(-1, 1, numbers.length, true);
            
        mainVm.setInitShow(true);
        mainVm.setStartShow(true);
    }
    
    
    private void setData(int currentIndex, int gap, int isEnd, boolean end) {
        draw.currentIndex = currentIndex;
        draw.gap = gap;
        draw.isEnd = isEnd;
        draw.end = end;
        painter.rest();
    }
}
