/**
 * <p>
 * For more information about , welcome to http://www.guchaolong.com
 * <p>
 * project: java-learn
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2019/6/6 1.0          guchaolong          Creation File
 */
package com.guchaolong.algorithm.sort;

import java.util.Arrays;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2019/6/6 13:16
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] a = {1, 2, 7, 10, 5, 3, 9, 4, 12, 6};
        selectionSort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 直接选择排序
     * <p>
     * 时间复杂度O(n2)
     * 空间复杂度O(1)
     * 不稳定排序
     * 比较次数与序列初始化状态无关
     */

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            //当前最小的位置，起初为i
            int minIndex = i;
            //往后找，是否有比i处小的，有则更新minIndex
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    /**
     * 堆排序
     */
    public static void heapSort(int[] arr) {
        //构造大根堆
        int n = arr.length;
        while (n > 1) {
            buildBigHeap(arr, n);
            //固定最大值
            swap(arr, 0, n - 1);
            n--;
            //构造大根堆
            buildBigHeap(arr, n);
        }

    }

    //构造大根堆,完成之后能保证arr[0]位置的是最大的
    public static void buildBigHeap(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            //当前插入的索引i,父结点索引
            int f = (i - 1) / 2;
            //如果当前插入的值大于其父结点的值,则交换值，并且将索引指向父结点
            //然后继续和上面的父结点值比较，直到不大于父结点，则退出循环
            while (arr[i] > arr[f]) {
                swap(arr, i, f);//交换当前结点与父结点的值
                i = f;//将当前索引指向父索引
                f = (i - 1) / 2;//重新计算当前索引的父索引
            }
        }
    }

    //交换数组中两个元素的值
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}