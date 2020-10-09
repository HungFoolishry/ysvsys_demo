package lee.linkedlist;

/**
 * Definition for singly-linked list.
 * 1->2->3->4->5->NULL, m = 2, n = 4
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class ListReverseBetween {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode tmpCur = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = tmpCur;
            tmpCur = cur;
            cur = next;
        }
        return tmpCur;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode nowNode = head;
        for (int i = 2; i < 6; i++) {
            nowNode.next = new ListNode(i);
            nowNode = nowNode.next;
        }

        nowNode = reverseBetween(head, 2, 4);
        while (nowNode != null) {
            System.out.println(nowNode.val);
            nowNode = nowNode.next;
        }
    }
}
