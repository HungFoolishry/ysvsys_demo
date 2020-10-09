package lee.tree;

/**
 * description: 校验是否为完全二叉树
 *
 * @author JunchaoYao
 * @date 2020-09-30 10:22
 **/


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yao
 */
public class IsCompleteTreeSolution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    class Solution {
        public boolean isCompleteTree(TreeNode root) {
            if (root == null) {
                return true;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            TreeNode node = null;

            while ((node = queue.poll()) != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
            while (!queue.isEmpty()) {
                if (queue.poll() != null) {
                    return false;
                }
            }
            return true;

        }
    }

}
