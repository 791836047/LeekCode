package com.whl.leekcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liaowenhui
 * @date 2023/7/17 8:56
 */
public class LC118 {

    public static void main(String[] args) {
        LC118 lc118 = new LC118();
        List<List<Integer>> generate = lc118.generate(5);
        System.out.println("result:" + generate);
    }


    /**
     * 数学  推荐
     * 时间复杂度：O(numRows^2)
     * 空间复杂度：O(1)。不考虑返回值的空间占用。
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }

    /**
     * 自写100%
     * arr取名为row比较好
     * @param numRows
     * @return
     */
    public List<List<Integer>> generateTest(int numRows) {

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> arr = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                //两边都是1
                if (j == 0 || j == i ) {
                    arr.add(1);
                } else {
                    //i2 ,j1
                    arr.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(arr);
        }
        return res;
    }


}
