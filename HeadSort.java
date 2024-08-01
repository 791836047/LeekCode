package com.whl.leekcode.sort;

import java.util.Arrays;

/**
 * bigo，腾讯
 * 堆必须同时具备两个特性：1、结构性(完全二叉树的特点)；2）堆序性。
 * 结构性:堆是一棵完全二叉树，所谓完全二叉树的特点：叶子结点只能出现在最下层和次下层，且最下层的叶子结点集中在树的左部。
 * 堆序性:分为大根堆和小根堆， 说得通俗一点儿就是，父节点中的元素不小于（不大于）任意子节点的元素。好比在大根堆中，一个节点的元素在其子树所有元素组成的集合中必定是最大值。
 *
 * 实现堆排序：
 * 1）根据无序数组创建一个大根堆；
 * 2）通过循环，自上而下，自左向右进行调整大根堆使其到达有序(大根堆的根元素必然是整个堆中的最大值，将根节点元素与最后一个叶子节点的元素交换位置，再进行元素下沉)。
 *  http://www.360doc.com/content/20/1106/11/5315_944403906.shtml
 *  https://www.jianshu.com/p/938789fde325
 *  https://www.cnblogs.com/chengxiao/p/6129630.html
 * @author liaowenhui
 * @date 2022/1/1 17:16
 */
public class HeadSort {

    public static void main(String[] args) {
        int[] arr = {4, 5, 3, 2, 6, 1, 5};
        heapSort(arr);
        System.out.println("排序后结果为：" + Arrays.toString(arr));

    }

    public static void heapSort(int[] arr) {
        int n = arr.length;
        /**
         * 若一根完全二叉树有n个节点，则n-1为最后一个叶子节点的下标，而完全二叉树中数组下标为i的左孩子结点的下标为l = 2*i + 1,
         * 即n-1 = 2*i +1，得i = (n-2)/2,于是二叉树的最后一个非叶子节点的下标就为(n-2)/2
         */
        //创建大根堆(根节点元素是最大)，这里元素的索引是从0开始的,所以最后一个非叶子结点的数组下标为array.length/2 - 1
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        //调整大根堆,目的只有一个：将较大元素调整至末尾处！
        for (int j = n - 1; j > 0; j--) {
            //首位交换，交换堆的根结点(最大元素)与当前最后一个元素(i)
            int temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;

            //堆化操作，自上而下，自左向右进行调整的
            //元素交换之后，毫无疑问，最后一个元素无需再考虑排序问题了。在去掉最后一个元素的堆上进行堆化操作,这也是为什么此方法放在循环里的原因
            heapify(arr, j, 0);
        }
    }

    /**
     * 堆化操作
     * @param arr 数组
     * @param n 数组长度
     * @param i 父节点数组下标
     */
    static void heapify(int[] arr, int n, int i) {
        // 初始化最大元素的数组下标
        int largest = i;
        // 数组下标为i的左孩子结点的下标为l = 2*i + 1
        int l = 2 * i + 1;
        // 数组下标为i 的右孩子结点的下表为r = 2*i + 2
        int r = 2 * i + 2;

        // 如果左孩子结点比父结点大，更新largest为左孩子下标
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        // 如果右孩子比最大元素大，更新largest为右孩子下标
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        // 如果最大元素不是根结点，进行交换操作并递归调用Heapify
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            //对由于交换操作受到影响的子树递归调用Heapify
            heapify(arr, n, largest);
        }
    }
}
