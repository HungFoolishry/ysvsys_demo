package lee.dynamicprogram;

import java.util.ArrayList;
import java.util.List;

/**
 * description: 爬楼梯
 *
 * @author JunchaoYao
 * @date 2020-12-23 11:32
 **/
public class ClimbStairs {
    class Solution {
        public int climbStairs(int n) {
            int p = 0;
            int q = 1;
            int r = 0;
            for (int i = 1; i <= n; i++) {
                r = p + q;
                p = q;
                q = r;
            }
            return r;
        }
    }
}
