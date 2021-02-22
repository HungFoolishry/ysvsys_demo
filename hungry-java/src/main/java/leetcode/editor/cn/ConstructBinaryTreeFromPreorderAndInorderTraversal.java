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

public class ConstructBinaryTreeFromPreorderAndInorderTraversal{
    public static void main(String[] args) {
         Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    public TreeNode build(int[] preorder,int pStart,int pEnd, int[] inorder,int iStart,int iEnd) {
        if (pStart > pEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pStart]);
        int mid = 0;
        for (int i = iStart; i <= iEnd; i++) {
            if (preorder[pStart] == inorder[i]) {
                mid = i;
                break;
            }
        }
        int len = mid - iStart;
        root.left = build(preorder, pStart + 1, pStart + len, inorder, iStart, mid - 1);
        root.right = build(preorder, pStart + len + 1, pEnd, inorder, mid + 1, iEnd);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}