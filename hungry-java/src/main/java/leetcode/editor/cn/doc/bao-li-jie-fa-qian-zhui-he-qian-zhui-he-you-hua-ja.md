### 方法一：暴力解法（超时）
- 枚举左右边界（超时）。

**参考代码 1**：
```Java []
public class Solution {

    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int count = 0;
        for (int left = 0; left < len; left++) {
            for (int right = left; right < len; right++) {

                int sum = 0;
                for (int i = left; i <= right; i++) {
                    sum += nums[i];
                }
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};
        int k = 2;
        Solution solution = new Solution();
        int res = solution.subarraySum(nums, k);
        System.out.println(res);
    }
}
```
**复杂度分析**：

- 时间复杂度：*O(N^3)*，这里 *N* 是数组的长度；
- 空间复杂度：*O(1)*。
### 方法二：暴力解法的优化
+ 固定了起点，即先固定左边界，然后枚举右边界哈，时间复杂度降了一维。（感谢 [@ageovb](/u/ageovb/) 朋友帮我修改了描述）。

**参考代码 2**：
```Java []
public class Solution {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int len = nums.length;
        for (int left = 0; left < len; left++) {
            int sum = 0;
            // 区间里可能会有一些互相抵销的元素
            for (int right = left; right < len; right++) {
                sum += nums[right];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
```
**复杂度分析**：

- 时间复杂度：*O(N^2)*，这里 *N* 是数组的长度；
- 空间复杂度：*O(1)*。

### 方法三：前缀和

- 构建前缀和数组，以快速计算区间和；
- 注意在计算区间和的时候，下标有偏移。

**参考代码 3**：
```Java []
public class Solution {

    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        // 计算前缀和数组
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int count = 0;
        for (int left = 0; left < len; left++) {
            for (int right = left; right < len; right++) {
                // 区间和 [left..right]，注意下标偏移
                if (preSum[right + 1] - preSum[left] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
```
**复杂度分析**：

- 时间复杂度：*O(N^2)*，这里 *N* 是数组的长度；
- 空间复杂度：*O(N)*。

### 方法四：前缀和 + 哈希表优化

- 由于只关心次数，不关心具体的解，我们可以使用哈希表加速运算；
- 由于保存了之前相同前缀和的个数，计算区间总数的时候不是一个一个地加，时间复杂度降到了 *O(N)*。

这个思路不是很容易想到，需要多做一些类似的问题慢慢培养感觉。

- 同类问题有：
  - [「力扣」第 1 题：两数之和](https://leetcode-cn.com/problems/two-sum/)；
  - [「力扣」第 1248 题： 统计「优美子数组」](https://leetcode-cn.com/problems/count-number-of-nice-subarrays/)；
  - [「力扣」第 454 题：四数相加 II](https://leetcode-cn.com/problems/4sum-ii/)。

#### 解释一开始 `preSumFreq.put(0, 1);` 的意义

想一想算法的意思：

+ 计算完包括了当前数前缀和以后，我们去查一查在当前数之前，有多少个前缀和等于 `preSum - k` 呢？

这是因为满足 `preSum - (preSum - k) == k` 的区间的个数是我们所关心的。

+ 对于一开始的情况，下标 0 之前没有元素，可以认为前缀和为 0，个数为 1 个，因此 `preSumFreq.put(0, 1);`，这一点是必要且合理的。

具体的例子是：`nums = [3,...], k = 3`，和 `nums = [1, 1, 1,...], k = 3`。

**参考代码 4**：
```Java []
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int subarraySum(int[] nums, int k) {
        // key：前缀和，value：key 对应的前缀和的个数
        Map<Integer, Integer> preSumFreq = new HashMap<>();
        // 对于下标为 0 的元素，前缀和为 0，个数为 1
        preSumFreq.put(0, 1);

        int preSum = 0;
        int count = 0;
        for (int num : nums) {
            preSum += num;

            // 先获得前缀和为 preSum - k 的个数，加到计数变量里
            if (preSumFreq.containsKey(preSum - k)) {
                count += preSumFreq.get(preSum - k);
            }

            // 然后维护 preSumFreq 的定义
            preSumFreq.put(preSum, preSumFreq.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}
```
**复杂度分析**：

- 时间复杂度：*O(N)*，这里 *N* 是数组的长度；
- 空间复杂度：*O(N)*。

