package lee.tree;

/**
 * description: 二叉树最大深度
 *
 * @author JunchaoYao
 * @date 2020-11-02 11:38
 **/
public class MaxDepth {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {


        // 计算本节点为根的深度 == Max(左深，右深)+1；
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            // 取左右节点中深度一个节点 并且 + 1 本节点 返回给父节点
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

        }
    }
}
