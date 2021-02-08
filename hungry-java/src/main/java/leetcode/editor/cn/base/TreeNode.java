package leetcode.editor.cn.base;

/**
 * description: 树节点
 *
 * @author JunchaoYao
 * @date 2021-01-26 10:42
 **/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
