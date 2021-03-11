## 用 API

```py
class Solution:

    def __init__(self, A: List[int]):
        self.pre = [A[0]]
        for i in range(1, len(A)):
            self.pre.append(self.pre[-1] + A[i])
    def pickIndex(self) -> int:
        rd = int(random.random() * self.pre[-1] + 1)
        return bisect.bisect_left(self.pre, rd)
```

**复杂度分析**

- 时间复杂度：*O(logN)*，其中 N 为数组长度。
- 空间复杂度：*O(1)*。
## 自己实现

```py
class Solution:

    def __init__(self, A: List[int]):
        self.pre = [A[0]]
        for i in range(1, len(A)):
            self.pre.append(self.pre[-1] + A[i])
    def pickIndex(self) -> int:
        rd = int(random.random() * self.pre[-1])
        l, r = 0, len(self.pre) - 1
        # 插入最左模板
        while l < r:
            mid = (l + r) // 2
            if self.pre[mid] > rd:
                # mid 是一个备胎
                r = mid
            else:
                # mid + 1 是一个备胎
                l = mid + 1
        # 由于 l 和 r 相等，因此返回谁都无所谓。那我就返回 l ，刚好和 最左模板的右对应
        return l
```

**复杂度分析**

- 时间复杂度：*O(logN)*，其中 N 为数组长度。
- 空间复杂度：*O(1)*。