package lee.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * description: 中序遍历
 *
 * @author JunchaoYao
 * @date 2020-12-28 20:41
 **/
public class InorderTraversal {
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            inOrder(root, list);
            return list;
        }

        private void inOrder(TreeNode node, List<Integer> list) {
            if (node == null) {
                return;
            }
            inOrder(node.left, list);
            list.add(node.val);
            inOrder(node.right, list);
        }
    }
}
