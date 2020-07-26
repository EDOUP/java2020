package com.edoup.base.sort;

import java.util.Arrays;

/**
 * <p></p>
 *
 * @author edoup
 * @date 2020/7/24 21:22
 */
public class SortBase {

    public static void main(String[] args) {
        SortBase sort = new SortBase();
        //   int[] a = {7, 8, 9, 4, 6, 5, 3, 2, 1};
        int[] a = {2, 9, 7, 6, 5, 8};
        //sort.quickSort(a, 0, a.length - 1);
        // sort.insertSort(a);
        // sort.selectionSort(a);
        //sort.halfInsertSort(a);
        //sort.shellSort(a);
        //sort.mergeSort(a);
        sort.heapSort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 堆排序
     *
     * @param a
     */
    public void heapSort(int[] a) {
        int len = a.length;
        for (int i = len >> 1; i >= 0; i--) {
            createHeap(a, i, len);
        }
        for (int i = len - 1; i > 0; i--) {
            swap(a, 0, i);
            len--;
            createHeap(a, 0, len);
        }
    }

    private void createHeap(int[] a, int i, int len) {
        int j = (i << 1) + 1;
        if (j < len) {
            if (j + 1 < len && a[j + 1] > a[j]) {
                j++;
            }
            if (a[j] > a[i]) {
                swap(a, j, i);
                createHeap(a, j, len);
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 合并排序
     *
     * @param a
     */
    public void mergeSort(int[] a) {
        if (a.length > 1) {
            int[] l = Arrays.copyOfRange(a, 0, a.length >> 1);
            int[] r = Arrays.copyOfRange(a, a.length >> 1, a.length);
            mergeSort(l);
            mergeSort(r);
            merge(a, l, r);
        }

    }

    public void merge(int[] a, int[] l, int[] r) {
        int i = 0, j = 0, k = 0;
        while (i < l.length && j < r.length) {
            if (l[i] <= r[j]) {
                a[k] = l[i];
                i++;
            } else {
                a[k] = r[j];
                j++;
            }
            k++;
        }
        while (i < l.length) {
            a[k++] = l[i++];
        }
        while (j < r.length) {
            a[k++] = r[j++];
        }
    }

    /**
     * 选择排序
     *
     * @param a
     */
    public void selectionSort(int[] a) {
        int minIndex, b;
        for (int i = 0; i < a.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            b = a[i];
            a[i] = a[minIndex];
            a[minIndex] = b;
        }
    }

    /**
     * 快速排序
     *
     * @param a
     * @param left
     * @param right
     */
    public void quickSort(int[] a, int left, int right) {
        int i, j, t, tmp;
        if (left > right) {
            return;
        }

        for (tmp = a[left], i = left, j = right; i != j && i < j; ) {
            while (a[j] >= tmp && i < j) {
                j--;
            }
            while (a[i] <= tmp && i < j) {
                i++;
            }
            if (i < j) {
                swap(a, i, j);
            }
        }
        a[left] = a[i];
        a[i] = tmp;
        quickSort(a, left, i - 1);
        quickSort(a, i + 1, right);
    }

    /**
     * 插入排序
     *
     * @param a
     */
    public void insertSort(int[] a) {
        int b;
        for (int i = 0; i < a.length - 1; i++) {
            b = a[i + 1];
            int j = i;
            while (j >= 0 && a[j] > b) {
                a[j + 1] = a[j--];
            }
            a[++j] = b;
        }
    }

    /**
     * 半插入排序
     *
     * @param array
     */
    public void halfInsertSort(int[] array) {
        int temp, low, high, mid;
        for (int i = 0; i < array.length - 1; i++) {
            temp = array[i + 1];
            low = 0;
            high = i;
            while (low <= high) {
                mid = (low + high) >> 1;
                if (temp < array[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            for (int j = i; j >= low; j--) {
                array[j + 1] = array[j];
            }
            array[low] = temp;
        }
    }

    /**
     * 希尔排序 插入排序优化
     *
     * @param a
     */
    public void shellSort(int[] a) {
        int gap = 1;
        while (gap < a.length) {
            gap = gap * 3 + 1;
        }

        while (gap > 0) {
            for (int i = gap; i < a.length; i++) {
                int tmp = a[i];
                int j = i - gap;
                while (j >= 0 && a[j] > tmp) {
                    a[j + gap] = a[j];
                    j -= gap;
                }
                a[j + gap] = tmp;
            }
            gap = (int) Math.floor(gap / 3);
        }
    }

}
