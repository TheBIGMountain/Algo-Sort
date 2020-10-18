package com.dqpi.algo.sort.heap_sort;

import com.dqpi.algo.painter.ColorHelper;
import com.dqpi.algo.painter.Painter;
import com.dqpi.algo.sort.Draw;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Mountain
 * @date 2020/10/16
 */
@Component
public class HeapSortDraw implements Draw {
    @Resource
    private Painter painter;

    @Resource
    private ColorHelper colorHelper;

    @Setter
    private int[] numbers;
    
    public int heapIndex;
    
    public int currentIndex;
    
    public boolean isHeap;
    
    /**
     * 具体绘制
     */
    @Override
    public void draw() {
        int canvasWidth = painter.getCanvasWidth();
        int canvasHeight = painter.getCanvasHeight();

        int w = canvasWidth / numbers.length;
        for (int i = 0; i < numbers.length; i++) {
            if (i >= heapIndex) {
                painter.setFillColor(colorHelper.LIGHT_BLUE);
            }
            else {
                painter.setFillColor(colorHelper.GREY);
            }
            
            if (isHeap && i < heapIndex) {
                painter.setFillColor(colorHelper.LIGHT_GREEN);
            }
            
            if (i == currentIndex) {
                painter.setFillColor(colorHelper.RED);
            }
            painter.fillRectangle(w * i, canvasHeight - numbers[i], w - 1, numbers[i]);
        }
    }
}
