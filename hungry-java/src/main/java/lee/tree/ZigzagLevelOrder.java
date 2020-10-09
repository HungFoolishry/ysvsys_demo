package lee.tree;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * description: 锯齿遍历二叉树
 *
 * @author JunchaoYao
 * @date 2020-09-30 23:22
 **/
public class ZigzagLevelOrder {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {

        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            Queue<TreeNode> rTreeList = new LinkedList<>();
            Queue<TreeNode> lTreeList = new LinkedList<>();
            if (root == null) {
                return result;
            }
            rTreeList.add(root);
            while (!rTreeList.isEmpty() || !lTreeList.isEmpty()) {
                List<Integer> tmpIntList;
                if (!rTreeList.isEmpty()) {
                    tmpIntList = new ArrayList<>();
                    TreeNode node;
                    while ((node = rTreeList.poll()) != null) {
                        tmpIntList.add(node.val);
                        if (node.left != null) {
                            lTreeList.add(node.left);
                        }
                        if (node.right !=null) {
                            lTreeList.add(node.right);
                        }
                    }
                } else {
                    tmpIntList = new ArrayList<>();
                    TreeNode node;
                    while ((node = lTreeList.poll()) != null) {
                        tmpIntList.add(0, node.val);
                        if (node.left != null) {
                            rTreeList.add(node.left);
                        }
                        if (node.right !=null) {
                            rTreeList.add(node.right);
                        }
                    }
                }
                if (!tmpIntList.isEmpty()) {
                    result.add(tmpIntList);
                }

            }
            return result;

        }
    }
}
