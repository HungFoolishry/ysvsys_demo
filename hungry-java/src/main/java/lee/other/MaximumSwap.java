package lee.other;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * description: 换位得最大
 *
 * @author JunchaoYao
 * @date 2020-10-15 23:41
 **/
public class MaximumSwap {
        public static int maximumSwap(int num) {
            LinkedList<Integer> nums = new LinkedList<>();
            Integer input = num;
            while (!input.equals(0)) {
                nums.add(0, input % 10);
                input = input / 10;
            }
            int result = 0;
            boolean hasChanged = Boolean.FALSE;
            while (!nums.isEmpty()) {
                Integer maxInt = nums.stream().max(Comparator.comparing(Integer::valueOf)).get();
                Integer head = nums.removeFirst();
                if (!hasChanged) {
                    if (!head.equals(maxInt)) {
                        int index = nums.lastIndexOf(maxInt);
                        nums.set(index, head);
                        hasChanged = Boolean.TRUE;
                        head = maxInt;
                    }
                }

                result = result * 10 + head;
            }
            return result;

        }
    class Solution {
        public int maximumSwap(int num) {
            char[] A = Integer.toString(num).toCharArray();
            int[] last = new int[10];
            for (int i = 0; i < A.length; i++) {
                last[A[i] - '0'] = i;
            }

            for (int i = 0; i < A.length; i++) {
                for (int d = 9; d > A[i] - '0'; d--) {
                    if (last[d] > i) {
                        char tmp = A[i];
                        A[i] = A[last[d]];
                        A[last[d]] = tmp;
                        return Integer.valueOf(new String(A));
                    }
                }
            }
            return num;
        }
    }

    public static void main(String[] args) {
        System.out.println(maximumSwap(2736));
        System.out.println(maximumSwap(9973));

    }

}
