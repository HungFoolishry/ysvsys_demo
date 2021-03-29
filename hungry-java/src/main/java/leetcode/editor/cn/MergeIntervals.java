//以数组 intervals 表示若干个区间的集合，
// 其中单个区间为 intervals[i] = [starti, endi] 。
// 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
//
//
//
// 示例 1：
//
//
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//
//
// 示例 2：
//
//
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
//
//
//
// 提示：
//
//
// 1 <= intervals.length <= 104
// intervals[i].length == 2
// 0 <= starti <= endi <= 104
//
// Related Topics 排序 数组
// 👍 799 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            List<int[]> ans = new ArrayList<>();
            Arrays.sort(intervals, (a,b)->a[0]-b[0]);
            int m = intervals.length;
            int[] merged = intervals[0];
            for (int i = 1; i < m; i++) {
                if (merged[1] >= intervals[i][0]) {
                    merged[1] = Math.max(intervals[i][1], merged[1]);
                } else {
                    ans.add(merged);
                    merged = intervals[i];
                }
            }
            ans.add(merged);
            int[][] intervalsAns = new int[ans.size()][2];
            for (int i = 0; i < ans.size(); i++) {
                intervalsAns[i] = ans.get(i);
            }
            return intervalsAns;


        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}