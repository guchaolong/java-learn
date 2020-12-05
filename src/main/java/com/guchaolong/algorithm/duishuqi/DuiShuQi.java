package com.guchaolong.algorithm.duishuqi;

/**
 * Description:
 *
 * @author GUCHAOLONG
 * @date 2020/12/5 15:42
 */
public class DuiShuQi {
    public static void main(String[] args) {
        System.out.println(Math.random());
        System.out.println(Math.random());
        System.out.println(Math.random());
        System.out.println("============");
        System.out.println(100 * Math.random());
        System.out.println(55 * Math.random());
        System.out.println(66 * Math.random());
        System.out.println("============");
        System.out.println((int)(100 * Math.random()));
        System.out.println((int)(55 * Math.random()));
        System.out.println((int)(66 * Math.random()));
        System.out.println("============");

        for (int i : generateRandomArray(10, 9)) {
            System.out.print(i + ",");
        }
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        /**
         * Math.random()  大于等于 0.0 且小于 1.0 的伪随机 double 值  [0.0  1.0)
         * n * Math.random()    [0, n)
         * (int) n * Math.random()   [0, n-1]
         */

        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }
}
