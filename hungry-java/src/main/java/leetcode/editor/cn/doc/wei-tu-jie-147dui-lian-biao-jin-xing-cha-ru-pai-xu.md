#### 思路
- 先找到待插入的结点（前一个结点值比当前的大），移除，移除前保存。
- 将该结点插入到合适的位置——从头遍历比较，并插入。
#### 图例
cur 指针负责扫描整个链表，如果 cur.val <= cur.next.val，继续推进
```js
dummy      cur      cur.next  
  0   ->   -1    ->    5     ->     3     ->     4     ->    0
```
直到 cur.val > cur.next.val ，找到 cur.next，删除前保存给 temp。
```js
dummy                 cur        cur.next   cur.next.next
  0   ->   -1    ->    5     ->     3     ->     4     ->    0
```
删除后：
```js
dummy                 cur       cur.next  
  0   ->   -1    ->    5     ->     4     ->    0
temp
  3   ->   4   ->   0
```
现在要找插入的位置。**设置虚拟头结点**是因为，它可能插入到链表头，为了和插入到别的位置的操作一致，给头结点加一个前置结点。

用 prev 指针去推进，初始指向 dummy，如果 prev.next.val <= temp.val，继续推进
```js
prev 
dummy    prev.next     
  0   ->    -1    ->     5    ->    4     ->    0
temp
  3   ->   4   ->   0

dummy      prev      prev.next    
  0   ->    -1    ->     5    ->    4     ->    0
```
一旦 prev.next.val > temp.val ，temp 插入到 **prev 和 prev.next 之间**
```js
dummy      prev       temp     prev.next    
  0   ->    -1    ->    3    ->    5    ->    4    ->    0
```
这样就完成了一个“不对”的结点的插入，遍历整个链表，重复做这些事。

#### 代码
```golang []
func insertionSortList(head *ListNode) *ListNode {
    dummyHead := &ListNode{Val: 0}
    dummyHead.Next = head
    cur := head
    var prev *ListNode
    var temp *ListNode

    for cur != nil && cur.Next != nil { // cur指针扫整个链表
        if cur.Val <= cur.Next.Val {    // 符合递增，继续推进
            cur = cur.Next
        } else {                        // 找到需要变动的cur.Next
            temp = cur.Next             // 保存给temp
            cur.Next = cur.Next.Next    // 删除结点

            prev = dummyHead            // 从dummy开始扫，用prev推进，找插入的位置
            for prev.Next.Val <= temp.Val { // 继续推进
                prev = prev.Next
            }
            // 此时prev.Next.Val更大，插入到 prev 和 prev.Next 之间
            temp.Next = prev.Next 
            prev.Next = temp     // 先改temp.Next，再接给prev.Next
        }
    }

    return dummyHead.Next // 就算头结点发生改变了，也能通过dummyHead.Next获取到头结点
}
```
```javascript []
function insertionSortList(head) {
    const dummyHead = new ListNode(0);
    dummyHead.next = head;
    let cur = head;
    let prev = null;
    let temp = null;

    while (cur && cur.next) {
        if (cur.val <= cur.next.val) {
            cur = cur.next;
        } else {
            temp = cur.next;
            cur.next = cur.next.next;

            prev = dummyHead;
            while (prev.next.val <= temp.val) {
                prev = prev.next;
            }
            temp.next = prev.next;
            prev.next = temp;
        }
    }

    return dummyHead.next;
}
```
![image.png](https://pic.leetcode-cn.com/1605844933-kRoMox-image.png)

![image.png](https://pic.leetcode-cn.com/1605844872-CUftku-image.png)

#### 复盘总结
- 设置虚拟头结点的意义在于，使得所有插入情况的操作具有了一致性，且即使头结点发生改变，也能轻松获取到头结点
- 明确出步骤： 先找它 - 临时保存它 - 删掉它 - 给它找位置 - 插入它
- 插入要先改 temp.Next，再接到 prev 的后面，而不是先接到 prev 后面，再改 temp.Next，这样会丢失 prev.Next
#### 感谢阅读。