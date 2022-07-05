package com.whl.leekcode.easy.LeekCode141;

import com.whl.leekcode.common.ListNode;

/**
 * https://leetcode.cn/problems/linked-list-cycle/solution/huan-xing-lian-biao-by-leetcode-solution/
 * 龟兔赛跑算法
 * @author liaowenhui
 * @date 2022/7/4 10:24
 */
public class methos2 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}
