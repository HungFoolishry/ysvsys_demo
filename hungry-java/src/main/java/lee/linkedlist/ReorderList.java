package lee.linkedlist;

import java.util.LinkedList;

/**
 * description: 重排链表
 *
 * @author JunchaoYao
 * @date 2020-10-20 19:45
 **/
public class ReorderList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        LinkedList<ListNode> nodeList = new LinkedList<>();
        ListNode tmpNode = head;
        while (tmpNode != null) {
            nodeList.push(tmpNode);
            tmpNode = tmpNode.next;
        }
        ListNode topNode = nodeList.pop();
        tmpNode = head;
        while (topNode != tmpNode) {
            ListNode tmp = tmpNode.next;
            tmpNode.next = topNode;
            topNode.next = tmp;
            tmpNode = tmp;
            if (tmp == topNode) {
                break;
            }
            topNode = nodeList.pop();
        }
        tmpNode.next = null;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        reorderList(node1);


    }
}
