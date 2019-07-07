package com.autodesk.leecode.arraypart;

public class L309_BuyStockWithCooldown {
    public static void run() {
        int[] nums={1,2,3,0,2};
        System.out.println("Buy stock with cooldown:"+maxProfit(nums));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int[] sell = new int[prices.length];
        int[] buy = new int[prices.length];
        sell[0] = 0;
        buy[0] = -prices[0];

        for (int i = 1; i < prices.length; ++i) {
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            buy[i] = Math.max(buy[i - 1], (i > 1 ? sell[i - 2] : 0) - prices[i]);
        }
        return sell[prices.length - 1];
    }
}
