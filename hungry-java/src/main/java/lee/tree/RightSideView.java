package lee.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * description: 二叉树的右视图
 *
 * @author JunchaoYao
 * @date 2020-09-30 23:22
 **/
public class RightSideView {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            LinkedList<TreeNode> pList = new LinkedList<>();
            LinkedList<TreeNode> qList = new LinkedList<>();
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return null;
            }
            pList.add(root);
            while (!pList.isEmpty() || !qList.isEmpty()) {
                if (!pList.isEmpty()) {
                    for (TreeNode pNode : pList
                    ) {
                        if (pNode.left != null) {
                            qList.add(pNode.left);
                        }
                        if (pNode.right != null) {
                            qList.add(pNode.right);
                        }
                    }
                    result.add(pList.getLast().val);
                    pList.clear();
                    continue;
                }
                if (!qList.isEmpty()) {
                    for (TreeNode qNode : qList
                    ) {
                        if (qNode.left != null) {
                            pList.add(qNode.left);
                        }
                        if (qNode.right != null) {
                            pList.add(qNode.right);
                        }
                    }
                    result.add(qList.getLast().val);
                    qList.clear();
                    continue;
                }
            }
            return result;

        }
    }
//
//    class Solution {
//        public List<Integer> rightSideView(TreeNode root) {
//            Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
//            int max_depth = -1;
//
//            Stack<TreeNode> nodeStack = new Stack<TreeNode>();
//            Stack<Integer> depthStack = new Stack<Integer>();
//            nodeStack.push(root);
//            depthStack.push(0);
//
//            while (!nodeStack.isEmpty()) {
//                TreeNode node = nodeStack.pop();
//                int depth = depthStack.pop();
//
//                if (node != null) {
//                    // 维护二叉树的最大深度
//                    max_depth = Math.max(max_depth, depth);
//
//                    // 如果不存在对应深度的节点我们才插入
//                    if (!rightmostValueAtDepth.containsKey(depth)) {
//                        rightmostValueAtDepth.put(depth, node.val);
//                    }
//
//                    nodeStack.push(node.left);
//                    nodeStack.push(node.right);
//                    depthStack.push(depth+1);
//                    depthStack.push(depth+1);
//                }
//            }
//
//            List<Integer> rightView = new ArrayList<Integer>();
//            for (int depth = 0; depth <= max_depth; depth++) {
//                rightView.add(rightmostValueAtDepth.get(depth));
//            }
//
//            return rightView;
//        }
//    }
//    class Solution {
//        public List<Integer> rightSideView(TreeNode root) {
//            Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
//            int max_depth = -1;
//
//            Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
//            Queue<Integer> depthQueue = new LinkedList<Integer>();
//            nodeQueue.add(root);
//            depthQueue.add(0);
//
//            while (!nodeQueue.isEmpty()) {
//                TreeNode node = nodeQueue.remove();
//                int depth = depthQueue.remove();
//
//                if (node != null) {
//                    // 维护二叉树的最大深度
//                    max_depth = Math.max(max_depth, depth);
//
//                    // 由于每一层最后一个访问到的节点才是我们要的答案，因此不断更新对应深度的信息即可
//                    rightmostValueAtDepth.put(depth, node.val);
//
//                    nodeQueue.add(node.left);
//                    nodeQueue.add(node.right);
//                    depthQueue.add(depth+1);
//                    depthQueue.add(depth+1);
//                }
//            }
//
//            List<Integer> rightView = new ArrayList<Integer>();
//            for (int depth = 0; depth <= max_depth; depth++) {
//                rightView.add(rightmostValueAtDepth.get(depth));
//            }
//
//            return rightView;
//        }
//    }

}
