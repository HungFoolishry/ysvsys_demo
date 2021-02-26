//已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。
//
// 不要使用系统的 Math.random() 方法。
//
//
//
//
//
//
// 示例 1:
//
//
//输入: 1
//输出: [7]
//
//
// 示例 2:
//
//
//输入: 2
//输出: [8,4]
//
//
// 示例 3:
//
//
//输入: 3
//输出: [8,1,10]
//
//
//
//
// 提示:
//
//
// rand7 已定义。
// 传入参数: n 表示 rand10 的调用次数。
//
//
//
//
// 进阶:
//
//
// rand7()调用次数的 期望值 是多少 ?
// 你能否尽量少调用 rand7() ?
//
// Related Topics Random Rejection Sampling
// 👍 153 👎 0


package leetcode.editor.cn;

public class ImplementRand10UsingRand7 {
    public static void main(String[] args) {
        Solution solution = new ImplementRand10UsingRand7().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * The rand7() API is already defined in the parent class SolBase.
     * public int rand7();
     *
     * @return a random integer in the range 1 to 7
     */
    class Solution extends SolBase {
        public int rand10() {
            //实现了1-49 的随机数 0 -6 * 7 + 1-7 ，0 7 14
            int bigRandom = (rand7() - 1) * 7 +rand7();
            while (bigRandom > 40) {
                bigRandom = (rand7() - 1) * 7 +rand7();
            }
            bigRandom = bigRandom % 10;
            return bigRandom + 1;

        }

    }

    //leetcode submit region end(Prohibit modification and deletion)
    private int rand7() {
        return 0;
    }
}