package com.whl.leekcode.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 * @author 79183
 * @date 2024/8/22 9:56
 */
public class HOT56 {

    public static void main(String[] args) {
        int[][] intervals ={{2,6},{1,3},{8,10},{15,18}};
        int[][] merge = merge(intervals);
        System.out.println(Arrays.deepToString(merge));
    }




    /**
     * 输入：  [[1,3],[2,6],[8,10],[15,18]]
     * 输出：  [[1,6],[8,10],[15,18]]
     *
     * 空间复杂度：O(logn)，其中 n 为区间的数量。这里计算的是存储答案之外，使用的额外空间。O(logn) 即为排序所需要的空间复杂度。
     * 时间复杂度：O(nlogn)，其中 n 为区间的数量。除去排序的开销，我们只需要一次线性扫描，所以主要的时间开销是排序的 O(nlogn)。
     */
    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; ++i) {
            // 初始值L =1 ,  R  =3
            int L = intervals[i][0], R = intervals[i][1];
            //按[]第一位排序后，如果[]右边的值小于次序的[]的左边的值，则说明可以合并
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }


}
