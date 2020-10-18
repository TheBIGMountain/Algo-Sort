package com.dqpi.algo.sort.quick_sort;

import com.dqpi.algo.enums.AlgoEnum;
import com.dqpi.algo.painter.Painter;
import com.dqpi.algo.vm.MainVm;
import lombok.Setter;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Mountain
 * @date 2020/10/17
 */
@Component
public class QuickSort {
    @Resource
    private QuickSortDraw draw;

    @Resource
    private Painter painter;

    @Resource
    private MainVm mainVm;
    
    @Setter
    private int[] numbers;
    
    @Async
    public void quickSort(AlgoEnum algoEnum) {
        draw.setNumbers(numbers);
        draw.fixedPivot = new boolean[mainVm.getSize()];
        painter.draw(draw);
        
        setData(-1, -1, -1, -1, -1);
        quickSort(0, numbers.length - 1, algoEnum);
        setData(-1, -1, -1, -1, -1);
        
        mainVm.setInitShow(true);
        mainVm.setStartShow(true);
    }
    
    private void quickSort(int left, int right, AlgoEnum algoEnum) {
        if (left > right) {
            return;
        }
        
        if (left == right) {
            setData(left, right, left, -1, -1);
            return;
        }
        
        setData(left, right, -1, -1, -1);
        int p = partition(left, right, algoEnum);
        quickSort(left, p - 1, algoEnum);
        quickSort(p + 1, right, algoEnum);
    }
    
    private int partition(int left, int right, AlgoEnum algoEnum) {
        if (algoEnum.equals(AlgoEnum.RANDOM_QUICK_SORT)) {
            int randomIndex = (int) (Math.random() * (right - left + 1)) + left;
            setData(left, right, -1, randomIndex,  -1);
            swap(left, randomIndex);
        }   
        else {
            setData(left, right, -1, left, -1);
        }
        
        int value = numbers[left];
        int midValueIndex = left;
        for (int i = midValueIndex + 1; i <= right; i++) {
            setData(left, right, -1, left,  i);
            if (numbers[i] < value) {
                midValueIndex ++;
                swap(i, midValueIndex);
            }
        }
        
        swap(left, midValueIndex);
        setData(left, right, midValueIndex, -1,  -1);
        return midValueIndex;
    }

    private void swap(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
    
    private void setData(int left, int right, int fixedPivot, int curPivot, int curElement) {
        draw.left = left;
        draw.right = right;
        if (fixedPivot != -1) {
            draw.fixedPivot[fixedPivot] = true;
        }
        draw.curPivot = curPivot;
        draw.curElement = curElement;
        painter.rest();
    }
    
    
}
