package lee.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * description: 数组数字加一
 *
 * @author JunchaoYao
 * @date 2020-12-23 10:31
 **/
public class PlusOne {
    class Solution {
        public int[] plusOne(int[] digits) {
            for (int i = digits.length - 1; i >= 0; i--) {
                digits[i]++;
                digits[i] = digits[i] % 10;
                if (digits[i] != 0) {
                    return digits;
                }
            }
            digits = new int[digits.length + 1];
            digits[0] = 1;
            return digits;
        }
    }

}
