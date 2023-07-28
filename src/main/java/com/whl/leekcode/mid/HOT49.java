package com.whl.leekcode.mid;

import java.util.*;

/**
 * 字母异位词分组
 * @author liaowenhui
 * @date 2023/4/11 9:27
 */
public class HOT49 {

    /**
     * 时间复杂度：O(nklogk)，其中 n 是 strs 中的字符串的数量，k 是 strs 中的字符串的的最大长度。需要遍历 n个字符串，对于每个字符串，需要 O(klogk) 的时间进行排序以及 O(1)的时间更新哈希表，因此总时间复杂度是O(nklogk)。
     * 空间复杂度：O(nk)，其中 n 是 strs 中的字符串的数量，k 是 strs 中的字符串的的最大长度。需要用哈希表存储全部字符串。
     *  Java中Arrays.sort()的时间复杂度可以达到O(n*log(n))，其中n为排序元素个数，是经过调优的排序算法。具体来说，Arrays.sort()使用了两种排序方法：快速排序和优化的归并排序。
     *  当数组长度小于60时，它会直接进行插入排序；
     *  当长度大于60时，有可能会merge排序或者是quick排序，merge和quick会将整个数组进行划分，进行递归，一旦划分的子数组长度小于60时，将不再递归划分，直接进行插入排序。
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        //!!注意可以for   数组只有长度strs.length 集合才有.size()
        for (String str : strs) {
            //!!注意toCharArray()
            char[] array = str.toCharArray();
            //!! 注意Arrays.sort()
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        //!!注意map.values()返回的格式
        return new ArrayList<List<String>>(map.values());
    }

/*    public List<List<String>> groupAnagramsTest(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        Long size = strs.size();
        for(int i = 0; i < size; i++){
            //char[] array = str.toCharArray();
            String[] toChar =  strs[i].toChar();
            String key = new string(toChar.sort);
            List<String> list =  MAP.getOrDefault(res.get(key),new ArrayList());
            list.add(strs[i]);
            map.put(key,list);
        }
        return map.values;
    }*/

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        System.out.println(lists.toString());
    }
}
