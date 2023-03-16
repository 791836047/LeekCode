package com.whl.leekcode.easy;

/**
 * 383. 赎金信  阿里面试题
 * @author liaowenhui
 * @date 2022/6/27 17:08
 */
public class LeekCode383 {

    /**
     * 判断 ransomNote 能不能由 magazine 里面的字符构成。magazine 中的每个字符只能在 ransomNote 中使用一次。
     * 时间复杂度：O(m+n)，其中 m是字符串 ransomNote 的长度，n 是字符串 magazine 的长度，我们只需要遍历两个字符一次即可。
     * 空间复杂度：O(∣S∣)，S是字符集，这道题中 S为全部小写英语字母，因此 ∣S∣=26
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            cnt[c - 'a']--;
            if(cnt[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean canConstructTest(String ransomNote, String magazine) {
        if (ransomNote.length() < magazine.length()){
            return false;
        }

        char[] chars = ransomNote.toCharArray();
        for (char aChar : chars) {

        }

        return true;

    }


    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "aba"));
    }

}
