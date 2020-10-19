package com.dqpi.algo.sort;

import com.dqpi.algo.config.CanvasConfig;
import com.dqpi.algo.enums.AlgoEnum;
import com.dqpi.algo.enums.SortStatusEnum;
import com.dqpi.algo.painter.ColorHelper;
import com.dqpi.algo.painter.Painter;
import com.dqpi.algo.sort.bubble_sort.BubbleSort;
import com.dqpi.algo.sort.counting_sort.CountingSort;
import com.dqpi.algo.sort.heap_sort.HeapSort;
import com.dqpi.algo.sort.insert_sort.InsertSort;
import com.dqpi.algo.sort.merge_sort.MergeSort;
import com.dqpi.algo.sort.quick_sort.QuickSort;
import com.dqpi.algo.sort.radix_sort.RadixSort;
import com.dqpi.algo.sort.selection_sort.SelectionSort;
import com.dqpi.algo.sort.shell_sort.ShellSort;
import com.dqpi.algo.sort.three_way_quick_sort.ThreeWayQuickSort;
import com.dqpi.algo.sort.two_way_quick_sort.TwoWayQuickSort;
import com.dqpi.algo.vm.MainVm;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;

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
    private BubbleSort bubbleSort;
    
    @Resource
    private SelectionSort selectionSort;
    
    @Resource
    private InsertSort insertSort;
    
    @Resource
    private MergeSort mergeSort;
    
    @Resource
    private QuickSort quickSort;
    
    @Resource
    private TwoWayQuickSort twoWayQuickSort;
    
    @Resource
    private ThreeWayQuickSort threeWayQuickSort;
    
    @Resource
    private HeapSort heapSort;
    
    @Resource
    private ShellSort shellSort;
    
    @Resource
    private CountingSort countingSort;
    
    @Resource
    private RadixSort radixSort;
    
    @Setter
    private int[] numbers;
    
    public void initNumbers() {
        if (mainVm.getSize() == 0) {
            return;
        }
        
        numbers = new int[mainVm.getSize()];
        switch (SortStatusEnum.getAlgo(mainVm.getSortStatus())) {
            case CHAOS_ORDER:
                for (int i = 0; i < mainVm.getSize(); i++) {
                    numbers[i] = (int) (Math.random() * canvasConfig.getHeight()) + 1;
                }
                break;
            case ALMOST_ORDER:
                for (int i = 0; i < mainVm.getSize(); i++) {
                    numbers[i] = (int) (Math.random() * canvasConfig.getHeight()) + 1;
                }
                Arrays.sort(numbers);
                int swapTime = (int) (0.02 * numbers.length);
                if (swapTime == 0) {
                    swapTime = 1;
                }
                for(int i = 0 ; i < swapTime; i ++){
                    int a = (int)(Math.random() * numbers.length);
                    int b = (int)(Math.random() * numbers.length);
                    int temp = numbers[a];
                    numbers[a] = numbers[b];
                    numbers[b] = temp;
                }
                break;
            case EQUAL_ORDER:
                for (int i = 0; i < mainVm.getSize(); i++) {
                    numbers[i] = painter.getCanvasHeight() / 2;
                }
                break;
            default:
                break;
        }
        
        painter.draw(this);
    }
    
    public void sort(AlgoEnum algoEnum) {
        if (numbers == null) {
            return;
        }
        switch (algoEnum) {
            case BUBBLE_SORT:
                bubbleSort.setNumbers(numbers);
                bubbleSort.bubbleSort();
                break;
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
                break;
            case QUICK_SORT:
                quickSort.setNumbers(numbers);
                quickSort.quickSort(AlgoEnum.QUICK_SORT);
                break;
            case RANDOM_QUICK_SORT:
                quickSort.setNumbers(numbers);
                quickSort.quickSort(AlgoEnum.RANDOM_QUICK_SORT);
                break;
            case TWO_WAY_QUICK_SORT:
                twoWayQuickSort.setNumbers(numbers);
                twoWayQuickSort.quickSort();
                break;
            case THREE_WAY_QUICK_SORT:
                threeWayQuickSort.setNumbers(numbers);
                threeWayQuickSort.quickSort();
                break;
            case HEAP_SORT:
                heapSort.setNumbers(numbers);
                heapSort.heapSort();
                break;
            case SHELL_SORT:
                shellSort.setNumbers(numbers);
                shellSort.shellSort();
                break;
            case COUNTING_SORT:
                countingSort.setNumbers(numbers);
                countingSort.countingSort();
                break;
            case RADIX_SORT:
                radixSort.setNumbers(numbers);
                radixSort.radixSort();
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
