package com.dqpi.algo.sort.shell_sort;

import com.dqpi.algo.painter.ColorHelper;
import com.dqpi.algo.painter.Painter;
import com.dqpi.algo.sort.Draw;
import javafx.scene.paint.Color;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Mountain
 * @date 2020/10/16
 */
@Component
public class ShellSortDraw implements Draw {
    @Resource
    private Painter painter;

    @Resource
    private ColorHelper colorHelper;

    @Setter
    private int[] numbers;
    
    public int currentIndex = -1;
    public int gap = -1;
    public int isEnd = -1;
    public boolean end = false;
    public Color[] colors;
    
    /**
     * 具体绘制
     */
    @Override
    public void draw() {
        int canvasWidth = painter.getCanvasWidth();
        int canvasHeight = painter.getCanvasHeight();

        int w = canvasWidth / numbers.length;
        for (int i = 0; i < gap; i ++) {
            int j = i;
            while (j < numbers.length) {
                painter.setFillColor(colors[i]);
                if (j <= isEnd) {
                    painter.setFillColor(colorHelper.LIGHT_BLUE);
                }
                if (j > isEnd && end) {
                    painter.setFillColor(colorHelper.GREY);
                }
                if (j == currentIndex) {
                    painter.setFillColor(colorHelper.RED);
                }
                painter.fillRectangle(w * j, canvasHeight - numbers[j], w - 1, numbers[j]);
                j = j + gap;
            }
        }
    }
}
