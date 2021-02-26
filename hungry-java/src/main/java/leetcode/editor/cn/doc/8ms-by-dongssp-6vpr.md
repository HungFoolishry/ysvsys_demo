### 解题思路
传统DP。用数组会比vector快很多。

### 代码

```cpp
class Solution {
public:
    int longestCommonSubsequence(string s1, string s2) {
        int n = s1.size();
        int m = s2.size();
        // vector<vector<int>> dp(n+1,vector<int>(m+1));
        int dp[n+1][m+1];
        for(int i = 0 ; i <n+1;i++)
            for(int j = 0 ; j < m+1;j++)
                dp[i][j]=0;
        
        int res = 0;
        for(int i = 0 ; i < n ;i++){
            for(int j = 0 ; j < m;j++){
                
                if(s1[i]==s2[j]){
                    dp[i+1][j+1] = dp[i][j]+1;
                }
                else{
                     dp[i+1][j+1] = max(dp[i+1][j],dp[i][j+1]);
                }
                res = max(res,dp[i+1][j+1]);
                
            }
        }
        

        return res;
    }
};
```