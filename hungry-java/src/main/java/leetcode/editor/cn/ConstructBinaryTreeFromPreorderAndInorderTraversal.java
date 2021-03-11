//根据一棵树的前序遍历与中序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// Related Topics 树 深度优先搜索 数组
// 👍 876 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return dfs(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        public TreeNode dfs(int[] preorder, int preI, int preJ, int[] inorder, int inI, int inJ) {
            if (preI > preJ || inI > inJ) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[preI]);
            int rootIndex = 0;
            for (int i = inI; i <= inJ; i++) {
                if (inorder[i] == preorder[preI]) {
                    rootIndex = i;
                    break;
                }
            }
            int leftLen = rootIndex - inI;
            root.left = dfs(preorder,preI+1,preI+leftLen, inorder,inI, rootIndex);
            root.right = dfs(preorder, preI + leftLen + 1, preJ, inorder, rootIndex + 1, inJ);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}