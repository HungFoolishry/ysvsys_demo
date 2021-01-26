package lee.tree;

/**
 * description: 从后序与中序遍历序列构造二叉树
 *
 * @author JunchaoYao
 * @date 2020-12-30 10:30
 **/
public class BuildTreeII {

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
            root.left = build(inorder, iStart, rootIndex - 1, postorder, pStart, pStart + leftSize-1);
            root.right = build(inorder, rootIndex+1, iEnd,postorder,pStart+leftSize,pEnd-1);
            return root;
        }
    }
}
