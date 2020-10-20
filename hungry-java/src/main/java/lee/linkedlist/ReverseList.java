package lee.linkedlist;

import java.util.List;
import java.util.Stack;

/**
 * description: 反转链表
 *
 * @author JunchaoYao
 * @date 2020-10-16 16:11
 **/
public class ReverseList {

    class Solution {
        public class ListNode {
            int val;
            ListNode next;
            ListNode(int x) { val = x; }
        }
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode tmpNode = head;
            ListNode pre = null;
            while (tmpNode.next != null) {
                ListNode nextNode = tmpNode.next;
                tmpNode.next = pre;
                pre = tmpNode;
                tmpNode = nextNode;
            }
            tmpNode.next = pre;
            return tmpNode;

        }
    }
}
