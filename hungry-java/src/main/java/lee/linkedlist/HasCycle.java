package lee.linkedlist;

/**
 * description: 判断链表是否有环
 *
 * @author JunchaoYao
 * @date 2021-01-27 17:21
 **/
public class HasCycle {
    public class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode a = head;
            ListNode b = head;
            while (a != null && b != null) {
                if (a.next != null) {
                    a = a.next.next;
                } else {
                    return false;
                }
                b = b.next;
                if (a == b) {
                    return true;
                }
            }
            return false;

        }
    }
//    public class Solution {
//        public boolean hasCycle(ListNode head) {
//            if (head == null || head.next == null) {
//                return false;
//            }
//            ListNode slow = head;
//            ListNode fast = head.next;
//            while (slow != fast) {
//                if (fast == null || fast.next == null) {
//                    return false;
//                }
//                slow = slow.next;
//                fast = fast.next.next;
//            }
//            return true;
//        }
//    }


}
