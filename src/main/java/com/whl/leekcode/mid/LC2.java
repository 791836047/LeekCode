package com.whl.leekcode.mid;

import com.whl.leekcode.common.ListNode;

/**
 * @author liaowenhui
 * @date 2023/7/31 8:50
 */
public class LC2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(3);
        l1.setNext(l3);
        l3.setNext(l4);

        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l24 = new ListNode(4);
        l5.setNext(l6);
        l6.setNext(l24);

        LC2 lc2 = new LC2();
        ListNode listNode = lc2.addTwoNumbersTest(l1, l5);

        while (null != listNode) {
            System.out.print(listNode.getDate() + " ");
            listNode = listNode.getNext();
        }

    }

    /**
     * 非官方 热度最高
     * 时间复杂度：O(max(m,n))，其中 m 和 n分别为两个链表的长度。我们要遍历两个链表的全部位置，而处理每个位置只需要 O(1) 的时间。
     * 空间复杂度：O(1)。注意返回值不计入空间复杂度。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.date;
            int y = l2 == null ? 0 : l2.date;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        //最后一位如果相加进位则需要加多一个节点
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }

    /**
     * 自写 60%
     * 命名能力欠缺，可用x，y
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbersTest(ListNode l1, ListNode l2) {
        ListNode pre =  new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while(l1 != null || l2 != null){
            int x = l1 == null? 0: l1.date;
            int y = l2 == null? 0: l2.date;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;

            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }


        }
        if(carry == 1){
            cur.next = new ListNode(carry);
        }

        return pre.next;

    }


}
