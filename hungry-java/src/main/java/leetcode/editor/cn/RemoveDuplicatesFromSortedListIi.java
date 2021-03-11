//给定一个排序链表，删除所有含有重复数字的节点，
// 只保留原始链表中 没有重复出现 的数字。
//
// 示例 1:
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
//
//
// 示例 2:
//
// 输入: 1->1->1->2->3
//输出: 2->3
// Related Topics 链表
// 👍 468 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.base.ListNode;

public class RemoveDuplicatesFromSortedListIi{
    public static void main(String[] args) {
         Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null&&cur.next!=null) {
            if (cur.val == cur.next.val) {
                pre.next = null;
                while (cur.next !=null&&cur.val == cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;
            } else {
                pre.next =cur;
                pre = cur;
                cur = cur.next;
            }
        }
        pre.next = cur;
        return dummy.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}