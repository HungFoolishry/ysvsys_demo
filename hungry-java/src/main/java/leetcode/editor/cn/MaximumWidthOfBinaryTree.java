//给定一个二叉树，编写一个函数来获取这个树的最大宽度。
// 树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节
//点为空。
//
// 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
//
// 示例 1:
//
//
//输入:
//
//           1
//         /   \
//        3     2
//       / \     \
//      5   3     9
//
//输出: 4
//解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
//
//
// 示例 2:
//
//
//输入:
//
//          1
//         /
//        3
//       / \
//      5   3
//
//输出: 2
//解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
//
//
// 示例 3:
//
//
//输入:
//
//          1
//         / \
//        3   2
//       /
//      5
//
//输出: 2
//解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
//
//
// 示例 4:
//
//
//输入:
//
//          1
//         / \
//        3   2
//       /     \
//      5       9
//     /         \
//    6           7
//输出: 8
//解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
//
//
// 注意: 答案在32位有符号整数的表示范围内。
// Related Topics 树
// 👍 204 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MaximumWidthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumWidthOfBinaryTree().new Solution();
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
        int ans = 0;
        HashMap<Integer, Integer> left = new HashMap<>();
        public int widthOfBinaryTree(TreeNode root) {
            dfs(root, 0, 0);
            return ans;
        }

        public void dfs(TreeNode root, int depth, int pos) {
            if (root == null) {
                return;
            }

            dfs(root.left, depth + 1, 2 * pos);
            dfs(root.right, depth+1, 2*pos+1);
            int leftPoz = left.computeIfAbsent(depth, x->pos);
            ans = Math.max(pos - leftPoz+1, ans);

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}