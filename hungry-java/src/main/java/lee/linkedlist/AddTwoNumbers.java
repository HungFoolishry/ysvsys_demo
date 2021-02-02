package lee.linkedlist;

import java.util.List;

/**
 * description: 两数字相加
 *
 * @author JunchaoYao
 * @date 2021-01-28 11:17
 **/
public class AddTwoNumbers {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            add(l1, l2, 0);
            return l1;
        }
        // 获取加完后的node
        public ListNode add(ListNode l1, ListNode l2, int plus) {
            if (l1 == null) {
                if (plus == 1) {
                    return add(new ListNode(plus), l2, 0);
                }
                return l2;
            }
            if (l2 == null) {
                if (plus == 1) {
                    return add(l1,new ListNode(plus), 0);
                }
                return l1;
            }
            int sum = l1.val + l2.val + plus;
            int plusOne = sum / 10;
            sum = sum % 10;
            l1.val = sum;
            l1.next = add(l1.next, l2.next, plusOne);
            return l1;
        }
    }


}
