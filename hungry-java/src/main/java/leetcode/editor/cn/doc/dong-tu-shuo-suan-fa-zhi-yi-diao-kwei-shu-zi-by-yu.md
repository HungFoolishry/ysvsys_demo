**栈**

下面我们来看一下用栈的解题思路，因为我们需要删除掉K位数字得到最小值，那么我们需要注意的是，删除的数字应该尽量在高位，则当前位小于前一位时，对前一位出栈，当前位入栈。大家思考一下思路是不是这样呢？

另外我们需要注意的是，仅删除K位数字，得到最小值，比如54321，我们删除3位，得到21。但是刚才我们说当前位小于前一位时，则前一位出栈，当前位入栈，所以我们需要加上删除K位的规则。

废话不多说我们直接上动图，把该题吃透！
 [移除K位数字.gif](https://pic.leetcode-cn.com/1605181136-FBpOje-%E7%A7%BB%E9%99%A4K%E4%BD%8D%E6%95%B0%E5%AD%97.gif)

PPT中的文字

> 这里需要注意的是，我们不需要将0入栈，因为0如果处于栈底，没有比它更小的值所以它不会被移除，我们只有在最后才有机会处理它。因为我们的010 = 10 ，首位0是需要在最后去掉的。所以我们这里可以直接不让其入栈，continue掉这次循环，也不改变K值，这样我们最后出栈处理时就不用考虑啦。这样逻辑就比官方题解好理解一些，也简洁一些。

> 这里需要注意的是，我们的K值还为2，我们目前仅删除2位数字，但是我们需要删除4位，但是后面的几位都是当前位大于前一位。所以我们需要在遍历结束后再移除后面最大的两位数字
```
class Solution {
    public String removeKdigits(String num, int k) {
        //特殊情况全部删除
        if(num.length() == k){
            return "0";
        }
        char[] s = num.toCharArray();
        Stack<Character> stack = new Stack<>();
        //遍历数组
        for(Character i : s){
          //移除元素的情况，k--
            while(!stack.isEmpty() && i < stack.peek() && k > 0){
                   stack.pop();
                   k--;
            }
            //栈为空，且当前位为0时，我们不需要将其入栈
            if(stack.isEmpty() && i == '0'){
                continue;
            }
            stack.push(i);
        }
        while(k > 0){
            stack.pop();
            k--;
        }
        //这个是最后栈为空时，删除一位，比如我们的10，删除一位为0，按上面逻辑我们会返回""，所以我们让其返回"0"
         if(stack.isEmpty()){
             return "0";
         }
         //反转并返回字符串
         StringBuilder str = new StringBuilder();
         while(!stack.isEmpty()){
             str.append(stack.pop());
         }
         return str.reverse().toString();
    }
}
```
另外我们新建了一个**刷题打卡小队**，每天**用小程序打卡**，**互相监督**，群内还有几位**大佬不定时指导讲解**，个人认为氛围还不错。需要的可以**看我简介**，或者点击小屋地址
另外还联合几位大佬**整理了一份经典必刷题，题目大纲**，需要的可以来我的小屋，在小屋内点击**刷题大纲**查看。
[小屋地址](https://cdn.jsdelivr.net/gh/tan45du/github.io.phonto2@master/myphoto/home.7ayqluk8rcw0.png)