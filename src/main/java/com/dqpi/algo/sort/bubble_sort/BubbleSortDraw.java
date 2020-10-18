package com.dqpi.algo.sort.bubble_sort;

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
public class BubbleSortDraw implements Draw {
    @Resource
    private Painter painter;

    @Resource
    private ColorHelper colorHelper;

    @Setter
    private int[] numbers;
    
    public int orderIndex = -1;
    public int currentIndex = -1;
    public int currentCompareIndex = -1;
    
    /**
     * 具体绘制
     */
    @Override
    public void draw() {
        int canvasWidth = painter.getCanvasWidth();
        int canvasHeight = painter.getCanvasHeight();

        int w = canvasWidth / numbers.length;
        for (int i = 0; i < numbers.length; i++) {
            if (i >= orderIndex) {
                painter.setFillColor(colorHelper.LIGHT_BLUE);
            }
            else {
                painter.setFillColor(colorHelper.GREY);
            }
            if (i == currentIndex) {
                painter.setFillColor(colorHelper.RED);
            }

            if (i == currentCompareIndex) {
                painter.setFillColor(colorHelper.INDIGO);
            }

            
            painter.fillRectangle(w * i, canvasHeight - numbers[i], w - 1, numbers[i]);
        }
    }
}
