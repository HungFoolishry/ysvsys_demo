//给定一个二叉树，检查它是否是镜像对称的。
//
//
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//
//
//
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
//
//
//
//
// 进阶：
//
// 你可以运用递归和迭代两种方法解决这个问题吗？
// Related Topics 树 深度优先搜索 广度优先搜索
// 👍 1267 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

public class SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
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
        public boolean isSymmetric(TreeNode root) {
            return isSymmetric(root, root);
        }

        public boolean isSymmetric(TreeNode node1, TreeNode node2) {
            if (node1 == null && node2 == null) {
                return true;
            } else if (node1 == null || node2 == null) {
                return false;
            }
            if (node1.val != node2.val) {
                return false;
            }
            return isSymmetric(node1.right, node2.left) && isSymmetric(node1.left, node2.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}