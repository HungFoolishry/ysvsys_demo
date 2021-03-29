### 解题思路
首先最暴力的就是穷举i和j，再计算他们的区间和判断和K的关系，时间：O(N^3)
接着我们如果给一个数组sum，sum[i]记录0-i的和，那么sum(i-j)=sum[j]-sum[i-1]，这省去一维穷举，时间O(N^2)
但是这样还是会超时的，这个时候我们考虑如下情况，首先穷举当前位置j，然后我们得到下面的结论：
- 假设存在sum[i]>=sum[j]且i<j，那么对于j后面的sum[j+]来说，选择i不如选择j，因此i就没有意义了，可以舍弃（因为区间和更小，但是需要的数字反而更多）
- 我们只要找到第一个sum[i]<=sum[j]-K，那么这个sum[i]也是当前情况下的最优解，这里我们反证：如果我们可以找到一个i'，使得：sum[i]>=sum[i']且i<i'，即i'是相对于i的更优解，那么这里的i就会因为上一条被舍弃，所以这一条结论成立

显然，在上面两条的结论之下，我们需要一种数据结构，可以支持如下的操作：
- 在最多logN的时间复杂度内找到最大值或者删除最大值
- 在最多logN的事件复杂度内找到小于给定值的最大值
很显然，这就是对应了Java的红黑树：TreeMap呀，直接使用TreeMap就可以得到下面的极简代码了。

### 代码

```java
class Solution {
    public int shortestSubarray(int[] A, int K) {
        int sum = 0, result = Integer.MAX_VALUE;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, -1);
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            Map.Entry<Integer, Integer> floorEntry = map.floorEntry(sum - K);
            if (floorEntry != null && i - floorEntry.getValue() < result)
                result = i - floorEntry.getValue();
            while (map.size() > 0 && map.lastKey() > sum) map.pollLastEntry();
            map.put(sum, i);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
```