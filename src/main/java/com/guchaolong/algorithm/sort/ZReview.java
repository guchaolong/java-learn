package com.guchaolong.algorithm.sort;

/**
 * Description:
 *
 * @author GUCHAOLONG
 * @date 2021/3/28 18:22
 */
public class ZReview {
    public static void main(String[] args) {

        System.out.println("----------------冒泡---------------");
        int[] ints = generateRandomArray(20, 9);
        printArray(ints);
        bubble(ints);
        printArray(ints);

        System.out.println("----------------选择---------------");
        int[] ints1 = generateRandomArray(20, 9);
        printArray(ints1);
        select(ints1);
        printArray(ints1);

        System.out.println("----------------快速---------------");
        int[] ints2 = generateRandomArray(20, 9);
        printArray(ints2);
        select(ints2);
        printArray(ints2);


        System.out.println("----------------插入---------------");
        int[] ints3 = generateRandomArray(20, 9);
        printArray(ints3);
        select(ints3);
        printArray(ints3);

        System.out.println("----------------归并---------------");
        int[] ints4 = generateRandomArray(20, 9);
        printArray(ints4);
        select(ints4);
        printArray(ints4);



    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    /**
     * 冒泡
     * @param arr
     */
    public static void bubble(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 选择排序
     * @param arr
     */
    public static void select(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for (int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++){
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    /**
     * 快速排序
     * @param arr
     * @param low
     * @param high
     */
    public static void quick(int[] arr, int low, int high){
        if(arr == null || low > high){
            return;
        }
        int L = low, R = high, temp = arr[low];
        while (L < R){
            while (arr[R] >= temp && L < R){
                R--;
            }
            while (arr[L] <= temp && L < R){
                L++;
            }
            if(L < R){
                swap(arr, L, R);
            }
        }
        arr[low] = arr[L];
        arr[L] = temp;
        quick(arr, low, L - 1);
        quick(arr, L + 1, high);

    }

    /**
     * 插入排序
     * @param arr
     */
    public static void insert(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for (int i = 1; i < arr.length; i++){
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--){
                swap(arr, j, j + 1);
            }
        }
    }

    /**
     * 归并排序
     * @param arr
     */
    public static void mergeSort(int [] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        mergeSort(arr, 0, arr.length - 1);

    }

    public static void mergeSort(int [] arr, int left, int right){
        if(left == right){
            return;
        }
        int mid = left + (right - left) >> 1;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int []arr, int left, int mid, int right){
        int[] help = new int[right - left + 1];
        int idx = 0;
        int i = 0;
        int j = mid + 1;
        while (i <= mid && j <= right){
            help[idx++] = arr[i] > arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid){
            help[idx++] = arr[i++];
        }
        while (j <= right){
            help[idx++] = arr[j++];
        }
        for (int k = 0; k < help.length; k++) {
            arr[left + k] = help[k];
        }
    }
}
