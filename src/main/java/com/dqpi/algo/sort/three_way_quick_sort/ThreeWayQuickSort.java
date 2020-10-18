package com.dqpi.algo.sort.three_way_quick_sort;

import com.dqpi.algo.painter.Painter;
import com.dqpi.algo.vm.MainVm;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Mountain
 * @date 2020/10/17
 */
@Component
public class ThreeWayQuickSort {
    @Resource
    private ThreeWayQuickSortDraw draw;

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
        
        setData(-1 , -1, -1, -1, -1, -1);
        quickSort(0, numbers.length - 1);
        setData(-1 , -1, -1, -1, -1, -1);
        
        mainVm.setInitShow(true);
        mainVm.setStartShow(true);
    }
    
    private void quickSort(int left, int right) {
        if (left > right) {
            return;
        }

        if (left == right) {
            setData(left , right, left, -1, -1, -1);
            return;
        }
        
        LessAndGreat p = partition(left, right);
        quickSort(left, p.less - 1);
        quickSort(p.great, right);
    }
    
    private LessAndGreat partition(int left, int right) {
        int randomIndex = (int) ((Math.random() * (right - left + 1)) + left);
        setData(left, right, -1, randomIndex, -1, -1);
        swap(left, randomIndex);

        int value = numbers[left];
        setData(left, right, -1, left, -1, -1);

        int lessThen = left;
        int greatThen = right + 1;
        int equalThen = left + 1;
        setData(left, right, -1, left, lessThen, greatThen);
        while (equalThen < greatThen) {
            if (numbers[equalThen] < value) {
                swap(equalThen, lessThen + 1);
                equalThen ++;
                lessThen ++;
            }
            else if (numbers[equalThen] > value) {
                swap(equalThen, greatThen - 1);
                greatThen --;
            }
            else {
                equalThen ++;
            }

            setData(left, right, -1, left, equalThen, greatThen);
        }

        swap(left, lessThen);
        setData(left, right, lessThen, -1, -1, -1);
        return new LessAndGreat(lessThen, greatThen);
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
            int i = fixedPivot;
            while (i < numbers.length && numbers[i] == numbers[fixedPivot]) {
                draw.fixedPivots[i] = true;
                i ++;
            }
        }
        draw.curPivot = curPivot;
        draw.curLeft = curLeft;
        draw.curRight = curRight;
        
        painter.rest();
    }
    
    @AllArgsConstructor
    private static class LessAndGreat {
        private final int less, great;
    }
}
