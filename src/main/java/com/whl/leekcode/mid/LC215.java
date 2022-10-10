package com.whl.leekcode.mid;

import java.util.Random;

/**
 * 美团2  数组中的第K个最大元素(快速排序和堆排序)
 * @author liaowenhui
 * @date 2022/7/29 16:15
 */
public class LC215 {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        int k = 2;

        //快速排序
        System.out.println(findKthLargest(nums,k));

        //堆排序
        System.out.println(findKthLargest2(nums,k));

    }

    /**
     * 方法一 基于快速排序的选择方法
     * 时间复杂度：O(n)，如上文所述，证明过程可以参考「《算法导论》9.2：期望为线性的选择算法」。
     * 空间复杂度：O(logn)，递归使用栈空间的空间代价的期望为 O(logn)。
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public static int quickSelect(int[] a, int l, int r, int index) {
        int q = randomPartition(a, l, r);
        if (q == index) {
            return a[q];
        } else {
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }

    public static int randomPartition(int[] a, int l, int r) {
        Random random = new Random();

        int i = random.nextInt(r - l + 1) + l;
        swap(a, i, r);
        return partition(a, l, r);
    }

    public static int partition(int[] a, int l, int r) {
        int x = a[r], i = l - 1;
        for (int j = l; j < r; ++j) {
            if (a[j] <= x) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    /**
     * 方法2堆排序
     * 时间复杂度：O(nlogn)，建堆的时间代价是 O(n)，删除的总代价是 O(klogn)，因为 k < n，故渐进时间复杂为 O(n + klogn) =O(nlogn)。
     * 空间复杂度：O(logn)，即递归使用栈空间的空间代价。
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest2(int[] nums, int k) {
        int heapSize = nums.length;

        //构建大顶堆
        for (int i = heapSize / 2; i >= 0; --i) {
            maxHeapify2(nums, i, heapSize);
        }

        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap2(nums, 0, i);
            --heapSize;
            maxHeapify2(nums, 0, heapSize);
        }
        return nums[0];
    }


    public static void maxHeapify2(int[] a, int i, int heapSize) {
        int l = i * 2 + 1, r = i * 2 + 2, largest = i;
        if (l < heapSize && a[l] > a[largest]) {
            largest = l;
        }
        if (r < heapSize && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap2(a, i, largest);
            maxHeapify2(a, largest, heapSize);
        }
    }

    public static void swap2(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }




}
