package lee.linkedlist;

/**
 * description: 合并两个有序链表
 *
 * @author JunchaoYao
 * @date 2021-01-27 19:39
 **/
public class MergeTwoLists {
    class Solution {
        //定义该函数是返回符合的头节点,两个节点中较小的一个
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }

            if (l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }

        }
    }
}
