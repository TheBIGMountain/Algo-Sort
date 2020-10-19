package com.dqpi.algo.sort.radix_sort;

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
public class RadixSortDraw implements Draw {
    @Resource
    private Painter painter;

    @Resource
    private ColorHelper colorHelper;
    
    @Resource
    private MainVm mainVm;

    @Setter
    private int[] numbers;
    
    public final int[] count = new int[10];
    
    public final Color[] colors = new Color[10];
    
    public boolean isStart;
    public boolean isEnd;
    public int current;
    
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
                for (int i = 0; i < count.length; i++) {
                    painter.setFillColor(colors[i]);
                    painter.fillRectangle(100 * i, canvasHeight - count[i], 99, count[i]);
                }
            }
            else {
                for (int i = 0; i < count.length; i++) {
                    painter.setFillColor(colors[i]);
                    painter.fillRectangle(100 * i, canvasHeight - count[i] * 5, 99, count[i] * 5);
                }
            }
        }
        else {
            for (int i = 0; i < numbers.length; i++) {
                painter.setFillColor(colorHelper.GREY);
                if (!isEnd && i < current) {
                    painter.setFillColor(colorHelper.LIGHT_GREEN);
                }
                
                if (isEnd && i < current){
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
