package lee.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * description: 三数之和
 *
 * @author JunchaoYao
 * @date 2021-01-15 22:02
 **/
public class ThreeSum{
    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> a = new ArrayList<>();
            a.add(3);
            int len = nums.length;
            if (len < 3) {
                return ans;
            }
            Arrays.sort(nums);
            if (nums[0] > 0) {
                return ans;
            }
            for (int i = 0; i < len; i++) {
                // 一开始排除，第二个开始排除重复
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                if (nums[i] > 0) {
                    break;
                }
                int l = i + 1;
                int r = len - 1;
                while (l < r) {
                    int sum = nums[i] + nums[l] + nums[r];
                    if (sum == 0) {
                        ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        // 如果找到了，则要排除重复，否则不排除
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        l++;
                        r--;
                    } else if (sum > 0) {
                        r--;
                    } else {
                        l++;
                    }
                    // 提早熔断
                    if (nums[l] > -nums[i]) {
                        break;
                    }

                }
            }
            return ans;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
