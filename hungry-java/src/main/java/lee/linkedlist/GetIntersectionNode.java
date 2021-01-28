package lee.linkedlist;

import java.util.HashSet;

/**
 * description: 获取两个节点的相交点
 *
 * @author JunchaoYao
 * @date 2021-01-27 20:17
 **/
public class GetIntersectionNode {
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            ListNode a = headA;
            ListNode b = headB;
            while (a != b) {
                a = a == null ? headB : a.next;
                b = b == null ?  headA : b.next;
            }
            return a;

        }
    }
}
