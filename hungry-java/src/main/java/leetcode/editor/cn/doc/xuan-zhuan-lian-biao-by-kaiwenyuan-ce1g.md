### 解题思路
1.遍历链表，找到链表尾部的最后一个节点，链接链表的头部。同时计算链表的长度n。
2.寻找移动k位后的链表头部和尾部。
由题意可知，向右移动1位，新的链表头为原来的第n个节点，尾为第n-1个节点，
向右移动2位，新的链表头为n-1个节点，表尾为第n-2个节点...
以此类推，向右移动k位，新的链表尾部为 第n-k%n，新的链表头为第n-k%n+1个节点，就是尾的下一个。
由头向后移动 n-k%n-1步，得到尾节点，存储下一个节点为头节点，将尾节点指向null。

k有可能大于链表的长度，但是每移动n位又恢复为原来的链表，所以k先%n，再进行计算，结果相同。

### 代码

```java
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

 //旋转链表
 //先连成环 再从头开始寻找
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||k==0)return head;
        ListNode tmp=head;
        int len=1;
        while(tmp.next!=null){
            tmp=tmp.next;
            len++;    //计算链表长度
            }
        tmp.next=head; //链接首尾
        ListNode tail=head;
        //寻找链表尾和链表头
        for(int i=1;i<len-k%len;i++){
            tail=tail.next;
        }
            head=tail.next;
            tail.next=null;    
        
        return head;

    }
}
```