package lee.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * description: 测试链表
 *
 * @author JunchaoYao
 * @date 2021-02-05 10:30
 **/
public class Test {
    public static void main(String[] args) {
        int[] inputs = new int[]{1, 2, 3, 4, 5, 6};
        ListNode head = new ListNode(inputs[0]);
        ListNode cur = head;
        for (int i = 1; i < inputs.length; i++) {
            cur.next = new ListNode(inputs[i]);
            cur = cur.next;
        }

    }

}
