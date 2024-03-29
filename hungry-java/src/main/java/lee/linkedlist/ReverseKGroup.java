package lee.linkedlist;

/**
 * description: K个一组反转链表
 * 时间复杂度：O(n)
 * @author JunchaoYao
 * @date 2020-11-02 16:31
 **/
public class ReverseKGroup {
    class Solution {
        // 返回已经反转好的group的头节点
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode b = head;
            for (int i = 0; i < k; i++) {
                if (b ==null) {
                    return head;
                }
                b = b.next;
            }
            //反转每个group中的节点 并且返回头节点
            ListNode newHead = reverseAb(head, b);
            // a   nH            K return
            // -1<-2 null<-3<-4<-5
            head.next = reverseKGroup(b, k);
            return newHead;
        }

        public ListNode reverseAb(ListNode a, ListNode b) {
            ListNode pre = null;
            ListNode cur = a;
            while (cur != b) {
                ListNode nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }
            return pre;
        }
    }
//    class Solution {
//        // 反转k个节点 返回k个节点中的头节点
//        public ListNode reverseKGroup(ListNode head, int k) {
//            ListNode a = head;
//            ListNode b = head;
//            // 跳出递归的base case 如果不满足k个节点，则头节点就是一开始的头节点
//            for (int i = 0; i < k; i++) {
//                if (b == null) {
//                    return head;
//                }
//                b = b.next;
//            }
//            // newHead 为[a,b)的新头， 也就是b的前一个节点，所以a则为反转后的尾巴
//            ListNode newHead = reverseAb(a, b);
//            // 新尾巴->老头
//            a.next = reverseKGroup(b, k);
//            return newHead;
//
//        }
//        // 反转 [a,b) 返回b的前一个节点 并且a.next=null
//        private ListNode reverseAb(ListNode a, ListNode b) {
//            ListNode pre = null;
//            ListNode cur = a;
//            while (cur != b) {
//                ListNode nxt = cur.next;
//                cur.next = pre;
//                pre = cur;
//                cur = nxt;
//            }
//            return pre;
//        }
//
//        }

}
