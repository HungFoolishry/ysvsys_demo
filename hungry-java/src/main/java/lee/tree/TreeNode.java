package lee.tree;

/**
 * description: 树节点
 *
 * @author JunchaoYao
 * @date 2021-01-26 10:42
 **/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
