//计算给定二叉树的所有左叶子之和。
//
// 示例：
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
//
//
// Related Topics 树
// 👍 296 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

public class SumOfLeftLeaves{
    public static void main(String[] args) {
         Solution solution = new SumOfLeftLeaves().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int ans;
    public int sumOfLeftLeaves(TreeNode root) {
        ans = 0;
        dfs(root, false);
        return ans;
    }

    public void dfs(TreeNode root, boolean isLeft) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && isLeft) {
            ans += root.val;
        }
        dfs(root.left, true);
        dfs(root.right, false);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}