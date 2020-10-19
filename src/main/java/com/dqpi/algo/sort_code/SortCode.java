package com.dqpi.algo.sort_code;

import com.dqpi.algo.enums.AlgoEnum;
import org.springframework.stereotype.Component;

/**
 * @author Mountain
 * @date 2020/10/17
 */
@Component
public class SortCode  {
    
    public String getCode(AlgoEnum algoEnum, int size) {
        switch (algoEnum) {
            case BUBBLE_SORT:
                return "/**\n" +
                        "     * 冒泡排序: 遍历数组元素，逐步比较下一个元素，比较条件成立时交换元素。比较结束后，最大或最小元素将位于数组末尾。\n" +
                        "     * 时间复杂度: 基本稳定为O(n²)\n" +
                        "     */\n" +
                        "    private static void bubbleSort(int[] numbers) {\n" +
                        "        // 遍历数组元素，每遍历一次后，待遍历数组元素减一，因为最大或最小元素已放在数组末尾\n" +
                        "        for (int i = 0, k = numbers.length; i < k; k --) {\n" +
                        "            // 从当前元素的下一个元素开始进行比较\n" +
                        "            for (int j = i + 1; j < k; j ++) {\n" +
                        "                // 该元素小于上一个元素时进行交换操作\n" +
                        "                if (numbers[j] < numbers[j - 1]) {\n" +
                        "                    // 数组元素交换\n" +
                        "                    swap(numbers, j, j - 1);\n" +
                        "                }\n" +
                        "            }\n" +
                        "        }\n" +
                        "    }\n" +
                        "    \n" +
                        "    private static void swap(int[] numbers, int i, int j) {\n" +
                        "        int temp = numbers[i];\n" +
                        "        numbers[i] = numbers[j];\n" +
                        "        numbers[j] = temp;\n" +
                        "    }";
            case SELECTION_SORT:
                return "/**\n" +
                        "     * 选择排序: 遍历数组元素，记录当前元素为最小元素，逐步比较下一个元素，比较条件成立时，\n" +
                        "     *          更新该元素标记为最小元素，遍历结束后，交换当前元素和最小元素\n" +
                        "     * 时间复杂度: 基本稳定为O(n²)\n" +
                        "     */\n" +
                        "    private static void selectionSort(int[] numbers) {\n" +
                        "        // 数组遍历\n" +
                        "        for (int i = 0; i < numbers.length; i++) {\n" +
                        "            // 记录当前元素为最小元素\n" +
                        "            int minIndex = i;\n" +
                        "            for (int j = i + 1; j < numbers.length; j ++) {\n" +
                        "                // 该比较元素小于标记的最小元素时，更新该元素为最小元素\n" +
                        "                if (numbers[j] < numbers[minIndex]) {\n" +
                        "                    minIndex = j;\n" +
                        "                }\n" +
                        "            }\n" +
                        "            // 当前元素和最小元素进行交换\n" +
                        "            swap(numbers, i, minIndex);\n" +
                        "        }\n" +
                        "    }\n" +
                        "\n" +
                        "    private static void swap(int[] numbers, int i, int j) { \n" +
                        "        int temp = numbers[i];\n" +
                        "        numbers[i] = numbers[j];\n" +
                        "        numbers[j] = temp;\n" +
                        "    }";
            case INSERT_SORT:
                return "/**\n" +
                        "     * 插入排序: 遍历数组元素，从当前元素开始向前遍历，寻找合适的位置，向前遍历前，\n" +
                        "     *          当前元素的前面元素已为排序好的元素，当发现比较条件不成立时，即可中断遍历\n" +
                        "     * 时间复杂度: 一般情况为O(n²)，当数组为近乎有序时，将进化为O(n)\n" +
                        "     * 测试方式: 将分布情况设置为近乎有序或高度相等，即可看到插入排序在该情况下的优势\n" +
                        "     */\n" +
                        "    private static void insertSort(int[] numbers) {\n" +
                        "        // 从下一个元素开始遍历，前面元素为已排序好的元素\n" +
                        "        for (int i = 1; i < numbers.length; i++) {\n" +
                        "            // 这里采用位移法，当发现判断条件成立时，则将该元素向后位移，条件终止时，将之前保留的值赋值为当前元素\n" +
                        "            // 在JAVA中，位移法比交换法效率要高，因为交换元素需要执行三个步骤\n" +
                        "            // 比如在PYTHON中，也许没有效率问题，因为交换元素只需一个步骤: a, b = b, a\n" +
                        "            int temp = numbers[i];\n" +
                        "            int j = i;\n" +
                        "            while (j > 0 && numbers[j - 1] > temp) {\n" +
                        "                numbers[j] = numbers[j - 1];\n" +
                        "                j --;\n" +
                        "            }\n" +
                        "            numbers[j] = temp;\n" +
                        "            \n" +
                        "             /*交换法\n" +
                        "             int j = i;\n" +
                        "             while (j > 0 && numbers[j - 1] > numbers[j]) {\n" +
                        "                 int temp = numbers[j];\n" +
                        "                 numbers[j] = numbers[j - 1];\n" +
                        "                 numbers[j - 1] = temp;\n" +
                        "                 j --;\n" +
                        "            }*/\n" +
                        "        }\n" +
                        "    }";
            case MERGE_SORT:
                return "/**\n" +
                        "     * 归并排序: 将数组逐渐拆分成更小的数组, 最后合并时进行数组排序\n" +
                        "     * 时间复杂度: 基本稳定为O(nlogn)\n" +
                        "     */\n" +
                        "    private static void mergeSort(int[] numbers, int left, int right) {\n" +
                        "        // 递归终止条件\n" +
                        "        if (left >= right) {\n" +
                        "            return;\n" +
                        "        }\n" +
                        "\n" +
                        "        // 对半数组拆分\n" +
                        "        int mid = (left + right) / 2;\n" +
                        "        mergeSort(numbers, left, mid);\n" +
                        "        mergeSort(numbers, mid + 1, right);\n" +
                        "        // 数组合并\n" +
                        "        merge(numbers, left, mid, right);\n" +
                        "    }\n" +
                        "\n" +
                        "    private static void merge(int[] numbers, int left, int mid, int right) {\n" +
                        "        // 两个数组的起始索引\n" +
                        "        int start1 = left;\n" +
                        "        int start2 = mid + 1;\n" +
                        "        // 构建临时数组将两个数组合并成排序后的数组\n" +
                        "        int[] tempArr = new int[right - left + 1];\n" +
                        "        // 临时数组索引\n" +
                        "        int tempI = 0;\n" +
                        "\n" +
                        "        // A数组或B数组遍历结束时终止\n" +
                        "        while (start1 <= mid && start2 <= right) {\n" +
                        "            // 两数组当前元素比较，小的元素放入临时数组\n" +
                        "            if (numbers[start1] <= numbers[start2]) {\n" +
                        "                tempArr[tempI] = numbers[start1];\n" +
                        "                tempI ++;\n" +
                        "                start1 ++;\n" +
                        "            }\n" +
                        "            else {\n" +
                        "                tempArr[tempI] = numbers[start2];\n" +
                        "                tempI ++;\n" +
                        "                start2 ++;\n" +
                        "            }\n" +
                        "        }\n" +
                        "\n" +
                        "        // 判断A数组是否遍历结束，还有元素时，全部放入临时数组\n" +
                        "        while (start1 <= mid) {\n" +
                        "            tempArr[tempI] = numbers[start1];\n" +
                        "            tempI ++;\n" +
                        "            start1 ++;\n" +
                        "        }\n" +
                        "\n" +
                        "        // 判断B数组是否遍历结束，还有元素时，全部放入临时数组\n" +
                        "        while (start2 <= right) {\n" +
                        "            tempArr[tempI] = numbers[start2];\n" +
                        "            tempI ++;\n" +
                        "            start2 ++;\n" +
                        "        }\n" +
                        "\n" +
                        "        // 将临时数组元素放入待排序数组相应位置\n" +
                        "        for (int i = 0; i < tempArr.length; i ++) {\n" +
                        "            numbers[i + left] = tempArr[i];\n" +
                        "        }\n" +
                        "    }";
            case QUICK_SORT:
                return "/**\n" +
                        "     * 快速排序: 将待排序数组首元素标记为标定点，将所有小于该标定点的元素放于标定点左边，大于该标定点的元素放于右边。\n" +
                        "     * 时间复杂度: 一般情况为O(nlogn)，当元素近乎有序或全部相等时，将退化为O(n²)\n" +
                        "     * 测试方式: 将分布情况设置为近乎有序或高度相等，即可看到快速排序的劣势\n" +
                        "     */\n" +
                        "    private static void quickSort(int[] numbers, int left, int right) {\n" +
                        "        // 递归终止条件\n" +
                        "        if (left >= right) {\n" +
                        "            return;\n" +
                        "        }\n" +
                        "\n" +
                        "        // 标定点划分, 小于放在左边，大于放在右边\n" +
                        "        int p = partition(numbers, left, right);\n" +
                        "        // 标定点已经位于该数组排序后的位置\n" +
                        "        quickSort(numbers, left, p - 1);\n" +
                        "        quickSort(numbers,p + 1, right);\n" +
                        "    }\n" +
                        "\n" +
                        "    private static int partition(int[] numbers, int left, int right) {\n" +
                        "        // 记录标定点\n" +
                        "        int value = numbers[left];\n" +
                        "        int flag = left;\n" +
                        "        for (int i = flag + 1; i <= right; i++) {\n" +
                        "            // 小于标定点时放于左边\n" +
                        "            if (numbers[i] < value) {\n" +
                        "                flag ++;\n" +
                        "                swap(numbers, i, flag);\n" +
                        "            }\n" +
                        "        }\n" +
                        "\n" +
                        "        // 将标定点元素和它应放置的位置交换\n" +
                        "        swap(numbers, left, flag);\n" +
                        "        return flag;\n" +
                        "    }\n" +
                        "    \n" +
                        "    private static void swap(int[] numbers, int i, int j) {\n" +
                        "        int temp = numbers[i];\n" +
                        "        numbers[i] = numbers[j];\n" +
                        "        numbers[j] = temp;\n" +
                        "    }";
            case RANDOM_QUICK_SORT:
                return "/**\n" +
                        "     * 随机快排: 解决快速排序在近乎有序的情况，时间复杂度退化成O(n²)的问题\n" +
                        "     * 时间复杂度: 一般情况为O(nlogn)，当元素全部相等时，将退化为O(n²)\n" +
                        "     * 测试方式: 将分布情况设置为高度相等，即可看到随机快排的劣势\n" +
                        "     */\n" +
                        "    private static void quickSort(int[] numbers, int left, int right) {\n" +
                        "        // 递归终止条件\n" +
                        "        if (left >= right) {\n" +
                        "            return;\n" +
                        "        }\n" +
                        "\n" +
                        "        // 标定点划分, 小于放在左边，大于放在右边\n" +
                        "        int p = partition(numbers, left, right);\n" +
                        "        // 标定点已经位于该数组排序后的位置\n" +
                        "        quickSort(numbers, left, p - 1);\n" +
                        "        quickSort(numbers,p + 1, right);\n" +
                        "    }\n" +
                        "\n" +
                        "    private static int partition(int[] numbers, int left, int right) {\n" +
                        "        // 随机选取标定点\n" +
                        "        int randomFlag = (int) (Math.random() * (right - left + 1)) + left;\n" +
                        "        // 交换该标定点位于数组首部\n" +
                        "        swap(numbers, left, randomFlag);\n" +
                        "\n" +
                        "        // 记录标定点\n" +
                        "        int value = numbers[left];\n" +
                        "        int flag = left;\n" +
                        "        for (int i = flag + 1; i <= right; i++) {\n" +
                        "            // 小于标定点时放于左边\n" +
                        "            if (numbers[i] < value) {\n" +
                        "                flag ++;\n" +
                        "                swap(numbers, i, flag);\n" +
                        "            }\n" +
                        "        }\n" +
                        "\n" +
                        "        // 将标定点元素和它应放置的位置交换\n" +
                        "        swap(numbers, left, flag);\n" +
                        "        return flag;\n" +
                        "    }\n" +
                        "    \n" +
                        "    private static void swap(int[] numbers, int i, int j) {\n" +
                        "        int temp = numbers[i];\n" +
                        "        numbers[i] = numbers[j];\n" +
                        "        numbers[j] = temp;\n" +
                        "    }";
            case TWO_WAY_QUICK_SORT:
                return "/**\n" +
                        "     * 双路快排: 解决快速排序在全部元素相等的情况，时间复杂度退化成O(n²)的问题\n" +
                        "     * 时间复杂度: 基本稳定为O(nlogn)\n" +
                        "     */\n" +
                        "    private static void quickSort(int[] numbers, int left, int right) {\n" +
                        "        // 递归终止条件\n" +
                        "        if (left >= right) {\n" +
                        "            return;\n" +
                        "        }\n" +
                        "\n" +
                        "        // 标定点划分, 小于放在左边，大于放在右边\n" +
                        "        int p = partition(numbers, left, right);\n" +
                        "        // 标定点已经位于该数组排序后的位置\n" +
                        "        quickSort(numbers, left, p - 1);\n" +
                        "        quickSort(numbers,p + 1, right);\n" +
                        "    }\n" +
                        "\n" +
                        "    private static int partition(int[] numbers, int left, int right) {\n" +
                        "        // 随机选取标定点\n" +
                        "        int randomFlag = (int) (Math.random() * (right - left + 1)) + left;\n" +
                        "        // 交换该标定点位于数组首部\n" +
                        "        swap(numbers, left, randomFlag);\n" +
                        "\n" +
                        "        // 记录标定点\n" +
                        "        int value = numbers[left];\n" +
                        "\n" +
                        "        // 索引小于leftIndex的元素小于标定点\n" +
                        "        int leftIndex = left + 1;\n" +
                        "        // 索引大于等于rightIndex的元素大于标定点\n" +
                        "        int rightIndex = right;\n" +
                        "        while (true) {\n" +
                        "            // 找寻下一个大于或等于标定点的值\n" +
                        "            while (leftIndex <= right && numbers[leftIndex] < value) {\n" +
                        "                leftIndex ++;\n" +
                        "            }\n" +
                        "\n" +
                        "            // 找寻下一个小于或等于标定点的值\n" +
                        "            while (rightIndex >= left + 1 && numbers[rightIndex] > value) {\n" +
                        "                rightIndex --;\n" +
                        "            }\n" +
                        "\n" +
                        "            // 循环终止条件\n" +
                        "            if (leftIndex > rightIndex) {\n" +
                        "                break;\n" +
                        "            }\n" +
                        "\n" +
                        "            // 交换找寻到的两个值\n" +
                        "            swap(numbers, leftIndex, rightIndex);\n" +
                        "            leftIndex ++;\n" +
                        "            rightIndex --;\n" +
                        "        }\n" +
                        "\n" +
                        "        // 将标定点元素和它应放置的位置交换\n" +
                        "        swap(numbers, left, rightIndex);\n" +
                        "        return rightIndex;\n" +
                        "    }\n" +
                        "    \n" +
                        "    \n" +
                        "    private static void swap(int[] numbers, int i, int j) {\n" +
                        "        int temp = numbers[i];\n" +
                        "        numbers[i] = numbers[j];\n" +
                        "        numbers[j] = temp;\n" +
                        "    }";
            case THREE_WAY_QUICK_SORT:
                return "/**\n" +
                        "     * 三路快排: 优化双路排序在全部元素相等的情况，时间复杂度进化成O(n)\n" +
                        "     * 时间复杂度: 基本稳定为O(nlogn)，全部元素相等时为O(n)\n" +
                        "     * 测试方式: 分布情况选择高度相等，即可看到三路快排的优势\n" +
                        "     */\n" +
                        "    private static void quickSort(int[] numbers, int left, int right) {\n" +
                        "        // 递归终止条件\n" +
                        "        if (left >= right) {\n" +
                        "            return;\n" +
                        "        }\n" +
                        "\n" +
                        "        // 标定点划分, 小于放在左边，大于放在右边\n" +
                        "        LessAndGreat p = partition(numbers, left, right);\n" +
                        "        // 标定点以及其相等的元素已经位于该数组排序后的位置\n" +
                        "        quickSort(numbers, left, p.less - 1);\n" +
                        "        quickSort(numbers, p.great, right);\n" +
                        "    }\n" +
                        "\n" +
                        "    private static LessAndGreat partition(int[] numbers, int left, int right) {\n" +
                        "        // 随机选取标定点\n" +
                        "        int randomFlag = (int) (Math.random() * (right - left + 1)) + left;\n" +
                        "        // 交换该标定点位于数组首部\n" +
                        "        swap(numbers, left, randomFlag);\n" +
                        "\n" +
                        "        // 记录标定点\n" +
                        "        int value = numbers[left];\n" +
                        "\n" +
                        "        // 索引小于lessThen的元素小于标定点\n" +
                        "        int lessThen = left;\n" +
                        "        // 索引大于或等于greatThen的元素大于标定点\n" +
                        "        int greatThen = right + 1;\n" +
                        "        // 索引大于等于equalThen并且小于greatThen的元素等于标定点\n" +
                        "        int equalThen = left + 1;\n" +
                        "        while (equalThen < greatThen) {\n" +
                        "            // 维护上面三个索引\n" +
                        "            if (numbers[equalThen] < value) {\n" +
                        "                swap(numbers, equalThen, lessThen + 1);\n" +
                        "                equalThen ++;\n" +
                        "                lessThen ++;\n" +
                        "            }\n" +
                        "            else if (numbers[equalThen] > value) {\n" +
                        "                swap(numbers, equalThen, greatThen - 1);\n" +
                        "                greatThen --;\n" +
                        "            }\n" +
                        "            else {\n" +
                        "                equalThen ++;\n" +
                        "            }\n" +
                        "        }\n" +
                        "\n" +
                        "        swap(numbers, left, lessThen);\n" +
                        "        return new LessAndGreat(lessThen, greatThen);\n" +
                        "    }\n" +
                        "\n" +
                        "    private static void swap(int[] numbers, int i, int j) {\n" +
                        "        int temp = numbers[i];\n" +
                        "        numbers[i] = numbers[j];\n" +
                        "        numbers[j] = temp;\n" +
                        "    }\n" +
                        "\n" +
                        "    @AllArgsConstructor\n" +
                        "    private static class LessAndGreat {\n" +
                        "        private final int less, great;\n" +
                        "    }";
            case HEAP_SORT:
                return "/**\n" +
                        "     * 堆排序: 将该数组构造为堆，将堆顶元素放于还没排序数组末尾，然后对堆进行维护\n" +
                        "     * 时间复杂度: 基本稳定为O(nlogn)\n" +
                        "     */\n" +
                        "    private static void heapSort(int[] numbers) {\n" +
                        "        // 将该数组构造为堆\n" +
                        "        for (int i = getParent(numbers.length - 1); i >= 0; i --) {\n" +
                        "            siftDown(numbers, numbers.length, i);\n" +
                        "        }\n" +
                        "\n" +
                        "        // 交换堆顶元素位于还未排序数组末尾\n" +
                        "        for (int i = numbers.length - 1; i > 0; i --) {\n" +
                        "            swap(numbers, 0, i);\n" +
                        "            siftDown(numbers, i, 0);\n" +
                        "        }\n" +
                        "    }\n" +
                        "\n" +
                        "    private static void siftDown(int[] numbers, int size, int index) {\n" +
                        "        if (getLeftChild(index) >= size) {\n" +
                        "            return;\n" +
                        "        }\n" +
                        "\n" +
                        "        int maxIndex = getLeftChild(index);\n" +
                        "        if (getRightChild(index) < size && numbers[getRightChild(index)] > numbers[maxIndex]) {\n" +
                        "            maxIndex = getRightChild(index);\n" +
                        "        }\n" +
                        "\n" +
                        "        if (numbers[maxIndex] <= numbers[index]) {\n" +
                        "            return;\n" +
                        "        }\n" +
                        "\n" +
                        "        swap(numbers, index, maxIndex);\n" +
                        "        siftDown(numbers, size, maxIndex);\n" +
                        "    }\n" +
                        "\n" +
                        "    private static void swap(int[] numbers, int i, int j) {\n" +
                        "        int temp = numbers[i];\n" +
                        "        numbers[i] = numbers[j];\n" +
                        "        numbers[j] = temp;\n" +
                        "    }\n" +
                        "\n" +
                        "    private static int getParent(int index) {\n" +
                        "        return (index - 1) / 2;\n" +
                        "    }\n" +
                        "\n" +
                        "    private static int getLeftChild(int index) {\n" +
                        "        return index * 2 + 1;\n" +
                        "    }\n" +
                        "\n" +
                        "    private static int getRightChild(int index) {\n" +
                        "        return index * 2 + 2;\n" +
                        "    }";
            case SHELL_SORT:
                return "/**\n" +
                        "     * 希尔排序: 将数组分为更小的数组，利用插入排序在近乎有序数组小的优势，进行分组排序\n" +
                        "     * 时间复杂度: O(n^1.3—2)\n" +
                        "     */\n" +
                        "    private static void shellSort(int[] numbers) {\n" +
                        "        // 划分为更小的数组\n" +
                        "        for (int gap = numbers.length / 2; gap > 0; gap = gap / 2) {\n" +
                        "            for (int i = 0; i < gap; i ++) {\n" +
                        "                // 进行快速排序\n" +
                        "                int j = i + gap;\n" +
                        "                while (j < numbers.length) {\n" +
                        "                    if (numbers[j] < numbers[j - gap]) {\n" +
                        "                        int k = j;\n" +
                        "                        int temp = numbers[k];\n" +
                        "                        while (k - gap >= 0 && numbers[k - gap] > temp) {\n" +
                        "                            numbers[k] = numbers[k - gap];\n" +
                        "                            k = k - gap;\n" +
                        "                        }\n" +
                        "                        numbers[k] = temp;\n" +
                        "                    }\n" +
                        "                    j = j + gap;\n" +
                        "                }\n" +
                        "            }\n" +
                        "        }\n" +
                        "    }";
            case COUNTING_SORT:
                return "/**\n" +
                        "     * 计数排序: 遍历数组元素，在每个元素对应的数组索引位置加1，最后根据计数数组排序元素\n" +
                        "     * 时间复杂度: O(n + k) => k为元素大小范围\n" +
                        "     */\n" +
                        "    private static void countingSort(int[] numbers, int range) {\n" +
                        "        int[] count = new int[range + 1];\n" +
                        "\n" +
                        "        for (int number : numbers) {\n" +
                        "            count[number] ++;\n" +
                        "        }\n" +
                        "\n" +
                        "        for (int i = 0, j = 0; i < count.length; i++) {\n" +
                        "            while (count[i] > 0) {\n" +
                        "                numbers[j] = i;\n" +
                        "                j ++;\n" +
                        "                count[i] --;\n" +
                        "            }\n" +
                        "        }\n" +
                        "    }";
            case RADIX_SORT:
                return "/**\n" +
                        "     * 基数排序\n" +
                        "     */\n" +
                        "    private static void radixSort(int[] numbers) {\n" +
                        "        // 创建10个桶存放待排序元素\n" +
                        "        int[][] buckets = new int[10][numbers.length];\n" +
                        "        // 记录每个桶中元素个数\n" +
                        "        int[] count = new int[10];\n" +
                        "        // 待排序数组的最高位\n" +
                        "        int l = 3;\n" +
                        "        for (int i = 0; i < l; i ++) {\n" +
                        "            int pow = (int) Math.pow(10, i);\n" +
                        "            // 放入桶中\n" +
                        "            for (int value : numbers) {\n" +
                        "                int digit = value / pow % 10;\n" +
                        "                buckets[digit][count[digit]] = value;\n" +
                        "                count[digit]++;\n" +
                        "            }\n" +
                        "\n" +
                        "            // 取出桶中元素，放回原数组\n" +
                        "            int index = 0;\n" +
                        "            for (int k = 0; k < buckets.length; k ++) {\n" +
                        "                int j = 0;\n" +
                        "                while (count[k] != 0) {\n" +
                        "                    numbers[index] = buckets[k][j];\n" +
                        "                    j ++;\n" +
                        "                    count[k] --;\n" +
                        "                    index ++;\n" +
                        "                }\n" +
                        "            }\n" +
                        "        }\n" +
                        "    }";
            default:
                return "";
        }
    }
}
