package leetcode.editor.stock;

/**
 * <p>
 * 309. 最佳买卖股票时机含冷冻期
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * <p>
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 * <p>
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * </p>
 *
 * @author edoup
 * @date 2020/12/23 0:54
 */
public class Code309 {

    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0];
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][2] = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);//手上持有股票的最大收益
            dp[i - 1][1] = dp[i - 1][1] + prices[i];//不持有股票，在冷冻期
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);//不持有股票，不在冷冻期
        }
        return Math.max(dp[n - 1][1], dp[n - 1][2]);
    }

}