package com.whl.leekcode.easy.LeekCode141;

import com.whl.leekcode.common.ListNode;

/**
 * https://leetcode.cn/problems/linked-list-cycle/solution/huan-xing-lian-biao-by-leetcode-solution/
 * 龟兔赛跑算法
 * @author liaowenhui
 * @date 2022/7/4 10:24
 */
public class methos2 {
    /**
     * 时间复杂度：O(N)，其中 N是链表中的节点数。
     * 当链表中不存在环时，快指针将先于慢指针到达链表尾部，链表中每个节点至多被访问两次。
     * 当链表中存在环时，每一轮移动后，快慢指针的距离将减小一。而初始距离为环的长度，因此至多移动 N轮。
     * 空间复杂度：O(1)。我们只使用了两个指针的额外空间。

     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            //快指针会先到达尽头（指向null或者null的下一个节点
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * TEST
     * @param head
     * @return
     */
    public boolean testHasCycle(ListNode head) {
        if (null == head || null == head.next){
            return false;
        }

        ListNode leftPonit = head;
        ListNode rightPoint = head.next;
        while (leftPonit != rightPoint){
            leftPonit = leftPonit.next;
            rightPoint = rightPoint.next.next;
        }

        return true;
    }

}
