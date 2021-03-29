### 解题思路
解法1：哈希表解法，O(N)时间O(N)空间。

解法2：moore投票法，O(N)时间，O(1)空间。本质上是利用两个变量cm, cn记录频率最高的两个元素m, n的频率，遇到m,n自增对应的频率，遇到非m,非n，自减cm,cn。最后再重置cm,cn为0，再遍历一遍数组查看获取的最高频率的m，n的频率是否大于1/3的总元素个数。因为有可能最高频率的元素并不大于1/3的总元素个数(比如[1,1,2,2,3,4,5,6,7,8,9])

### 代码

```cpp
class Solution1 {
public:
    vector<int> majorityElement(vector<int>& nums) {
        if (nums.empty()) {
            return {};
        }

        vector<int> res;
        int N = nums.size();
        unordered_map<int, int> mp;
        for (const auto& num : nums) {
            mp[num]++;
        }

        for (const auto& m : mp) {
            if (m.second > N / 3) {
                res.push_back(m.first);
            }
        }

        return res;
    }
};

// 摩尔投票法 Moore Voting
class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        if (nums.empty()) {
            return {};
        }

        int m = 0;
        int cm = 0;
        int n = 0;
        int cn = 0;
        for (const auto& num : nums) {
            if (m == num) {
                cm++;
            } else if (n == num) {
                cn++;
            } else if (cm == 0) {
                m = num;
                cm++;
            } else if (cn == 0) {
                n = num;
                cn++;
            } else {
                cm--;
                cn--;
            }
        }

        cm = 0;
        cn = 0;
        for (const auto& num : nums) {
            if (num == m) {
                cm++;
            } else if (num == n) {
                cn++;
            }
        }

        vector<int> res;
        if (cm > nums.size() / 3) {
            res.push_back(m);
        }
        if (cn > nums.size() / 3) {
            res.push_back(n);
        }
        return res;
    }
};
```