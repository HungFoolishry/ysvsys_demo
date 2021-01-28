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

    class Solution {
        ListNode left;
        public boolean isPalindrome(ListNode head) {
            left = head;
            return reverse(head);

        }

        public boolean reverse(ListNode head) {
            if (head == null) {
                return true;
            }
            if (!reverse(head.next)) {
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
