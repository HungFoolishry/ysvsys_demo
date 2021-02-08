package lee.linkedlist;

/**
 * 反转链表一部分
 * Definition for singly-linked list.
 * 1->2->3->4->5->NULL, m = 2, n = 4
 */


public class ListReverseBetween {

    ListNode successor;
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }
        // 开头的最后一个节点要接上反转后的最后一个节点
        head.next = reverseBetween(head.next, m - 1, n-1);
        return head;
    }

    private ListNode reverseN(ListNode node, int n) {
        if (n == 1) {
            successor = node.next;
            //返回的是后一个节点
            return node;
        }
        ListNode last = reverseN(node.next, n - 1);
        node.next.next = node;
        node.next = successor;
        return last;
    }
}
