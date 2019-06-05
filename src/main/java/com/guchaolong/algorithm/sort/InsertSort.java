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

import java.util.Arrays;

/**
 * Description: 插入排序
 *
 * @author guchaolong
 * @date 2019/6/1 20:51
 */
public class InsertSort {
    /**
     * 直接插入排序
     *
     * 原理：把一个数插卡入到一个已经排好序的数组中，找到相应的位置插入
     *
     * 可以把数组的第一个元素当作一个已经排好序的数组
     *
     * 从第二个（i=1)开始，把要插入的元素提出来作为temp,依次和前面的元素（j)对比 如果比temp大，就往后移动一个
     * 最后把temp填到j位置
     *
     * O（n²）是稳定的排序方法
     */
    public static void px(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                //将大于temp的数向后移动一步 a[0-j]是已经排序的，越往左越小
                if (a[j] > temp) {
                    a[j + 1] = a[j];//记录j处就是temp要插入的位置，因为会做一次j--,所以循环外要j+1
                } else {
                    break;
                }
            }
            a[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 4, 9, 5, 3};
        px(a);
        System.out.println(Arrays.toString(a));
    }
}