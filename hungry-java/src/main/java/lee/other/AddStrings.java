package lee.other;

/**
 * description: 字符串相加
 *
 * @author JunchaoYao
 * @date 2021-02-05 17:01
 **/
public class AddStrings {
    class Solution {
        public String addStrings(String num1, String num2) {
            StringBuilder ans = new StringBuilder("");
            int len1 = num1.length() - 1;
            int len2 = num2.length() - 1;
            int i = len1;
            int j = len2;
            int plus = 0;
            while (i >= 0 || j>= 0) {
                int iNum1 = i >= 0 ? num1.charAt(i) - '0' : 0;
                int iNum2 = j >= 0 ? num2.charAt(j) - '0' : 0;
                int add = iNum1 + iNum2 + plus;
                ans.append(add % 10);
                plus = add / 10;
                i--;
                j--;
            }
            if (plus == 1) {
                ans.append(plus);
            }
            return ans.reverse().toString();
        }
    }

}
