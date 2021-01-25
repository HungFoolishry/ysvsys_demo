package lee.other;

import java.util.Arrays;
import java.util.Comparator;

/**
 * description: 最多不重叠子区间
 *
 * @author JunchaoYao
 * @date 2021-01-23 22:49
 **/
public class EraseOverlapIntervals {
    static class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            if(intervals.length == 0){
                return 0;
            }
            //sort 是按照升序排，comparator 如果返回正数，则表示o1>o2
            Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
            int end = intervals[0][1];
            int count = 1;
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] >= end) {
                    end = intervals[i][1];
                    count++;
                }
            }
            return intervals.length - count;
       }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.eraseOverlapIntervals(new int[][]{{1,2},{2,3}}));
    }
}
