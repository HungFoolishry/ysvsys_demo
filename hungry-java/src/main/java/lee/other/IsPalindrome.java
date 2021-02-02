package lee.other;

/**
 * description: 是否是回文数字
 *
 * @author JunchaoYao
 * @date 2021-01-28 17:50
 **/
public class IsPalindrome {
    class Solution {
        public boolean isPalindrome(int x) {
            int tmp = x;
            int ans = 0;
            int sign = 1;
            if (x < 0) {
                return false;
            }

            while (x != 0) {
                ans = ans * 10 + (x % 10) ;
                x = x / 10;
            }

            return tmp == sign * ans;

        }
    }
}
