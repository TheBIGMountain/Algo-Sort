package com.dqpi.algo.sort.two_way_quick_sort;

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
public class TwoWayQuickSort {
    @Resource
    private TwoWayQuickSortDraw draw;

    @Resource
    private Painter painter;

    @Resource
    private MainVm mainVm;
    
    @Setter
    private int[] numbers;
    
    @Async
    public void quickSort() {
        draw.setNumbers(numbers);   
        draw.fixedPivots = new boolean[mainVm.getSize()];
        painter.draw(draw);
        
        setData(-1, -1, -1, -1, -1, -1);
        quickSort(0, numbers.length - 1);
        setData(-1, -1, -1, -1, -1, -1);
        
        mainVm.setInitShow(true);
        mainVm.setStartShow(true);
    }
    
    private void quickSort(int left, int right) {
        if (left > right) {
            return;
        }

        if (left == right) {
            setData(left, right, left, -1, -1, -1);
            return;
        }

        setData(left, right, -1, -1, -1, -1);
        
        int p = partition(left, right);
        quickSort(left, p - 1);
        quickSort(p + 1, right);
    }
    
    private int partition(int left, int right) {
        int randomIndex = (int) ((Math.random() * (right - left + 1)) + left);
        setData(left, right, -1, randomIndex, -1, -1);
        swap(left, randomIndex);

        int value = numbers[left];
        setData(left, right, -1, left, -1, -1);

        int leftIndex = left + 1;
        int rightIndex = right;
        setData(left, right, -1, left, leftIndex, rightIndex);
        while (true) {
            while (leftIndex <= right && numbers[leftIndex] < value) {
                leftIndex ++;
                setData(left, right, -1, left, leftIndex, rightIndex);
            }

            while (rightIndex >= left + 1 && numbers[rightIndex] > value) {
                rightIndex --;
                setData(left, right, -1, left, leftIndex, rightIndex);
            }

            if (leftIndex > rightIndex) {
                break;
            }
            
            swap(leftIndex, rightIndex);
            leftIndex ++;
            rightIndex --;
            setData(left, right, -1, left, leftIndex, rightIndex);
        }

        swap(left, rightIndex);
        setData(left, right, rightIndex, -1, -1, -1);
        return rightIndex;
    }

    private void swap(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
    
    private void setData(int left, int right, int fixedPivot, int curPivot, int curLeft, int curRight) {
        draw.left = left;
        draw.right = right;
        if (fixedPivot != -1) {
            draw.fixedPivots[fixedPivot] = true;
        }
        draw.curPivot = curPivot;
        draw.curLeft = curLeft;
        draw.curRight = curRight;
        painter.rest();
    }
}
