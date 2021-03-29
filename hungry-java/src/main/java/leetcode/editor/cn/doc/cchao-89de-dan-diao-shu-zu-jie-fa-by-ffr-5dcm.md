![WX20210305-131202.png](https://pic.leetcode-cn.com/1614921946-ofopGE-WX20210305-131202.png)


### 解题思路
- 题目分析
1. 坑： 得注意这里A里有负数，所以没办法用双指针
2. 求和的问题自然想到前缀和， 假设当前和是 currSum ， 之前和是 preSum
    - currSum-preSum >= K 满足条件， 那么 currSum >= K + preSum , K是正数， 说明我们可以维持一个递增的前缀和才能满足条件
    - 如何找到最合理的preSum呢？ 因为要最短长度，那么就是取preSum对应的最大的编号，同时能满足 preSum <= currSum - K
    - 得到preSUm的最大编号j，基于当前编号i， 就能计算出对应的长度为 i-j
3. 整个遍历过程中，记录最小长度就是结果，如果没有则返回-1

### 代码

```cpp


class Solution {
private:
    // 用二分法来查找
    // 考虑不满足的情况，这里即使把r不断缩小依然还是要大于 maxSum，这里就是 l=0 返回属于无效值
    int Search(vector<pair<int, int>>& v, int maxSum)
    {
        int l = 0;
        int r = v.size()-1;
        while (l <= r)
        {
            int m = (l+r)/2;
            if (v[m].second > maxSum)
            {
                r = m-1;
            }
            else
            {
                l = m+1;
            }
        }
        return l;
    }

public:
    int shortestSubarray(vector<int>& A, int K) {
        // 记录编号 和 对应前缀和 的递增的前缀和数组
        vector<pair<int, int>> v;
        // 默认插入一个无效值，减少后续边缘的判断
        v.emplace_back(-1, 0);
        // 当前前缀和
        long currSum = 0;
        int n = A.size();
        // 最短长度
        int res = INT_MAX;
        for (int i = 0; i < n; ++i)
        {
            currSum += A[i];
            // 发现不满足单调递增，则需要弹出元素，保持单调性
            while (!v.empty() && v.back().second >= currSum)
            {
                v.pop_back();
            }

            // 找到满足条件preSum的最大编号, 这里需要满足 currSum - K
            int index = Search(v, currSum-K);
            // 只有 > 0说明满足条件，否则是找不到
            if (index > 0)
            {
                // 这里需要-1，因为查找时候对于有效值会额外+1来判断index有效性
                int j = v[index-1].first;
                res = min(res, i-j);
            }
            v.emplace_back(i, currSum);
        }
        // 额外判断是否找到
        return res != INT_MAX ? res : -1;
    }
};
```