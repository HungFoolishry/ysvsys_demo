### 解题思路
先对数组进行排序
初始化DP数组 让每个值都是1（最少也是一个）
遍历所有的信封 找当前信封之前的DP数组最大值，加一就是当前能放下的最多信封

### 代码

```golang
func maxEnvelopes(envelopes [][]int) int {
    sort.Slice(envelopes,func(i,j int)bool{
       return  envelopes[i][0]<envelopes[j][0]
    })
    dp:=make([]int,len(envelopes))
   for i,_:=range dp{
       dp[i]=1
   }
    MM:=0
    for i:=0;i<len(dp);i++{
        
        for j:=0;j<i;j++{
            if envelopes[i][0]>envelopes[j][0]&&envelopes[i][1]>envelopes[j][1]{
                dp[i]=max(dp[i],dp[j]+1)
               
            }
        } 
        MM=max(MM,dp[i])
    }
    return MM
}
func max(a,b int)int{
    if a>b{
        return a
    }
    return b
}
```