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
            case SELECTION_SORT:
                return "private static void selectionSort(int[] numbers) {\n" +
                        "        for (int i = 0; i < numbers.length; i++) {\n" +
                        "            int minIndex = i;\n" +
                        "            for (int j = i + 1; j < numbers.length; j ++) {\n" +
                        "                if (numbers[j] < numbers[minIndex]) {\n" +
                        "                    minIndex = j;\n" +
                        "                }\n" +
                        "            }\n" +
                        "            int temp = numbers[i];\n" +
                        "            numbers[i] = numbers[minIndex];\n" +
                        "            numbers[minIndex] = temp;\n" +
                        "        }\n" +
                        "    }\n" +
                        "    \n" +
                        "    public static void main(String[] args) {\n" +
                        "        int[] numbers = new int[" + size + "];\n" +
                        "        for (int i = 0; i < " + size + "; i++) {\n" +
                        "            numbers[i] = (int) (Math.random() * 800) + 1;\n" +
                        "        }\n" +
                        "        selectionSort(numbers);\n" +
                        "        System.out.println(Arrays.toString(numbers));\n" +
                        "    }";
            case INSERT_SORT:
                return "private static void insertSort(int[] numbers) {\n" +
                        "        for (int i = 1; i < numbers.length; i++) {\n" +
                        "            int temp = numbers[i];\n" +
                        "            int j = i;\n" +
                        "            while (j > 0 && numbers[j - 1] > temp) {\n" +
                        "                numbers[j] = numbers[j - 1];\n" +
                        "                j --;\n" +
                        "            }\n" +
                        "            numbers[j] = temp;\n" +
                        "        }\n" +
                        "    }\n" +
                        "    \n" +
                        "    public static void main(String[] args) {\n" +
                        "        int[] numbers = new int[" + size + "];\n" +
                        "        for (int i = 0; i < " + size + "; i++) {\n" +
                        "            numbers[i] = (int) (Math.random() * 800) + 1;\n" +
                        "        }\n" +
                        "        insertSort(numbers);\n" +
                        "        System.out.println(Arrays.toString(numbers));\n" +
                        "    }";
            case MERGE_SORT:
                return "private static void mergeSort(int[] numbers, int left, int right) {\n" +
                        "        if (left >= right) {\n" +
                        "            return;\n" +
                        "        }\n" +
                        "\n" +
                        "        int mid = (left + right) / 2;\n" +
                        "        mergeSort(numbers, left, mid);\n" +
                        "        mergeSort(numbers,mid + 1, right);\n" +
                        "        merge(numbers, left, mid, right);\n" +
                        "    }\n" +
                        "\n" +
                        "    private static void merge(int[] numbers, int left, int mid, int right) {\n" +
                        "        int start1 = left;\n" +
                        "        int start2 = mid + 1;\n" +
                        "        int[] tempArr = new int[right - left + 1];\n" +
                        "        int tempI = 0;\n" +
                        "\n" +
                        "        while (start1 <= mid && start2 <= right) {\n" +
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
                        "        while (start1 <= mid) {\n" +
                        "            tempArr[tempI] = numbers[start1];\n" +
                        "            tempI ++;\n" +
                        "            start1 ++;\n" +
                        "        }\n" +
                        "\n" +
                        "        while (start2 <= right) {\n" +
                        "            tempArr[tempI] = numbers[start2];\n" +
                        "            tempI ++;\n" +
                        "            start2 ++;\n" +
                        "        }\n" +
                        "\n" +
                        "        for (int i = 0; i < tempArr.length; i ++) {\n" +
                        "            numbers[i + left] = tempArr[i];\n" +
                        "        }\n" +
                        "    }\n" +
                        "    \n" +
                        "    public static void main(String[] args) {\n" +
                        "        int[] numbers = new int[" + size + "];\n" +
                        "        for (int i = 0; i < " + size + "; i++) {\n" +
                        "            numbers[i] = (int) (Math.random() * 800) + 1;\n" +
                        "        }\n" +
                        "        mergeSort(numbers, 0, numbers.length - 1);\n" +
                        "        System.out.println(Arrays.toString(numbers));\n" +
                        "    }";
            default:
                return "";
        }
    }
}
