package lee.other;

import java.util.Arrays;

/**
 * description: 整数反转
 *
 * @author JunchaoYao
 * @date 2020-12-11 16:04
 **/
public class ReverseInt {
    static class Solution {
        public int reverse(int x) {

            long max = (long) Math.pow(2, 31) - 1;
            long min = (long) - Math.pow(2, 31);

            Long resInt = 0L;
            int poz = 1;
            if (x < 0) {
                poz = -1;
                x = x * -1;
            }
            while (x != 0) {
                int left = x % 10;
                x = x / 10;
                if (resInt > resInt * 10 + left) {
                    return 0;
                }
                resInt = resInt * 10 + left;

            }
            resInt = poz * resInt;
            if (min >resInt || resInt > max) {
                return 0;
            }
            return resInt.intValue();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(1534236469));
    }

//    class Solution {
//        public int reverse(int x) {
//            int rev = 0;
//            while (x != 0) {
//                int pop = x % 10;
//                x /= 10;
//                if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
//                if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
//                rev = rev * 10 + pop;
//            }
//            return rev;
//        }
//    }

}
