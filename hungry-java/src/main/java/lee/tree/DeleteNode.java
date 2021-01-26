package lee.tree;

/**
 * description: BST删除节点
 *
 * @author JunchaoYao
 * @date 2021-01-26 14:04
 **/
public class DeleteNode {
    class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {
                return null;
            }
            if (root.val == key) {
               //del 该节点有三种情况， 左 右 null
                if (root.left == null && root.right == null) {
                    return null;
                } else if (root.left == null || root.right == null) {
                    return root.left == null ? root.right : root.left;
                } else {
                    TreeNode maxNode = getMax(root.left);
                    root.val = maxNode.val;
                    root.left = deleteNode(root.left, maxNode.val);
                    return root;
                }
            }
            if (key < root.val) {
                root.left = deleteNode(root.left, key);
            } else if (key > root.val) {
                root.right = deleteNode(root.right, key);
            }
            return root;
        }

        public TreeNode getMax(TreeNode root) {
            while (root.right != null) {
                root = root.right;
            }
            return root;
        }
    }
}
