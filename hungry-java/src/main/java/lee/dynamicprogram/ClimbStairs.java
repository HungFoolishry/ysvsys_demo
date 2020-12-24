package lee.dynamicprogram;

/**
 * description: 爬楼梯
 *
 * @author JunchaoYao
 * @date 2020-12-23 11:32
 **/
public class ClimbStairs {
    class Solution {
        private int sum;

        public Solution() {
            this.sum = 0;
        }

        private void leftStairs(int n) {
            if (n == 0) {
                sum++;
                return;
            }
            leftStairs(n - 1);
            leftStairs(n - 2);
        }

        public int climbStairs(int n) {
            leftStairs(n);
            return sum;
        }
    }
//    class Solution {
//        public int climbStairs(int n) {
//            int p = 0, q = 0, r = 1;
//            for (int i = 1; i <= n; ++i) {
//                p = q;
//                q = r;
//                r = p + q;
//            }
//            return r;
//        }
//    }

}
