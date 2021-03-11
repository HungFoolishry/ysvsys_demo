//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
//
// 进阶：
//
//
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
//
//
//
//
// 示例 1：
//
//
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
//
//
// 示例 2：
//
//
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
//
//
// 示例 3：
//
//
//输入：head = []
//输出：[]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 5 * 104] 内
// -105 <= Node.val <= 105
//
// Related Topics 排序 链表
// 👍 982 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.base.ListNode;

import java.util.List;

public class SortList {
    public static void main(String[] args) {
        Solution solution = new SortList().new Solution();
        int[] inputs = new int[]{1, 2, 3, 4, 5, 6};
        ListNode node = new ListNode(inputs[0]);
        ListNode cur = node;
        for (int i = 1; i < inputs.length; i++) {
            cur.next = new ListNode(inputs[i]);
            cur = cur.next;
        }
        System.out.println(solution.sortList(node));

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null) {
                return null;
            }
            if (head.next == null) {
                return head;
            }
            ListNode fast = head;
            ListNode slow = head;
            //
            ListNode pre = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                pre = slow;
                slow = slow.next;
            }
            ListNode mid = slow;
            pre.next = null;
            ListNode l1 = sortList(head);
            ListNode l2 = sortList(mid);
            return merge(l1, l2);

        }

        public ListNode merge(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            if (l1.val < l2.val) {
                l1.next = merge(l1.next, l2);
                return l1;
            } else {
                l2.next = merge(l1, l2.next);
                return l2;
            }
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}