//请判断一个链表是否为回文链表。
//
// 示例 1:
//
// 输入: 1->2
//输出: false
//
// 示例 2:
//
// 输入: 1->2->2->1
//输出: true
//
//
// 进阶：
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
// Related Topics 链表 双指针
// 👍 846 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.base.ListNode;

public class PalindromeLinkedList{
    public static void main(String[] args) {
         Solution solution = new PalindromeLinkedList().new Solution();
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
    private ListNode left;
    public boolean isPalindrome(ListNode head) {
        left = head;
        return check(head);
    }

    public boolean check(ListNode head) {
        if (head == null) {
            return true;
        }
        if (head.next == null) {
            return head.val == left.val;
        }
        boolean isPal = check(head.next);
        left = left.next;
        return isPal && left.val == head.val;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}