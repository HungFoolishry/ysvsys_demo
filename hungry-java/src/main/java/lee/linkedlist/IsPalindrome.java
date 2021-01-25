package lee.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * description:  是否是回文链表
 *
 * @author JunchaoYao
 * @date 2021-01-23 23:31
 **/
public class IsPalindrome {
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    class Solution {
        public boolean isPalindrome(ListNode head) {
            return reverse(head);

        }

        ListNode left;
        public boolean reverse(ListNode head) {
            if (head == null) {
                return true;
            }
            boolean ans = reverse(head.next);
            if (!ans) {
                return false;
            }
            if (left.val != head.val) {
                return false;
            }
            left = left.next;
            return true;
        }
    }
}
