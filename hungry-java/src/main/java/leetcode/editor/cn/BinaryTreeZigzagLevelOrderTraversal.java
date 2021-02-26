//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
//
// 例如：
//给定二叉树 [3,9,20,null,null,15,7],
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回锯齿形层序遍历如下：
//
//
//[
//  [3],
//  [20,9],
//  [15,7]
//]
//
// Related Topics 栈 树 广度优先搜索
// 👍 383 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            Deque<TreeNode> his = new LinkedList<>();
            his.add(root);
            while (!his.isEmpty()) {
                int size = his.size();
                LinkedList<Integer> tmp = new LinkedList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = his.removeFirst();
                    if (ans.size() % 2 == 0) {
                        tmp.addLast(cur.val);
                    } else {
                        tmp.addFirst(cur.val);
                    }
                    if (cur.left != null) {
                        his.add(cur.left);
                    }
                    if (cur.right != null) {
                        his.add(cur.right);
                    }
                }
                ans.add(tmp);
            }
            return ans;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}