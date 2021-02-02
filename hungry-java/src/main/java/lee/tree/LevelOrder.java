package lee.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * description: 二叉树层序遍历
 *
 * @author JunchaoYao
 * @date 2020-12-29 19:29
 **/
public class LevelOrder {
    class Solution {
        public int[] levelOrder(TreeNode root) {

            List<Integer> ans = new ArrayList<>();
            Deque<TreeNode> nodes = new LinkedList<>();
            if (root == null) {
                return ans.stream().mapToInt(i -> i).toArray();
            }
            nodes.add(root);
            while (!nodes.isEmpty()) {
                int size = nodes.size();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = nodes.poll();
                    if (cur == null) {
                        continue;
                    }
                    ans.add(cur.val);
                    nodes.add(cur.left);
                    nodes.add(cur.right);
                }
            }
            int[] ans2 = ans.stream().mapToInt(i -> i).toArray();
            return ans2;
        }
    }
//    class Solution {
//        public int[] levelOrder(TreeNode root) {
//            if(root == null) return new int[0];
//            Queue<TreeNode> queue = new LinkedList<>(){{ add(root); }};
//            ArrayList<Integer> ans = new ArrayList<>();
//            while(!queue.isEmpty()) {
//                TreeNode node = queue.poll();
//                ans.add(node.val);
//                if(node.left != null) queue.add(node.left);
//                if(node.right != null) queue.add(node.right);
//            }
//            int[] res = new int[ans.size()];
//            for(int i = 0; i < ans.size(); i++)
//                res[i] = ans.get(i);
//            return res;
//        }
//    }
    }
