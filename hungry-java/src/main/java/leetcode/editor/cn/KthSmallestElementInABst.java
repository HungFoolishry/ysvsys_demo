//给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
//
//
//
// 示例 1：
//
//
//输入：root = [3,1,4,null,2], k = 1
//输出：1
//
//
// 示例 2：
//
//
//输入：root = [5,3,6,2,4,null,null,1], k = 3
//输出：3
//
//
//
//
//
//
// 提示：
//
//
// 树中的节点数为 n 。
// 1 <= k <= n <= 104
// 0 <= Node.val <= 104
//
//
//
//
// 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
// Related Topics 树 二分查找
// 👍 354 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

public class KthSmallestElementInABst {
    public static void main(String[] args) {
        Solution solution = new KthSmallestElementInABst().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        private int ans;
        private int cur;
        public int kthSmallest(TreeNode root, int k) {
            cur = k;
            dfs(root);
            return ans;
        }

        public void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            if (cur == 1) {
                ans = root.val;
            }
            cur--;
            dfs(root.right);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}