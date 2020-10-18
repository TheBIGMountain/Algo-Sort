package com.dqpi.algo.sort.merge_sort;

import com.dqpi.algo.config.CanvasConfig;
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
public class MergeSort {
    
    @Setter
    private int[] numbers;
    
    @Resource
    private Painter painter;
    
    @Resource
    private CanvasConfig canvasConfig;
    
    @Resource
    private MergeSortDraw draw;
    
    @Resource
    private MainVm mainVm;
    
    @Async
    public void mergeSort() {
        draw.setNumbers(numbers);
        painter.draw(draw);
        
        setData(-1, -1, -1, false);
        mergeSort(0, numbers.length - 1);
        setData(0, numbers.length- 1, -1, true);
        mainVm.setInitShow(true);
        mainVm.setStartShow(true);
    }
    
    private void mergeSort(int left, int right) {
        if (left >= right) {
            return;
        }
        
        int mid = (left + right) / 2;
        mergeSort(left, mid);
        mergeSort(mid + 1, right);
        merge(left, mid, right);
        setData(-1, -1, -1, false);
    }

    private void merge(int left, int mid, int right) {
        int start1 = left;
        int start2 = mid + 1;
        int[] tempArr = new int[right - left + 1];
        int tempI = 0;
        
        while (start1 <= mid && start2 <= right) {
            if (numbers[start1] <= numbers[start2]) {
                tempArr[tempI] = numbers[start1];
                tempI ++;
                start1 ++;
            }
            else {
                tempArr[tempI] = numbers[start2];
                tempI ++;
                start2 ++;
            }
        }
        
        while (start1 <= mid) {
            tempArr[tempI] = numbers[start1];
            tempI ++;
            start1 ++;
        }
        
        while (start2 <= right) {
            tempArr[tempI] = numbers[start2];
            tempI ++;
            start2 ++;
        }
        
        for (int i = 0; i < tempArr.length; i ++) {
            numbers[i + left] = tempArr[i]; 
            setData(left, i + left, i + left, false);
        }
    }
    
    private void setData(int left, int right, int currentIndex, boolean end) {
        draw.left = left;
        draw.right = right;
        draw.currentIndex = currentIndex;
        draw.end = end;
        painter.rest();
    }
}
