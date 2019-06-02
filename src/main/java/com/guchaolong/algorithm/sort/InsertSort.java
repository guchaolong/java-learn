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
 * Description: 插入排序
 *
 * @author guchaolong
 * @date 2019/6/1 20:51
 */
public class InsertSort {
    /**
     * 直接插入排序
     */
    public static void px(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                int temp = a[i];
                int j;
                for (j = i - 1; j >= 0 && a[j] > temp; j--) {
                    a[j + 1] = a[j];
                }
                a[j + 1] = temp;
            }
        }
    }
}