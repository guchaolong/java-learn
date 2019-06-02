/**
 * <p>
 * For more information about , welcome to http://www.guchaolong.com
 * <p>
 * project: Algorithm
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2019/6/1 1.0          guchaolong          Creation File
 */
package com.guchaolong.algorithm.sort;

/**
 * Description: 交换排序 包括冒泡和快速排序
 *
 * @author guchaolong
 * @date 2019/6/1 20:47
 */
public class SwapSort {
    /**
     *冒泡排序
     */
    public static void bubbleSort(int[] arr) {
        if(arr == null || arr.length == 0)
            return ;
        for(int i=0;i<arr.length-1;i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[i]>arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 快速排序
     */
    public static void quickSort(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位  10,7,2,4,7,62,3,4,2,1,8,9,19
        temp = arr[low];
        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, high);
    }
}