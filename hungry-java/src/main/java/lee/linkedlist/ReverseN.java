package lee.linkedlist;

/**
 * description: 反转前N节点
 *
 * @author JunchaoYao
 * @date 2021-01-21 20:28
 **/
public class ReverseN {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    ListNode finalNode;
    public ListNode reverseN(ListNode head, int n) {
        if (n ==1) {
            finalNode = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n-1);
        // head.next = 后一个节点的指针 ---> head ，完成反转
        head.next.next = head;
        head.next = finalNode;
        return last;
    }

}
