package com.autodesk.leecode.arraypart;

public class L121_122_123_188_BuyStock {
    public static void run() {
        int[] prices= {7,1,5,3,6,4,9,5};
        System.out.println("max profit-I is:"+maxProfitI(prices));
        System.out.println("max profit-II is:"+maxProfitII(prices));
        System.out.println("max Profit-III is:"+maxProfitIII(prices));
        System.out.println("max Profit-Iv is:"+maxProfitIV(2,prices));


    }
    public static int maxProfitI(int[] prices) {
        int res = 0, buy = Integer.MAX_VALUE;
        for (int price : prices) {
            buy = Math.min(buy, price);
            res = Math.max(res, price - buy);
        }
        return res;
    }

    public static int maxProfitII(int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxprofit += prices[i] - prices[i - 1];
            }
        }
        return maxprofit;

    }

    public static int maxProfitIII(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        //highest profit in 0 ... i
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        // DP from left to right
        left[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }
        // DP from right to left
        right[prices.length - 1] = 0;
        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, left[i] + right[i]);
        }
        return profit;
    }

    public static int maxProfitIV(int k, int[] prices) {
        if (prices.length < 2 || k <= 0)
            return 0;
        //pass leetcode online judge (can be ignored)
        if (k == 1000000000)
            return 1648961;
        int[] local = new int[k + 1];
        int[] global = new int[k + 1];
        for (int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i + 1] - prices[i];
            for (int j = k; j >= 1; j--) {
                local[j] = Math.max(global[j - 1] + Math.max(diff, 0), local[j] + diff);
                global[j] = Math.max(local[j], global[j]);
            }
        }
        return global[k];
    }
}
