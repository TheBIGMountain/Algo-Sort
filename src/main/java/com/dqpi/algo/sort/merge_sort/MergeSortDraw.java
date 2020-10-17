package com.dqpi.algo.sort.merge_sort;

import com.dqpi.algo.painter.ColorHelper;
import com.dqpi.algo.painter.Painter;
import com.dqpi.algo.sort.Draw;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Mountain
 * @date 2020/10/17
 */
@Component
public class MergeSortDraw implements Draw {
    
    @Resource
    private Painter painter;
    
    @Resource
    private ColorHelper colorHelper;
    
    @Setter
    private int[] numbers;

    public int orderIndex = -1;
    public int currentIndex = -1;
    public int endIndex = -1;
    
    /**
     * 具体绘制
     */
    @Override
    public void draw() {
        int canvasWidth = painter.getCanvasWidth();
        int canvasHeight = painter.getCanvasHeight();

        int w = canvasWidth / numbers.length;
        painter.setFillColor(colorHelper.GREY);
        for (int i = 0; i < numbers.length; i++) {
            if (i <= orderIndex) {
                painter.setFillColor(colorHelper.LIGHT_GREEN);
            }
            else {
                painter.setFillColor(colorHelper.GREY);
            }
            
            if (i == currentIndex) {
                painter.setFillColor(colorHelper.RED);
            }
            
            if (endIndex > orderIndex) {
                painter.setFillColor(colorHelper.LIGHT_BLUE);
            }
            painter.fillRectangle(w * i, canvasHeight - numbers[i], w - 1, numbers[i]);
        }
    }
}

