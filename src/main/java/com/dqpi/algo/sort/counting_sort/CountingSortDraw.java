package com.dqpi.algo.sort.counting_sort;

import com.dqpi.algo.painter.ColorHelper;
import com.dqpi.algo.painter.Painter;
import com.dqpi.algo.sort.Draw;
import com.dqpi.algo.vm.MainVm;
import javafx.scene.paint.Color;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Mountain
 * @date 2020/10/16
 */
@Component
public class CountingSortDraw implements Draw {
    @Resource
    private Painter painter;

    @Resource
    private ColorHelper colorHelper;
    
    @Resource
    private MainVm mainVm;

    @Setter
    private int[] numbers;

    @Setter
    public int[] count;
    
    public int current;
    public boolean isStart;
    public boolean isEnd;
    public final Color[] colors = new Color[500];
    
    /**
     * 具体绘制
     */
    @Override
    public void draw() {
        int canvasWidth = painter.getCanvasWidth();
        int canvasHeight = painter.getCanvasHeight();
        
        int w = canvasWidth / numbers.length;
        if (!isStart) {
            if (mainVm.getSortStatus() == 2) {
                for (int i = 0; i < 500; i++) {
                    painter.setFillColor(colors[i]);
                    painter.fillRectangle(2 * i, canvasHeight - count[i], 2 - 1, count[i]);
                }
            }
            else {
                for (int i = 0; i < 500; i++) {
                    painter.setFillColor(colors[i]);
                    painter.fillRectangle(2 * i, canvasHeight - count[i] * 50, 2 - 1, count[i] * 50);
                }
            }
        }
        else {
            for (int i = 0; i < numbers.length; i++) {
                painter.setFillColor(colorHelper.GREY);
                if (i < current) {
                    painter.setFillColor(colorHelper.LIGHT_BLUE);
                }
                if (i == current) {
                    painter.setFillColor(colorHelper.RED);
                }
                painter.fillRectangle(w * i, canvasHeight - numbers[i], w - 1, numbers[i]);
            }
        }
    }
}
