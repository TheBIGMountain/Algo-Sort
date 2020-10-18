package com.dqpi.algo.sort.two_way_quick_sort;

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
public class TwoWayQuickSortDraw implements Draw {

    @Resource
    private Painter painter;

    @Resource
    private ColorHelper colorHelper;

    @Setter
    private int[] numbers;
    
    public int left, right;
    public boolean[] fixedPivots;
    public int curPivot;    
    public int curLeft, curRight;  
    
    
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
            if (i >= left && i <= right) {
                painter.setFillColor(colorHelper.LIGHT_GREEN);
            }
            else {
                painter.setFillColor(colorHelper.GREY);
            }
            
            if (i == curPivot) {
                painter.setFillColor(colorHelper.INDIGO);
            }
            if (i >= left + 1 && i <= curLeft) {
                painter.setFillColor(colorHelper.RED);
            }
            if (i >= curRight && i <= right) {
                painter.setFillColor(colorHelper.RED);
            }
            if (fixedPivots[i]) {
                painter.setFillColor(colorHelper.LIGHT_BLUE);
            }
            painter.fillRectangle(w * i, canvasHeight - numbers[i], w - 1, numbers[i]);
        }
    }
}
