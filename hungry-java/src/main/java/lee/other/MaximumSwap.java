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
        char[] A = Integer.toString(num).toCharArray();
        int[] last = new int[10];
        // 找到各位数字最后一次出现的下标
        for (int i = 0; i < A.length; i++) {
            last[A[i] - '0'] = i;
        }

        for (int i = 0; i < A.length; i++) {
            //从左往右遍历数字，如果右边有大的数字直接交换后返回
            for (int d = 9; d > A[i] - '0'; d--) {
                //保证在右边
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

    public static void main(String[] args) {
        System.out.println(maximumSwap(2736));
        System.out.println(maximumSwap(9973));

    }

}
