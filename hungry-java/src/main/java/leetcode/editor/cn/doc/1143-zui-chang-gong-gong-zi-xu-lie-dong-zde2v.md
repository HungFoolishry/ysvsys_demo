最长公共子序列问题是经典的动规题目。

动规五部曲分析如下：

1. 确定dp数组（dp table）以及下标的含义

dp[i][j]：长度为[0, i - 1]的字符串text1与长度为[0, j - 1]的字符串text2的最长公共子序列为dp[i][j] 

那有同学问了，为什么要定义长度为[0, i - 1]的字符串text1，定义为长度为[0, i]的字符串text1不香么？ 

这样定义是为了后面代码实现方便，如果非要定义为为长度为[0, i]的字符串text1也可以，大家可以试一试！

2. 确定递推公式

主要就是两大情况： text1[i - 1] 与 text2[j - 1]相同，text1[i - 1] 与 text2[j - 1]不相同 

如果text1[i - 1] 与 text2[j - 1]相同，那么找到了一个公共元素，所以dp[i][j] = dp[i - 1][j - 1] + 1; 

如果text1[i - 1] 与 text2[j - 1]不相同，那就看看text1[0, i - 2]与text2[0, j - 1]的最长公共子序列 和 text1[0, i - 1]与text2[0, j - 2]的最长公共子序列，取最大的。

即：dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]); 

代码如下：

```C++
if (text1[i - 1] == text2[j - 1]) {
    dp[i][j] = dp[i - 1][j - 1] + 1;
} else {
    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
}
```

3. dp数组如何初始化  

先看看dp[i][0]应该是多少呢？ 

test1[0, i-1]和空串的最长公共子序列自然是0，所以dp[i][0] = 0;

同理dp[0][j]也是0。

其他下标都是随着递推公式逐步覆盖，初始为多少都可以，那么就统一初始为0。

代码：

```
vector<vector<int>> dp(text1.size() + 1, vector<int>(text2.size() + 1, 0));
```  

PS：**相信很多小伙伴刷题的时候面对力扣上近两千道题目，感觉无从下手**，我花费半年时间整理了Github项目：[leetcode刷题攻略](https://github.com/youngyangyang04/leetcode-master)。 里面有**100多道经典算法题目刷题顺序、配有40w字的详细图解，常用算法模板总结，以及难点视频讲解**，按照list一道一道刷就可以了！star支持一波吧！


4. 确定遍历顺序

从递推公式，可以看出，有三个方向可以推出dp[i][j]，如图：

![1143.最长公共子序列](https://pic.leetcode-cn.com/1612411335-CFYqFG-file_1612411331866)

那么为了在递推的过程中，这三个方向都是经过计算的数值，所以要从前向后，从上到下来遍历这个矩阵。

5. 举例推导dp数组

以输入：text1 = "abcde", text2 = "ace" 为例，dp状态如图：

![1143.最长公共子序列1](https://pic.leetcode-cn.com/1612940574-NOKTgR-file_1612940573925)


最后红框dp[text1.size()][text2.size()]为最终结果 

以上分析完毕，C++代码如下：

```C++
class Solution {
public:
    int longestCommonSubsequence(string text1, string text2) {
        vector<vector<int>> dp(text1.size() + 1, vector<int>(text2.size() + 1, 0));
        for (int i = 1; i <= text1.size(); i++) {
            for (int j = 1; j <= text2.size(); j++) {
                if (text1[i - 1] == text2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.size()][text2.size()];
    }
};
``` 

> 我是程序员Carl，可以找我[组队刷题](https://img-blog.csdnimg.cn/20201115103410182.png)，「代码随想录」目前正在循序渐进讲解算法，目前已经讲到了动态规划，[点击这里](https://img-blog.csdnimg.cn/20210102121706654.png)和上万录友一起打卡学习，来看看，你一定会发现相见恨晚！

**如果感觉题解对你有帮助，不要吝啬给一个👍吧！**
