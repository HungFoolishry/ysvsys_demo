//根据一棵树的中序遍历与后序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// Related Topics 树 深度优先搜索 数组
// 👍 472 👎 0


package leetcode.editor.cn;


import leetcode.editor.cn.base.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        }

        private TreeNode build(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd) {
            if (pEnd < pStart || iEnd < iStart) {
                return null;
            }
            int rootVal = postorder[pEnd];
            TreeNode root = new TreeNode(rootVal);
            int rootIndex = 0;
            for (int i = iStart; i <= iEnd; i++) {
                if (rootVal == inorder[i]) {
                    rootIndex = i;
                    break;
                }
            }
            int leftSize = rootIndex - iStart;
            // pEnd 计算逻辑就是，pEnd - pStart +1 = size
            // [0-4]有五个节点，然后知道pStart，size要推理pEnd = pStart +size -1
            root.left = build(inorder, iStart, rootIndex - 1, postorder, pStart, pStart + leftSize - 1);
            root.right = build(inorder, rootIndex + 1, iEnd, postorder, pStart + leftSize, pEnd - 1);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}