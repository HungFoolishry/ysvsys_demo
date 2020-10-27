package lee.tree;

/**
 * description: 二叉树直径
 *
 * @author JunchaoYao
 * @date 2020-10-21 16:10
 **/
public class DiameterOfBinaryTree {
    Integer maxDeeps;

    public DiameterOfBinaryTree() {
        this.maxDeeps = 0;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int getMaxTreeLen(TreeNode node, Integer maxLen) {
        if (node == null) {
            return maxLen;
        }
        int leftLen = getMaxTreeLen(node.left, maxLen);
        int rightLen = getMaxTreeLen(node.right, maxLen);
        maxDeeps = Math.max(maxDeeps, leftLen + rightLen);
        return Math.max(leftLen, rightLen) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        Integer maxLen = 0;
        getMaxTreeLen(root, maxLen);
        return maxDeeps;
    }
}
