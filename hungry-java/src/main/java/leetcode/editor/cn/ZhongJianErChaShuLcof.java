//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//
//
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
//
//
//
// 限制：
//
// 0 <= 节点个数 <= 5000
//
//
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/
// Related Topics 树 递归
// 👍 317 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

public class ZhongJianErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new ZhongJianErChaShuLcof().new Solution();
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return buildTree(preorder,0,preorder.length-1, inorder,0,inorder.length-1);
        }
        public TreeNode buildTree(int[] preorder, int preI,int preJ,int[] inorder, int inI,int inJ){
            if(preI >preJ||inI>inJ){
                return null;
            }
            TreeNode root = new TreeNode(preorder[preI]);
            int mid=0;
            for(int i = inI;i<=inJ;i++){
                if(root.val == inorder[i]){
                    mid = i;
                    break;
                }
            }
            //只能计算左边节点的长度，本节点不计算在内
            int len = mid - inI;
            root.left = buildTree(preorder,preI+1,preI+len,inorder,inI,mid-1);
            root.right = buildTree(preorder,preI+len+1,preJ,inorder,mid+1,inJ);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}