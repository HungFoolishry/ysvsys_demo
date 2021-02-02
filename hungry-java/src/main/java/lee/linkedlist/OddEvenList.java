package lee.linkedlist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description: 奇偶链表
 *
 * @author JunchaoYao
 * @date 2021-01-28 19:12
 **/
public class OddEvenList {
    static class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode odd = head;
            ListNode even = head.next;
            ListNode evenHead = head.next;
            while (even != null && even.next != null) {
                odd.next = even.next;
                odd = even.next;
                even.next = odd.next;
                even = odd.next;
            }
            odd.next = null;
            evenHead = reverseList(evenHead);
            return merge(head, evenHead);
        }

        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            if (head.next == null) {
                return head;
            }
            ListNode last = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return last;
        }

        public ListNode merge(ListNode node1, ListNode node2) {
            if (node1 == null) {
                return node2;
            }
            if (node2 == null) {
                return node1;
            }
            if (node1.val < node2.val) {
                node1.next = merge(node1.next, node2);
                return node1;
            } else {
                node2.next = merge(node1, node2.next);
                return node2;
            }
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(2);
        ListNode node9 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        Solution solution = new Solution();
        solution.oddEvenList(node1);
        ListNode tmp = node1;
        while (tmp != null) {
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
   }
}
