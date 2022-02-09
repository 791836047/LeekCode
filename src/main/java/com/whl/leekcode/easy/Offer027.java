package com.whl.leekcode.easy;

import com.whl.leekcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 027. 回文链表
 * @author liaowenhui
 * @date 2022/2/8 9:59
 */
public class Offer027 {
    public static void main(String[] args) {
        //初始化 123321链表
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        boolean palindrome = isPalindrome(head);
        boolean palindrome2 = isPalindrome2(head);
        boolean palindrome3 = isPalindrome3(head);
        System.out.println("123321链表是否为回文链表：" + palindrome + " " + palindrome2 + " " + palindrome3);
    }

    /**
     * 将值复制到数组中后用双指针法
     * 时间复杂度和空间复杂度都为O(n)
     * 复杂度分析
     * （1）时间复杂度：O(n)，其中 n指的是链表的元素个数。
     * 第一步： 遍历链表并将值复制到数组中，O(n)。
     * 第二步：双指针判断是否为回文，执行了 O(n/2) 次的判断，即 O(n)。
     * 总的时间复杂度：O(2n)=O(n)。
     * （2）空间复杂度：O(n)，其中 n 指的是链表的元素个数，我们使用了一个数组列表存放链表的元素值。
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<>();

        // 将链表的值复制到数组中
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.date);
            currentNode = currentNode.next;
        }

        // 使用双指针判断是否回文
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }


    public static ListNode frontPointer;


    private static boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.date != frontPointer.date) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }

    /**
     * 方法2 递归 不建议比第一种方法性能更差
     * 时间复杂度：O(n)，其中 n指的是链表的大小。
     * 空间复杂度：O(n)
     * @param
     * @return
     */
    public static boolean isPalindrome2(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }


    /**
     * 方法3快慢指针
     * @param head
     * @return
     */
    public static boolean isPalindrome3(ListNode head) {
        if (head == null) {
            return true;
        }

        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.date != p2.date) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 还原链表并返回结果
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    /**
     * 反转链表 通过迭代的方法
     * 假设链表为 1->2->3->null,我们想要把它改成null<-1<-2<-3
     * 在遍历链表时，将当前节点的next 指针改为指向前一个节点。由于节点没有引用其前一个节点，因此必须事先存储其前一个节点。在更改引用之前，还需要存储后一个节点。最后返回新的头引用。
     *
     * 时间复杂度：O(n)，其中 n 是链表的长度。需要遍历链表一次。
     * 空间复杂度：O(1)。
     * @param head
     * @return
     */
    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private static ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
