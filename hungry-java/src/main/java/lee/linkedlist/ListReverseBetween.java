package lee.linkedlist;

/**
 * Definition for singly-linked list.
 * 1->2->3->4->5->NULL, m = 2, n = 4
 */


public class ListReverseBetween {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode preNode = null;
        ListNode cur = head;
        ListNode mNode = null;
        ListNode mPre = null;
        ListNode result = null;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                result = cur;
            }
            if (i == m - 1 && m - 1 >= 1) {
                mPre = cur;
            }
            if (i == m) {
                mNode = cur;
            }
            if (i == n) {
                mNode.next = cur.next;
                cur.next = preNode;
                if (mPre != null) {
                    mPre.next = cur;
                }
                break;
            }
            if (i < m) {
                cur = cur.next;
                continue;
            }

            ListNode tmp = cur.next;
            cur.next = preNode;
            preNode = cur;
            cur = tmp;

        }
        return result;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        System.out.println(head.val);
        ListNode nowNode = head;
        for (int i = 2; i < 6; i++) {
            nowNode.next = new ListNode(i);
            nowNode = nowNode.next;
            System.out.println(nowNode.val);
        }

        nowNode = reverseBetween(head, 2, 4);
        while (nowNode != null) {
            System.out.println(nowNode.val);
            nowNode = nowNode.next;
        }
    }
    class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {

            // Empty list
            if (head == null) {
                return null;
            }

            // Move the two pointers until they reach the proper starting point
            // in the list.
            ListNode cur = head, prev = null;
            while (m > 1) {
                prev = cur;
                cur = cur.next;
                m--;
                n--;
            }

            // The two pointers that will fix the final connections.
            ListNode con = prev, tail = cur;

            // Iteratively reverse the nodes until n becomes 0.
            ListNode third = null;
            while (n > 0) {
                third = cur.next;
                cur.next = prev;
                prev = cur;
                cur = third;
                n--;
            }

            // Adjust the final connections as explained in the algorithm
            if (con != null) {
                con.next = prev;
            } else {
                head = prev;
            }

            tail.next = cur;
            return head;
        }
    }

}
