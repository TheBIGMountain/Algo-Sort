package com.dqpi.algo.sort;

import com.dqpi.algo.config.CanvasConfig;
import com.dqpi.algo.enums.AlgoEnum;
import com.dqpi.algo.painter.ColorHelper;
import com.dqpi.algo.painter.Painter;
import com.dqpi.algo.sort.insert_sort.InsertSort;
import com.dqpi.algo.sort.merge_sort.MergeSort;
import com.dqpi.algo.sort.quick_sort.QuickSort;
import com.dqpi.algo.sort.selection_sort.SelectionSort;
import com.dqpi.algo.vm.MainVm;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Mountain
 * @date 2020/10/16
 */
@Component
public class SortData implements Draw{
    
    @Resource
    private CanvasConfig canvasConfig;
    
    @Resource
    private MainVm mainVm;
    
    @Resource
    private Painter painter;
    
    @Resource
    private ColorHelper colorHelper;
    
    @Resource
    private SelectionSort selectionSort;
    
    @Resource
    private MergeSort mergeSort;
    
    @Resource
    private InsertSort insertSort;
    
    @Resource
    private QuickSort quickSort;
    
    private int[] numbers;
    
    public void initNumbers() {
        if (mainVm.getSize() == 0) {
            return;
        }
        numbers = new int[mainVm.getSize()];
        for (int i = 0; i < mainVm.getSize(); i++) {
            numbers[i] = (int) (Math.random() * canvasConfig.getHeight()) + 1;
        }
        painter.draw(canvasConfig.getDelay(), this);
    }
    
    public void sort(AlgoEnum algoEnum) {
        if (numbers == null) {
            return;
        }
        switch (algoEnum) {
            case SELECTION_SORT:
                selectionSort.setNumbers(numbers);
                selectionSort.selectionSort();
                break;
            case INSERT_SORT:
                insertSort.setNumbers(numbers);
                insertSort.insertSort();
                break;
            case MERGE_SORT:
                mergeSort.setNumbers(numbers);
                mergeSort.mergeSort();
            case ONE_WAY_QUICK_SORT:
                quickSort.setNumbers(numbers);
                quickSort.quickSort(AlgoEnum.ONE_WAY_QUICK_SORT);
                break;
            case TWO_WAY_QUICK_SORT:
                quickSort.setNumbers(numbers);
                quickSort.quickSort(AlgoEnum.TWO_WAY_QUICK_SORT);
                break;
            case THREE_WAY_QUICK_SORT:
                quickSort.setNumbers(numbers);
                quickSort.quickSort(AlgoEnum.THREE_WAY_QUICK_SORT);
                break;
            default:
                break;
        }
    }

    /**
     * 具体绘图
     */
    @Override
    public void draw() {
        int canvasWidth = painter.getCanvasWidth();
        int canvasHeight = painter.getCanvasHeight();

        int w = canvasWidth / numbers.length;
        painter.setFillColor(colorHelper.GREY);
        for (int i = 0; i < numbers.length; i++) {
            painter.fillRectangle(w * i, canvasHeight - numbers[i], w - 1, numbers[i]);
        }
    }
}
