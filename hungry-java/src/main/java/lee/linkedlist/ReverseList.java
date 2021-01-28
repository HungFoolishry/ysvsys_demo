package lee.linkedlist;

import javax.xml.soap.Node;
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
        // 递归法 可以用到区间反转
        // 迭代到最后一个节点，返回该节点，并且用该节点的前一个节点来操作后一个节点的指针
        // 最后将前一个节点的指针=null 完美作为之前的尾节点的终止base
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            if (head.next == null) {
                return head;
            }
            ListNode last = reverseList(head.next);
            head.next.next = head;
            // 防止原第一个节点于第二个节点产生环
            head.next = null;
            return last;
        }
        // 迭代法
        public ListNode reverseList2(ListNode head) {
            if (head == null) {
                return null;
            }
            //定义好初始值
            ListNode pre = null;
            while (head.next != null) {
                ListNode next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            head.next = pre;
            return head;

        }

    }
}
