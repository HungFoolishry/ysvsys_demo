package lee.other;


/**
 * description: 子字符查找
 *
 * @author JunchaoYao
 * @date 2020-12-17 10:07
 **/
public class StrStr {
    static class Solution {
        public int strStr(String haystack, String needle) {
            if (needle.isEmpty()) {
                return 0;
            }
            int[] next = getNextval(needle);
            return kmpSearch(haystack, needle, next);

        }

        public int kmpSearch(String haystack, String needle, int[] next)  {
            int i = 0;
            int j = 0;
            int hLen = haystack.length();
            int nLen = needle.length();
            while (i < hLen && j < nLen) {
                if (j == -1 || haystack.toCharArray()[i] == needle.toCharArray()[j]) {
                    i++;
                    j++;
                } else {
                    j = next[j];
                }
            }
            if (j == nLen) {
                return i - j;
            } else {
                return -1;
            }
        }
        public int[] getNextval(String needle)
        {
            int pLen = needle.length();
            char[] p = needle.toCharArray();
            int[] next = new int[pLen];
            next[0] = -1;
            int k = -1;
            int j = 0;
            while (j < pLen - 1)
            {
                //p[k]表示前缀，p[j]表示后缀
                if (k == -1 || p[j] == p[k])
                {
                    ++j;
                    ++k;
                    //较之前next数组求法，改动在下面4行
                    if (p[j] != p[k]) {
                        next[j] = k;   //之前只有这一行
                    } else
                        //因为不能出现p[j] = p[ next[j ]]，所以当出现时需要继续递归，k = next[k] = next[next[k]]
                    {
                        next[j] = next[k];
                    }
                }
                else
                {
                    k = next[k];
                }
            }
            return next;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("aabaab", "ABCDABD"));
    }

}
