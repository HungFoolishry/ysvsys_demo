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
        int maxDeep;

        public Solution() {
            maxDeep = 0;
        }

        private void sumDeep(TreeNode node, int nowDeep) {
            if (node == null) {
                this.maxDeep = Math.max(this.maxDeep, nowDeep);
                return;
            }
            nowDeep++;
            sumDeep(node.left, nowDeep);
            sumDeep(node.right, nowDeep);
        }

        public int maxDepth(TreeNode root) {
            sumDeep(root, 0);
            return this.maxDeep;
        }
    }
}
