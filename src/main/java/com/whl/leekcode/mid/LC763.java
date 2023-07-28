package com.whl.leekcode.mid;/**
 * @author liaowenhui
 * @date 2023/2/22 9:22
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 划分字母区间
 * 字节出现2次
 * @author liaowenhui
 * @date 2023/2/22 9:22
 */
public class LC763 {
    public static void main(String[] args) {
        List<Integer> result = partitionLabelsTest("ababcbacadefegdehijhklij");
        System.out.println(result);
    }

    /**
     * 贪心算法
     * 由于同一个字母只能出现在同一个片段，显然同一个字母的第一次出现的下标位置和最后一次出现的下标位置必须出现在同一个片段
     *
     * @param s
     * @return
     */
    public static List<Integer> partitionLabels(String s) {
        //last数组存储每个字母最后一次出现的下标位置
        int[] last = new int[26];
        int length = s.length();
        //遍历字符串，得到每个字母最后一次出现的下标位置。
        for (int i = 0; i < length; i++) {
            //好比last[0] = 8 a的最后一次出现的下标位置为8   last[1] = 5，b
            //'a' 代表字符a的ASCII码值 97
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<>();
        //从左到右遍历字符串，遍历的同时维护当前片段的开始下标 start 和结束下标 end，初始时 start=end=0。
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            //对于每个访问到的字母 c，得到当前字母的最后一次出现的下标位置 endc,则当前片段的结束下标一定不会小于endc，因此令end = max(end，endc)
            end = Math.max(end, last[s.charAt(i) - 'a']);
            //当访问到下标 end时，当前片段访问结束
            if (i == end) {
                //！！长度为 end−start+1
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }


    public static List<Integer> partitionLabelsTest(String s) {
        //!!length是int类型，不是String
        int length =  s.length();
        int[] last = new int[26];
        for(int i=0; i<length; i++){
            //!!注意charAt不是chatAt
            last[s.charAt(i) - 'a'] = i;
        }

        List<Integer> patition = new ArrayList();
        //!!注意看这行怎么写，不能写成int start,end = 0;
        int start = 0,end = 0;
        for(int i= 0; i<length; i++){
            end = Math.max(end,last[s.charAt(i) - 'a']);

            if(i == end){
                patition.add(end - start +1);
                start = end + 1;
            }
        }

        return patition;
    }
}
