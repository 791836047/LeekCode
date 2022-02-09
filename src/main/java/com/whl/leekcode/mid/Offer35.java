package com.whl.leekcode.mid;

import com.whl.leekcode.common.Node;

import java.util.HashMap;
import java.util.Map;

/**
 *  不理解 Offer 35. 复杂链表的复制
 * @author liaowenhui
 * @date 2022/2/9 14:47
 */
public class Offer35 {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        head.setNext(node1);
        node1.setNext(node2);

        Node newHead = copyRandomList(head);

        //打印
        while (null != newHead) {
            System.out.print(newHead.val + " ");
            newHead = newHead.getNext();
        }
    }

    static Map<Node, Node> cachedNode = new HashMap<>();

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }


}
