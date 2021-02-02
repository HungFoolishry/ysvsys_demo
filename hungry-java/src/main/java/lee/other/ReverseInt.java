package lee.other;

import java.util.Arrays;

/**
 * description: 整数反转
 *
 * @author JunchaoYao
 * @date 2020-12-11 16:04
 **/
public class ReverseInt {
    class Solution {
        public int reverse(int x) {
            long ans = 0;

            while (x != 0) {
                ans = ans * 10 + (x % 10) ;
                x = x / 10;
            }
            if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
                return 0;
            }
            return (int) ans;


        }
    }
//    static class Solution {
//        public int reverse(int x) {
//            int ans = 0;
//            while (x != 0) {
//                int pop = x % 10;
//                if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7))
//                    return 0;
//                if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8))
//                    return 0;
//                ans = ans * 10 + pop;
//                x /= 10;
//            }
//            return ans;
//        }
//    }

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        System.out.println(solution.reverse(1534236469));
//    }


}
