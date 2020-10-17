package com.dqpi.algo.sort.selection_sort;

import com.dqpi.algo.painter.ColorHelper;
import com.dqpi.algo.painter.Painter;
import com.dqpi.algo.sort.Draw;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Mountain
 * @date 2020/10/13
 */
@Component
public class SelectionSortDraw implements Draw {
    
    @Resource
    private Painter painter;
    
    @Resource
    private ColorHelper colorHelper;
    
    @Setter
    private int[] numbers;
    
    public int orderedIndex = -1;
    public int currentMinIndex = -1;
    public int currentCompareIndex = -1;
    
    /**
     * 具体绘图
     */
    @Override
    public void draw() {
        int canvasWidth = painter.getCanvasWidth();
        int canvasHeight = painter.getCanvasHeight();
        
        int w = canvasWidth / numbers.length;
        for (int i = 0; i < numbers.length; i++) {
            if (i < this.orderedIndex) {
                painter.setFillColor(colorHelper.LIGHT_BLUE);
            }
            else {
                painter.setFillColor(colorHelper.GREY);
            }
            
            if (i == this.currentCompareIndex) {
                painter.setFillColor(colorHelper.RED);
            }
            
            if (i == this.currentMinIndex) {
                painter.setFillColor(colorHelper.DEEP_PURPLE);
            }
            painter.fillRectangle(w * i, canvasHeight - numbers[i], w - 1, numbers[i]);
        }
    }
}
