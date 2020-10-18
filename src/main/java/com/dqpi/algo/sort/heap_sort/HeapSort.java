package com.dqpi.algo.sort.heap_sort;

import com.dqpi.algo.painter.Painter;
import com.dqpi.algo.vm.MainVm;
import lombok.Setter;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Mountain
 * @date 2020/10/16
 */
@Component
public class HeapSort {
    @Resource
    private HeapSortDraw draw;
    
    @Resource
    private Painter painter;
    
    @Resource
    private MainVm mainVm;
    
    @Setter
    private int[] numbers;
    
    @Async
    public void heapSort() {
        draw.setNumbers(numbers);
        painter.draw(draw);
        
        setData(numbers.length, -1, false);
        for (int i = getParent(numbers.length - 1); i >= 0; i --) {
            siftDown(numbers.length, i, numbers.length, false);
        }
        setData(numbers.length, -1, true);
        
        for (int i = numbers.length - 1; i > 0; i --) {
            swap(0, i);
            siftDown(i, 0, i, true);
        }
        setData(0, -1, false);
        
        mainVm.setInitShow(true);
        mainVm.setStartShow(true);
    }
            
    private void siftDown(int size, int index, int drawIndex, boolean isHeap) {
        setData(drawIndex, index, isHeap);
        if (getLeftChild(index) >= size) {
            return;
        }

        int maxIndex = getLeftChild(index);
        if (getRightChild(index) < size && numbers[getRightChild(index)] > numbers[maxIndex]) {
            maxIndex = getRightChild(index);
        }

        if (numbers[maxIndex] <= numbers[index]) {
            return;
        }
        
        swap(index, maxIndex);
        setData(drawIndex, maxIndex, isHeap);
        siftDown(size, maxIndex, drawIndex, isHeap);
    }   

    private void swap(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    private int getParent(int index) {
        return (index - 1) / 2; 
    }

    private int getLeftChild(int index) {
        return index * 2 + 1;
    }

    private int getRightChild(int index) {
        return index * 2 + 2;
    }
    
    private void setData(int heapIndex, int currentIndex, boolean isHeap) {
        draw.heapIndex = heapIndex;
        draw.currentIndex = currentIndex;
        draw.isHeap = isHeap;
        painter.rest();
    }
}
