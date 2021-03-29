### 解题思路
本题解借鉴了 **题解区**大佬 的思想 —— **`中根序`**：
> 1. dfs式 遍历整棵树
> 判断当前是否是第一个节点(最小节点)：
>>  若是，则让 head 指向 当前节点
>>  若不是，则让 前驱节点的右子指针 指向 当前节点
>
> 2. 让 当前节点的左子指针 指向 前驱节点
> 让 前驱节点 指向 当前节点
> 
> 3. 后续处理：
>>  让 head的左子指针 指向 最后一个节点
>>  让 最后一个节点的右子指针 指向 head
> 
> 形成闭环

### 运行结果
![image.png](https://pic.leetcode-cn.com/1615260675-GJTLLe-image.png)

### 代码

```java
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    private Node head;
    private Node preNode;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }

        dfs(root);
        /*
            后续处理：
                让 head的左子指针 指向 最后一个节点
                让 最后一个节点的右子指针 指向 head
            形成闭环
        */
        head.left = preNode;
        preNode.right = head;
        return head;
    }

    private void dfs(Node curRoot) {
        if (curRoot == null) {
            return;
        }

        dfs(curRoot.left);
        /*
            判断当前是否是第一个节点(最小节点)：
                若是，则让 head 指向 当前节点
                若不是，则让 前驱节点的右子指针 指向 当前节点
        */
        if (preNode == null) {
            head = curRoot;
        } else {
            preNode.right = curRoot;
        }
        curRoot.left = preNode; // 让 当前节点的左子指针 指向 前驱节点
        preNode = curRoot;  // 让 前驱节点 指向 当前节点
        dfs(curRoot.right);
    }

}
```
打卡181天，加油！！！
忙又忙，最近开始重新改写《C/SFramework》专栏的博文了
等改完后，就要开始学习些新的知识了
一起加油🦆