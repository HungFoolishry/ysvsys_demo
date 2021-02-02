package lee.tree;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Deque;
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

    class Solution {
        Deque<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null) {
                return ans;
            }
            q.add(root);
            while (!q.isEmpty()) {
                int size = q.size();
                Deque<Integer> ints = new LinkedList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = q.removeFirst();
                    if (ans.size() % 2 == 0) {
                        ints.addLast(cur.val);
                    }else {
                        ints.addFirst(cur.val);
                    }

                    if (cur.left != null) {
                        q.addLast(cur.left);
                    }
                    if (cur.right != null) {
                        q.addLast(cur.right);
                    }
                }
                ans.add(new ArrayList<>(ints));
            }
            return ans;

        }
    }
}
