package lee.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * description: 下一个更大的元素 环形
 *
 * @author JunchaoYao
 * @date 2021-01-21 16:33
 **/
public class NextGreaterElementsII {
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int len = nums.length;
            int[] ans = new int[len];
            Deque<Integer> s = new LinkedList<>();
            // 必须乘以2 因为后面一个大数值不确定在哪一个位置：[1,2,3,4,3]
            for (int i = len*2; i >=0 ; i--) {
                // 清理栈中不符合条件的元素
                while (!s.isEmpty() && s.getFirst() <= nums[i%len]) {
                    s.removeFirst();
                }
                ans[i%len] = s.isEmpty() ? -1 : s.getFirst();
                s.addFirst(nums[i%len]);
            }
            return ans;

        }
    }
}
