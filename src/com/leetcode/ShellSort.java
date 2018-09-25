package com.leetcode;

public class ShellSort {
    public void shellSort(int[] array, int n) {
        int i, j, gap;
        int temp;
        for (gap = n / 2; gap > 0; gap /= 2) {// 计算gap大小
            for (i = gap; i < n; i++) {// 将数据进行分组
                for (j = i - gap; j >= 0 && array[j] > array[j + gap]; j -= gap) {// 对每组数据进行插入排序
                    temp = array[j];
                    array[j] = array[j + gap];
                    array[j + gap] = temp;
                }
                // 打印每趟排序结果
                for (int m = 0; m <= array.length - 1; m++) {
                    System.out.print(array[m] + "\t");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        int[] array = {4,1,5,2,7,3,6,8};
        shellSort.shellSort(array, array.length);// 注意为数组的个数
        for (int m = 0; m <= array.length - 1; m++) {
            System.out.print(array[m] + "\t");
        }
    }
}
