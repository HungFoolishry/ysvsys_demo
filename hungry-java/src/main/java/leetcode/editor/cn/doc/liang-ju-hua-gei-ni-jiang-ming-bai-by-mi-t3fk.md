**核心思想：把尽可能低位的最大数字与尽可能高位的小数字交换**

先从低位往高位遍历，保存每一位经过交换能得到的最大值的下标
再从高位往低位遍历，直到某一位小于该位可以取到的最大值，上一步保存了该位置最大值的下标，交换即可

### 代码

```java
class Solution {
    public int maximumSwap(int num) {
        char[] nums = Integer.toString(num).toCharArray();
        int[] index_arr = new int[nums.length];
        int max_index = nums.length - 1;
        //低位往高位遍历
        for(int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] > nums[max_index]) max_index = i;
            index_arr[i] = max_index;
        }
        //高位往低位遍历
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != nums[index_arr[i]]) {
                char temp = nums[i];
                nums[i] = nums[index_arr[i]];
                nums[index_arr[i]] = temp;
                break;
            }
        }
        return Integer.parseInt(new String(nums));
    }
}
```