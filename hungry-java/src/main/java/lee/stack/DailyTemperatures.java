package lee.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * description: 每日温度
 *
 * @author JunchaoYao
 * @date 2021-01-21 15:40
 **/
public class DailyTemperatures {
     class Solution {
        public int[] dailyTemperatures(int[] T) {
            int len = T.length;
            int[] res = new int[len];
            Deque<Integer> s = new LinkedList<>();
            for (int i = len - 1; i >= 0; i--) {
                while (!s.isEmpty() && T[i] >= T[s.getFirst()]) {
                    s.pop();
                }
                res[i] =s.isEmpty() ? 0 :s.getFirst() -i;

                s.addFirst(i);

            }
            return res;
        }
    }

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        System.out.println(Arrays.toString(solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 76})));
//
//    }

}
